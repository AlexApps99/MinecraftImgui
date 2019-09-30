package com.example.examplemod;

import imgui.ImGui;
import imgui.ImguiKt;
import imgui.imgui.Context;
import imgui.impl.gl.ImplGL3;
import imgui.impl.glfw.ImplGlfw;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import uno.glfw.GlfwWindow;

public class Imgui {
    private static ImGui imgui = ImGui.INSTANCE;

    private ImplGL3 implGl3;
    private ImplGlfw implGlfw;

    public Imgui() {
        ImguiKt.MINECRAFT_BEHAVIORS = true;
        GlfwWindow window = GlfwWindow.from(Minecraft.getInstance().mainWindow.getHandle());
        window.makeContextCurrent();
        new Context();
        implGlfw = new ImplGlfw(window, false, null);
        implGl3 = new ImplGL3();
    }

    @SubscribeEvent(receiveCanceled=true)
    public void afterRenderGameOverlay(RenderGameOverlayEvent.Post event) {
        if (YawnsMod.hello.isPressed()) {
            implGl3.newFrame();
            implGlfw.newFrame();

            imgui.newFrame();

            //Render things here

            imgui.text("Hello Minecraft!");

            //and stop here

            implGl3.renderDrawData(imgui.getDrawData());
        }
    }
}
