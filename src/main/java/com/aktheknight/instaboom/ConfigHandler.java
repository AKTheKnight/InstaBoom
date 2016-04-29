package com.aktheknight.instaboom;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
	
	public static Configuration config;
	static String category;
	static String configArray[] = new String[]{"CreeperInstaBoom","CreeperChance"};
	static List<String> configOrder = new ArrayList<String>(Arrays.asList(configArray));
	
	public static void init(File configFile) {
		config = new Configuration(configFile);
		loadConfig();
		
	}
	    
	static void loadConfig() {
//		loadGeneralSettings();
		loadGeneralSettings();
		if (config.hasChanged()) {
			config.save();
		}
	}
	
	private static void loadGeneralSettings() {
		config.setCategoryPropertyOrder(Configuration.CATEGORY_GENERAL , configOrder);
		category = Configuration.CATEGORY_GENERAL;
		InstaBoom.creeper = config.getBoolean("CreeperInstaBoom", category, true, "Do you want to enable creepers instantly exploding?");
		InstaBoom.creeperExplodeChance = config.getInt("CreeperChance", category, 5, 1, 20, "1 over the chance of an instant creeper explosion.");
	}
	
}
