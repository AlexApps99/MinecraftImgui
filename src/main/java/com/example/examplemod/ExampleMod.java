package com.example.examplemod;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraftforge.common.MinecraftForge;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.InputEvent.KeyInputEvent;
import net.minecraft.client.Minecraft;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_RIGHT_SHIFT;
import com.example.examplemod.MyMinecraftScreen;

@Mod("examplemod")
public class ExampleMod {
    public static final Logger LOGGER = LogManager.getLogger();

    public ExampleMod() {
    	MinecraftForge.EVENT_BUS.register(this);
    }
    
    @SubscribeEvent
    public void onKeyInput(KeyInputEvent event) {
    	if (Minecraft.getInstance().player != null && Minecraft.getInstance().currentScreen == null && event.getKey() == GLFW_KEY_RIGHT_SHIFT && event.getAction() == 1) {
    		Minecraft.getInstance().displayGuiScreen(new MyMinecraftScreen());
    	}
    }
}
