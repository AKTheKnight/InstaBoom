package com.aktheknight.instaboom;

import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=InstaBoom.MODID, name=InstaBoom.MODNAME, version=InstaBoom.VERSION,
        guiFactory = "com.aktheknight.instaboom.GuiFactory", acceptableRemoteVersions = "*")

public class InstaBoom {
	public static final String MODID = "InstaBoom";
	public static final String MODNAME = "InstaBoom";
	public static final String VERSION = "@VERSION@";
	
	@Mod.Instance
	public static InstaBoom instance;
	
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
        MinecraftForge.EVENT_BUS.register(instance);
	}

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
        if(eventArgs.getModID().equals(MODID)) {
            ConfigHandler.loadConfig();
        }
    }
	
}
