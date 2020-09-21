package andrews.pandoras_creatures.entities.goals.end_troll;

import java.util.EnumSet;
import java.util.Random;

import andrews.pandoras_creatures.entities.EndTrollBulletDamageEntity;
import andrews.pandoras_creatures.entities.EndTrollBulletPoisonEntity;
import andrews.pandoras_creatures.entities.EndTrollBulletWitherEntity;
import andrews.pandoras_creatures.entities.EndTrollEntity;
import andrews.pandoras_creatures.util.network.NetworkUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class EndTrollBulletAttackGoal extends Goal
{
	private EndTrollEntity goalOwner;
	private Random rand = new Random();

	public EndTrollBulletAttackGoal(EndTrollEntity goalOwner)
	{
		this.goalOwner = goalOwner;
		this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	}

	/**
	 * Returns whether the EntityAIBase should begin execution.
     */
	public boolean shouldExecute()
	{
		if(goalOwner.getEntityWorld().getDifficulty() == Difficulty.PEACEFUL)
		{
			return false;
		}
		LivingEntity livingentity =  goalOwner.getAttackTarget();
		if(livingentity != null && livingentity.isAlive() && !goalOwner.isAnimationPlaying(EndTrollEntity.SCREAM_ANIMATION) && !goalOwner.isAnimationPlaying(EndTrollEntity.DOUBLE_PUNCH_ANIMATION) && !goalOwner.isAnimationPlaying(EndTrollEntity.RIGHT_PUNCH_ANIMATION) && !goalOwner.isAnimationPlaying(EndTrollEntity.LEFT_PUNCH_ANIMATION) && !goalOwner.isWorldRemote())
		{
			return goalOwner.shootCooldown == 0;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Keep ticking a continuous task that has already been started
	 */
    public void tick()
    {	
		LivingEntity livingentity = goalOwner.getAttackTarget();
		goalOwner.getLookController().setLookPositionWithEntity(livingentity, 180.0F, 180.0F);
		double d0 = goalOwner.getDistanceSq(livingentity);
		if(d0 < 400.0D)
		{
			if(goalOwner.isAnimationPlaying(EndTrollEntity.BLANK_ANIMATION) && !goalOwner.getEntityWorld().isRemote())
        	{
        		NetworkUtil.setPlayingAnimationMessage(goalOwner, EndTrollEntity.SHOOT_ANIMATION);
        	}
			
			if(goalOwner.isAnimationPlaying(EndTrollEntity.SHOOT_ANIMATION) && goalOwner.getAnimationTick() == 9)
			{
				for(int i = 0; i < 5; i++)
				{
					goalOwner.world.addEntity(getRandomEndTrollBullet(goalOwner.world, goalOwner, livingentity, getAxis()));
				}
				goalOwner.playSound(SoundEvents.ENTITY_SHULKER_SHOOT, 2.0F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
				goalOwner.shootCooldown = 300;
			}
		}
		super.tick();
    }
    
    private Entity getRandomEndTrollBullet(World world, EndTrollEntity owner, LivingEntity targetEntity, Direction.Axis directionAxis)
    {
    	float xMotion = -MathHelper.sin(owner.prevRotationYawHead * ((float) Math.PI / 180F)) * MathHelper.cos(owner.rotationPitch * ((float) Math.PI / 180F));
    	float yMotion = -MathHelper.sin(owner.rotationPitch * ((float) Math.PI / 180F));
    	float zMotion = MathHelper.cos(owner.rotationYawHead * ((float) Math.PI / 180F)) * MathHelper.cos(owner.rotationPitch * ((float) Math.PI / 180F));
    	
		switch(rand.nextInt(3) + 1)
		{
		default:
		case 1:
			EndTrollBulletPoisonEntity bulletEntity0 = new EndTrollBulletPoisonEntity(world, owner, targetEntity, directionAxis);
			bulletEntity0.addVelocity(xMotion, yMotion, zMotion);
			return bulletEntity0;
		case 2:
			EndTrollBulletWitherEntity bulletEntity1 = new EndTrollBulletWitherEntity(world, owner, targetEntity, directionAxis);
			bulletEntity1.addVelocity(xMotion, yMotion, zMotion);
			return bulletEntity1;
		case 3:
			EndTrollBulletDamageEntity bulletEntity2 = new EndTrollBulletDamageEntity(world, owner, targetEntity, directionAxis);
			bulletEntity2.addVelocity(xMotion, yMotion, zMotion);
			return bulletEntity2;
		}
    }
    
    /**
     * return - Returns a Random Axis
     */
    private Direction.Axis getAxis()
    {
    	if(rand.nextInt(3) + 1 == 1)
    	{
    		return Direction.Axis.X;
    	}
    	if(rand.nextInt(3) + 1 == 2)
    	{
    		return Direction.Axis.Y;
    	}
    	if(rand.nextInt(3) + 1 == 3)
    	{
    		return Direction.Axis.Z;
    	}
    	
    	return Direction.Axis.X;
    }
}
