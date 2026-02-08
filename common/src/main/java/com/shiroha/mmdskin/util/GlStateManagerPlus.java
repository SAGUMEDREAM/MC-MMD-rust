package com.shiroha.mmdskin.util;

import com.mojang.blaze3d.opengl.GlConst;
import com.mojang.blaze3d.opengl.GlStateManager;
import com.mojang.blaze3d.platform.DestFactor;
import com.mojang.blaze3d.platform.SourceFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL20;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class GlStateManagerPlus extends GlStateManager {

    public static void blendFunc(SourceFactor sourceFactor, DestFactor destFactor) {
        RenderSystem.assertOnRenderThread();
        _blendFunc(GlConst.toGl(sourceFactor), GlConst.toGl(destFactor));
    }

    public static void blendFunc(int i, int j) {
        RenderSystem.assertOnRenderThread();
        _blendFunc(i, j);
    }

    public static void blendEquation(int i) {
        RenderSystem.assertOnRenderThread();
        _blendEquation(i);
    }

    public static void glUniform3(int i, FloatBuffer floatBuffer) {
        RenderSystem.assertOnRenderThread();
        _glUniform3(i, floatBuffer);
    }

    public static int _glGetAttribLocation(int i, CharSequence charSequence) {
        RenderSystem.assertOnRenderThread();
        return GL20.glGetAttribLocation(i, charSequence);
    }

    public static void _glUniform3(int i, IntBuffer intBuffer) {
        RenderSystem.assertOnRenderThread();
        GL20.glUniform3iv(i, intBuffer);
    }

    public static void _glUniform3(int i, FloatBuffer floatBuffer) {
        RenderSystem.assertOnRenderThread();
        GL20.glUniform3fv(i, floatBuffer);
    }

    public static void glUniformMatrix4(int i, boolean bl, FloatBuffer floatBuffer) {
        RenderSystem.assertOnRenderThread();
        _glUniformMatrix4(i, bl, floatBuffer);
    }

    public static void _glUniformMatrix4(int i, boolean bl, FloatBuffer floatBuffer) {
        RenderSystem.assertOnRenderThread();
        GL20.glUniformMatrix4fv(i, bl, floatBuffer);
    }

    public static void _blendEquation(int i) {
        RenderSystem.assertOnRenderThread();
        GL14.glBlendEquation(i);
    }

    public static void _blendFunc(int i, int j) {
        RenderSystem.assertOnRenderThread();

        if (i != GlStateManager.BLEND.srcRgb || j != GlStateManager.BLEND.dstRgb) {
            GlStateManager.BLEND.srcRgb = i;
            GlStateManager.BLEND.dstRgb = j;
            GL11.glBlendFunc(i, j);
        }
    }
}
