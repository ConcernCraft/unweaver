package io.github.concerncraft.unweaver.test.f3extensions.v0;

import io.github.concerncraft.unweaver.api.f3extensions.v0.F3FunctionCallback;
import net.minecraft.util.ActionResult;
import org.lwjgl.glfw.GLFW;

public class F3ExtTest {
    public static void clientInit() {
        F3FunctionCallback.EVENT.register((client, key) -> {
            if (key == GLFW.GLFW_KEY_F4) {
                System.out.println("e:b:ic");
                client.skipGameRender = !client.skipGameRender;
                return ActionResult.SUCCESS;
            }
            return ActionResult.PASS;
        });
    }
}
