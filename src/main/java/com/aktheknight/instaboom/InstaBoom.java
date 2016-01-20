package com.aktheknight.instaboom;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=InstaBoom.MODID, name=InstaBoom.MODNAME, version=InstaBoom.VERSION)

public class InstaBoom {
	public static final String MODID = "InstaBoom";
	public static final String MODNAME = "InstaBoom";
	public static final String VERSION = "1.8.9-1.0.0";
	
	
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	
	Events handler = new Events();
	
	//Booleans
	public static boolean creeper;
	
	//ints:
	public static int creeperExplodeChance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		LOGGER.log(Level.INFO, "Loading/creating config file");
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		LOGGER.log(Level.INFO, "Registering event handlers");
		MinecraftForge.EVENT_BUS.register(handler);
	}
	
}
