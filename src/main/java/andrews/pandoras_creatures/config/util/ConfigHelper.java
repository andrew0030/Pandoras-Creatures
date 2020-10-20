package andrews.pandoras_creatures.config.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.config.ModConfig.ModConfigEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ConfigHelper
{
	public static <T> T register(final ModConfig.Type configType, final BiFunction<ForgeConfigSpec.Builder, Subscriber, T> configBuilder, final String registerConfig)
	{
		return register(ModLoadingContext.get(), configType, configBuilder, registerConfig);
	}
	
	public static <T> T register(final ModLoadingContext modContext, final ModConfig.Type configType, final BiFunction<ForgeConfigSpec.Builder, Subscriber, T> configBuilder, final String registerConfig)
	{
		final List<ConfigValueListener<?>> subscriptionList = new ArrayList<>();
		final Pair<T, ForgeConfigSpec> entry = new ForgeConfigSpec.Builder().configure(builder -> configBuilder.apply(builder, getSubscriber(subscriptionList)));
		final T config = entry.getLeft();
		final ForgeConfigSpec spec = entry.getRight();

		modContext.registerConfig(configType, spec, registerConfig);

		final Consumer<ModConfigEvent> configUpdate = event ->
		{
			if(event.getConfig().getSpec() == spec)
			{
				for(ConfigValueListener<?> value : subscriptionList)
				{
					value.update();
				}
			}
		};

		FMLJavaModLoadingContext.get().getModEventBus().addListener(configUpdate);
		return config;
	}

	private static Subscriber getSubscriber(final List<ConfigValueListener<?>> list)
	{
		return new Subscriber(list);
	}

	public static class Subscriber
	{
		final List<ConfigValueListener<?>> list;

		Subscriber(final List<ConfigValueListener<?>> list)
		{
			this.list = list;
		}

		public <T> ConfigValueListener<T> subscribe(final ConfigValue<T> value)
		{
			return ConfigValueListener.of(value, this.list);
		}
	}

	public static class ConfigValueListener<T> implements Supplier<T>
	{
		private T value = null;
		private final ConfigValue<T> configValue;

		private ConfigValueListener(final ConfigValue<T> configValue)
		{
			this.configValue = configValue;
		}

		public static <T> ConfigValueListener<T> of(final ConfigValue<T> configValue, final List<ConfigValueListener<?>> valueList)
		{
			final ConfigValueListener<T> value = new ConfigValueListener<>(configValue);
			valueList.add(value);
			return value;
		}

		public void update()
		{
			this.value = this.configValue.get();
		}

		@Override
		public T get()
		{
			if(this.value == null)
			{
				this.update();
			}
			return this.value;
		}
	}

}
