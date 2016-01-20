package com.aktheknight.instaboom;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
	
	public static Configuration config;
	static String category;
	
	public static void init(File configFile) {
		config = new Configuration(configFile);
		loadConfig();
		
	}
	    
	private static void loadConfig() {
//		loadGeneralSettings();
		loadCreeperSettings();
		if (config.hasChanged()) {
			config.save();
		}
	}
	
	private static void loadCreeperSettings() {
		category = "Creeper";
		InstaBoom.creeper = config.getBoolean("CreeperInstaBoom", category, true, "Do you want to enable creepers instantly exploding?");
		InstaBoom.creeperExplodeChance = config.getInt("CreeperChance", category, 5, 1, 20, "1 over the chance of an instant creeper explosion.");
	}
	
}
