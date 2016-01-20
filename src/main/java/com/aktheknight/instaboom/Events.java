package com.aktheknight.instaboom;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.world.Explosion;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Events {
	
	public static final Logger LOGGER = LogManager.getLogger(InstaBoom.MODID);
	
	Random generator = new Random();
	
	@SubscribeEvent
	public void AttackEntity(AttackEntityEvent event) {
		if (!event.target.worldObj.isRemote) {
//			LOGGER.log(Level.FINEST, "Fired AttackEntityEvent");
			if (event.target instanceof EntityCreeper && InstaBoom.creeper) {
				isCreeper(event.target);
			}
			return;
		}
	}
	
	public void isCreeper(Entity creeper) {
//		LOGGER.log(Level.FINEST, "Entity was a creeper");
		if(chance(InstaBoom.creeperExplodeChance)) {
//			double x = creeper.posX;
//			double y = creeper.posY;
//			double z = creeper.posZ;
			
			Explosion explosion = new Explosion(creeper.worldObj, null, creeper.posX, creeper.posY, creeper.posZ, 4.0F, false, true);
			explosion.doExplosionA();
			explosion.doExplosionB(true);
			
			creeper.setDead();
		}
	}
	
	//Whether to run effect or not
	public boolean chance(int chance) {
		int i = generator.nextInt(chance);
		if (i + 1 == (chance)) {		
			return true;
		}
		return false;
	}
}
