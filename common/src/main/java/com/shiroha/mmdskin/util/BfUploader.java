package com.shiroha.mmdskin.util;

import com.mojang.blaze3d.opengl.GlStateManager;

public class BfUploader {
    public static void reset() {
        GlStateManager._glBindVertexArray(0);
    }
}
