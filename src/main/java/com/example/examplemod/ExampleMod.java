package com.example.examplemod;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import net.minecraft.client.settings.KeyBinding;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_RIGHT_SHIFT;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.server.FMLServerStartingEvent;
import net.minecraftforge.common.MinecraftForge;
import com.example.examplemod.Imgui;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("examplemod")
public class ExampleMod {
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final KeyBinding hello = new KeyBinding("key.imgui", GLFW_KEY_RIGHT_SHIFT, "key.categories.imgui");

    public ExampleMod() {
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onServerStarting);
    }
    
    private void onClientSetup(final FMLClientSetupEvent event) {
        ClientRegistry.registerKeyBinding(hello);
    }

    private void onServerStarting(final FMLServerStartingEvent event) {
        MinecraftForge.EVENT_BUS.register(new Imgui());
    }
}
