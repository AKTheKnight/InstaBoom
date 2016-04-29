package com.aktheknight.instaboom;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.List;

/**
 * Created by alex on 29/04/16.
 */
public class ConfigGUI extends GuiConfig {

    public ConfigGUI(GuiScreen parent) {
        super(parent, new ConfigElement(ConfigHandler.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                "ShrinkCraft", false, false, GuiConfig.getAbridgedConfigPath(ConfigHandler.config.toString()));
    }
}
