package andrews.pandoras_creatures.objects.items;

import java.util.List;

import andrews.pandoras_creatures.Main;
import andrews.pandoras_creatures.objects.util.PCToolMaterials;
import andrews.pandoras_creatures.util.TranslationHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceContext.FluidMode;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootParameters;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class ItemArachnonHammer extends PickaxeItem
{	
	public ItemArachnonHammer()
	{
		super(PCToolMaterials.arachnon_material, 0, -3.0F, getProperties());
	}
	
	/**
	 * @return - The properties for this Item
	 */
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
		TranslationHelper.getTooltipFromLang(tooltip, "item.pandoras_creatures.arachnon_hammer.tooltip", stack);
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	
	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, PlayerEntity player)
	{
		if(player != null && !player.getEntityWorld().isRemote)
		{
			switch(getBlockSideHit(player))
			{
			case UP:
			case DOWN:
				for(int x = -1; x < 2; x++)
				{
					for(int z = -1; z < 2; z++)
					{
						if(!(x == 0 && z == 0))
						{
							BlockPos blockPos = new BlockPos(pos.getX() + x, pos.getY(), pos.getZ() + z);
							BlockState stateIn = player.getEntityWorld().getBlockState(blockPos);
							if(canHarvestBlock(player.getEntityWorld(), blockPos, stateIn))
							{
								processHarvest(player.getEntityWorld(), blockPos, stateIn, itemstack, player);
							}
						}
					}
				}
			break;
			case SOUTH:	
			case NORTH:
				for(int x = -1; x < 2; x++)
				{
					for(int y = -1; y < 2; y++)
					{
						if(!(x == 0 && y == 0))
						{
							BlockPos blockPos = new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ());
							BlockState stateIn = player.getEntityWorld().getBlockState(blockPos);
							if(canHarvestBlock(player.getEntityWorld(), blockPos, stateIn))
							{
								processHarvest(player.getEntityWorld(), blockPos, stateIn, itemstack, player);
							}
						}
					}
				}
			break;
			case EAST:
			case WEST:
				for(int z = -1; z < 2; z++)
				{
					for(int y = -1; y < 2; y++)
					{
						if(!(z == 0 && y == 0))
						{
							BlockPos blockPos = new BlockPos(pos.getX(), pos.getY() + y, pos.getZ() + z);
							BlockState stateIn = player.getEntityWorld().getBlockState(blockPos);
							if(canHarvestBlock(player.getEntityWorld(), blockPos, stateIn))
							{
								processHarvest(player.getEntityWorld(), blockPos, stateIn, itemstack, player);
							}
						}
					}
				}
			break;
			default:
			break;
			}
		}
		return super.onBlockStartBreak(itemstack, pos, player);
	}
	
	/**
	 * Used to check if the blockIn can be broken by this tool
	 * @param world - The world the player is in
	 * @param position - The position of the block that is being checked
	 * @param blockIn - The block that is being checked
	 * @return - Returns true if the block can be harvested
	 */
	public boolean canHarvestBlock(World world, BlockPos position, BlockState blockIn)
	{
	    int i = this.getTier().getHarvestLevel();
	    TileEntity tileentity = world.getTileEntity(position);
	    
	    //Makes sure the Block has no Tile Entity
	    if(tileentity != null)
	    {
	    	return false;
	    }
	    //Makes sure the Block isn't unbreakable
	    if(blockIn.getBlockHardness(world, position) == -1)
	    {
	    	return false;
	    }
	    //Checks if the effective tool is a Pick Axe and makes sure the mining level is met
	    if(blockIn.getHarvestTool() == ToolType.PICKAXE)
	    {
	    	return i >= blockIn.getHarvestLevel();
	    }
	    Material material = blockIn.getMaterial();
	    return material == Material.ROCK || material == Material.IRON || material == Material.ANVIL;
	}
	
	/**
	 * Used to "mine" a block
	 * @param world - The world the player is in
	 * @param pos - The block position
	 * @param state - The block state
	 * @param stack - The tool used
	 * @param player - The player using the tool
	 */
	private void processHarvest(World world, BlockPos pos, BlockState state, ItemStack stack, PlayerEntity player)
	{
		//Break the block
		world.destroyBlock(pos, false);
		if(!player.isCreative())//Checks if the player is Creative as there is no point in dropping the loot if he is.
		{
			LootContext.Builder builder = new LootContext.Builder((ServerWorld) world).withParameter(LootParameters.POSITION, pos).withParameter(LootParameters.TOOL, stack);
			for(ItemStack itemStack : state.getDrops(builder))
		    {
				ItemEntity item = new ItemEntity(world, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, itemStack);
		     	world.addEntity(item);
		     	dropExp(player, state.getBlock(), pos, stack);
		  	}
		}
	}
	
	//Calculates the experience a broken Block should drop if it has an experience value
	private void dropExp(PlayerEntity player, Block block, BlockPos pos, ItemStack stack)
	{
		int fortune = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, stack);
		int silktouch = EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, stack);
		int exp = block.getExpDrop(block.getDefaultState(), player.getEntityWorld(), pos, fortune, silktouch);
		block.dropXpOnBlockBreak(player.getEntityWorld(), pos, exp);
	}	
	
	/**
	 * Used to get the side of the block that got harvested
	 * @param player - The player that uses the tool
	 * @return - The direction of the side of the block that got harvested
	 */
	private Direction getBlockSideHit(PlayerEntity player)
	{
		RayTraceResult raycast = rayTraceFromPlayer(player.getEntityWorld(), player, FluidMode.NONE);
		if(!player.world.isRemote && raycast.getType() == RayTraceResult.Type.BLOCK)
		{
			Direction face = ((BlockRayTraceResult) raycast).getFace();
			return face.getOpposite();
		}
		else
		{
			return Direction.NORTH;
		}
	}
	
	/**
	 * Casts a ray from the player towards the harvested Block
	 * @param worldIn - The world the player is in
	 * @param player - The player that used the tool to harvest the block
	 * @param fluidMode - The FluidMode
	 * @return - A RayTraceResult
	 */
	private RayTraceResult rayTraceFromPlayer(World worldIn, PlayerEntity player, RayTraceContext.FluidMode fluidMode)
	{
		float f = player.rotationPitch;
		float f1 = player.rotationYaw;
		Vec3d vec3d = player.getEyePosition(1.0F);
		float f2 = MathHelper.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
		float f3 = MathHelper.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
		float f4 = -MathHelper.cos(-f * ((float)Math.PI / 180F));
		float f5 = MathHelper.sin(-f * ((float)Math.PI / 180F));
		float f6 = f3 * f4;
		float f7 = f2 * f4;
		double d0 = player.getAttribute(PlayerEntity.REACH_DISTANCE).getValue();;
		d0 = (d0 * 2);
		Vec3d vec3d1 = vec3d.add((double)f6 * d0, (double)f5 * d0, (double)f7 * d0);
		return worldIn.rayTraceBlocks(new RayTraceContext(vec3d, vec3d1, RayTraceContext.BlockMode.OUTLINE, fluidMode, player));
	}
}
