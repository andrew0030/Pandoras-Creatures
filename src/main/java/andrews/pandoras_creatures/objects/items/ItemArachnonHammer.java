package andrews.pandoras_creatures.objects.items;

import java.util.Arrays;
import java.util.List;

import andrews.pandoras_creatures.Main;
import andrews.pandoras_creatures.objects.util.PCToolMaterials;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class ItemArachnonHammer extends PickaxeItem
{
	private Block[] blocks =
	{
		Blocks.END_STONE,
		Blocks.PRISMARINE,
		Blocks.PRISMARINE_BRICK_SLAB,
		Blocks.PRISMARINE_BRICK_STAIRS,
		Blocks.PRISMARINE_BRICKS,
		Blocks.PRISMARINE_SLAB,
		Blocks.PRISMARINE_STAIRS,
		Blocks.PRISMARINE_WALL,
		Blocks.NETHER_QUARTZ_ORE,
		Blocks.MAGMA_BLOCK,
		Blocks.INFESTED_CHISELED_STONE_BRICKS,
		Blocks.INFESTED_COBBLESTONE,
		Blocks.INFESTED_CRACKED_STONE_BRICKS,
		Blocks.INFESTED_MOSSY_STONE_BRICKS,
		Blocks.INFESTED_STONE,
		Blocks.INFESTED_STONE_BRICKS,
		Blocks.STONE_BRICK_STAIRS,
		Blocks.STONE_BRICK_WALL,
		Blocks.STONE_BRICKS,
		Blocks.CHISELED_STONE_BRICKS,
		Blocks.CRACKED_STONE_BRICKS,
		Blocks.END_STONE_BRICK_STAIRS,
		Blocks.END_STONE_BRICK_WALL,
		Blocks.END_STONE_BRICKS,
		Blocks.MOSSY_STONE_BRICK_STAIRS,
		Blocks.MOSSY_STONE_BRICK_WALL,
		Blocks.MOSSY_STONE_BRICKS,
		Blocks.MOSSY_COBBLESTONE,
		Blocks.MOSSY_COBBLESTONE_STAIRS,
		Blocks.MOSSY_COBBLESTONE_WALL,
		Blocks.COBBLESTONE_STAIRS,
		Blocks.COBBLESTONE_WALL,
		Blocks.TERRACOTTA,
		Blocks.BLACK_TERRACOTTA,
		Blocks.BLUE_TERRACOTTA,
		Blocks.BROWN_TERRACOTTA,
		Blocks.CYAN_TERRACOTTA,
		Blocks.GRAY_TERRACOTTA,
		Blocks.GREEN_TERRACOTTA,
		Blocks.LIGHT_BLUE_TERRACOTTA,
		Blocks.LIGHT_GRAY_TERRACOTTA,
		Blocks.LIME_TERRACOTTA,
		Blocks.MAGENTA_TERRACOTTA,
		Blocks.ORANGE_TERRACOTTA,
		Blocks.PINK_TERRACOTTA,
		Blocks.PURPLE_TERRACOTTA,
		Blocks.RED_TERRACOTTA,
		Blocks.WHITE_TERRACOTTA,
		Blocks.YELLOW_TERRACOTTA,
		Blocks.NETHER_BRICK_FENCE,
		Blocks.NETHER_BRICK_STAIRS,
		Blocks.NETHER_BRICK_WALL,
		Blocks.NETHER_BRICKS,
		Blocks.RED_NETHER_BRICK_STAIRS,
		Blocks.RED_NETHER_BRICK_WALL,
		Blocks.RED_NETHER_BRICKS,
		Blocks.IRON_BARS,
		Blocks.PURPUR_BLOCK,
		Blocks.PURPUR_PILLAR,
		Blocks.PURPUR_STAIRS,
		Blocks.END_ROD
	};
	
	public ItemArachnonHammer()
	{
		super(PCToolMaterials.arachnon_material, 0, -3.0F, getProperties());
	}
	
	private static Properties getProperties()
	{
		Properties properties = new Properties();
		properties.group(Main.PANDORAS_CREATURES_GROUP);
		
		return properties;
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
		tooltip.add(new StringTextComponent("§7When breaking blocks with"));
		tooltip.add(new StringTextComponent("§7this tool, it will break a"));
		tooltip.add(new StringTextComponent("§73x3 radious depending on"));
		tooltip.add(new StringTextComponent("§7the direction the player"));
		tooltip.add(new StringTextComponent("§7is facing."));
		tooltip.add(new StringTextComponent(""));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment)
	{
		if(enchantment == Enchantments.SILK_TOUCH)
		{
			return false;
		}
		else
		{
			return super.canApplyAtEnchantingTable(stack, enchantment);
		}
	}
	
	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, PlayerEntity player)
	{
		switch(getPlayerFacing(player))
		{
		case WEST:
			for(int z = -1; z < 2; z++)
			{
				for(int y = -1; y < 2; y++)
				{
					if(player.getEntityWorld().getBlockState(new BlockPos(pos.getX(), pos.getY() + y, pos.getZ() + z)).getHarvestTool() == ToolType.PICKAXE || Arrays.asList(blocks).contains(player.getEntityWorld().getBlockState(new BlockPos(pos.getX(), pos.getY() + y, pos.getZ() + z)).getBlock()))
					{
						dropExp(player, player.getEntityWorld().getBlockState(new BlockPos(pos.getX(), pos.getY() + y, pos.getZ() + z)).getBlock(), new BlockPos(pos.getX(), pos.getY() + y, pos.getZ() + z), itemstack);
						player.getEntityWorld().destroyBlock(new BlockPos(pos.getX(), pos.getY() + y, pos.getZ() + z), !player.isCreative());
					}
				}
			}
		break;
		case UP:
			for(int x = -1; x < 2; x++)
			{
				for(int z = -1; z < 2; z++)
				{
					if(player.getEntityWorld().getBlockState(new BlockPos(pos.getX() + x, pos.getY(), pos.getZ() + z)).getHarvestTool() == ToolType.PICKAXE || Arrays.asList(blocks).contains(player.getEntityWorld().getBlockState(new BlockPos(pos.getX() + x, pos.getY(), pos.getZ() + z)).getBlock()))
					{
						dropExp(player, player.getEntityWorld().getBlockState(new BlockPos(pos.getX() + x, pos.getY(), pos.getZ() + z)).getBlock(), new BlockPos(pos.getX() + x, pos.getY(), pos.getZ() + z), itemstack);
						player.getEntityWorld().destroyBlock(new BlockPos(pos.getX() + x, pos.getY(), pos.getZ() + z), !player.isCreative());
					}
				}
			}
		break;
		case SOUTH:	
			for(int x = -1; x < 2; x++)
			{
				for(int y = -1; y < 2; y++)
				{
					if(player.getEntityWorld().getBlockState(new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ())).getHarvestTool() == ToolType.PICKAXE || Arrays.asList(blocks).contains(player.getEntityWorld().getBlockState(new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ())).getBlock()))
					{
						dropExp(player, player.getEntityWorld().getBlockState(new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ())).getBlock(), new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ()), itemstack);
						player.getEntityWorld().destroyBlock(new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ()), !player.isCreative());
					}
				}
			}
		break;
		case NORTH:	
			for(int x = -1; x < 2; x++)
			{
				for(int y = -1; y < 2; y++)
				{
					if(player.getEntityWorld().getBlockState(new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ())).getHarvestTool() == ToolType.PICKAXE || Arrays.asList(blocks).contains(player.getEntityWorld().getBlockState(new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ())).getBlock()))
					{
						dropExp(player, player.getEntityWorld().getBlockState(new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ())).getBlock(), new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ()), itemstack);
						player.getEntityWorld().destroyBlock(new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ()), !player.isCreative());
					}
				}
			}
		break;
		case EAST:
			for(int z = -1; z < 2; z++)
			{
				for(int y = -1; y < 2; y++)
				{
					if(player.getEntityWorld().getBlockState(new BlockPos(pos.getX(), pos.getY() + y, pos.getZ() + z)).getHarvestTool() == ToolType.PICKAXE || Arrays.asList(blocks).contains(player.getEntityWorld().getBlockState(new BlockPos(pos.getX(), pos.getY() + y, pos.getZ() + z)).getBlock()))
					{
						dropExp(player, player.getEntityWorld().getBlockState(new BlockPos(pos.getX(), pos.getY() + y, pos.getZ() + z)).getBlock(), new BlockPos(pos.getX(), pos.getY() + y, pos.getZ() + z), itemstack);
						player.getEntityWorld().destroyBlock(new BlockPos(pos.getX(), pos.getY() + y, pos.getZ() + z), !player.isCreative());
					}
				}
			}
		break;
		case DOWN:
			for(int x = -1; x < 2; x++)
			{
				for(int z = -1; z < 2; z++)
				{
					if(player.getEntityWorld().getBlockState(new BlockPos(pos.getX() + x, pos.getY(), pos.getZ() + z)).getHarvestTool() == ToolType.PICKAXE || Arrays.asList(blocks).contains(player.getEntityWorld().getBlockState(new BlockPos(pos.getX() + x, pos.getY(), pos.getZ() + z)).getBlock()))
					{
						dropExp(player, player.getEntityWorld().getBlockState(new BlockPos(pos.getX() + x, pos.getY(), pos.getZ() + z)).getBlock(), new BlockPos(pos.getX() + x, pos.getY(), pos.getZ() + z), itemstack);
						player.getEntityWorld().destroyBlock(new BlockPos(pos.getX() + x, pos.getY(), pos.getZ() + z), !player.isCreative());
					}
				}
			}
		break;
		default:
		break;
		}
		return super.onBlockStartBreak(itemstack, pos, player);
	}
	
	private void dropExp(PlayerEntity player, Block block, BlockPos pos, ItemStack stack)
	{
		if(!player.isCreative())
		{
			int fortune = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, stack);
			int silktouch = EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, stack);
			int exp = block.getExpDrop(block.getDefaultState(), player.getEntityWorld(), pos, fortune, silktouch);
			block.dropXpOnBlockBreak(player.getEntityWorld(), pos, exp);
		}
	}
	
	private Direction getPlayerFacing(PlayerEntity player)
	{
		if(!player.getEntityWorld().isRemote)
		{
			if(player.getPitchYaw().x > 45)
			{
				return Direction.DOWN;
			}
			else if(player.getPitchYaw().x < -45)
			{
				return Direction.UP;
			}
			else
			{
				return player.getHorizontalFacing();
			}	
		}
		return Direction.DOWN;
	}
}
