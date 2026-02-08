package com.shiroha.mmdskin.mixin.forge;

import com.shiroha.mmdskin.inf.DataInfRenderStateAvatar;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.world.entity.Avatar;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(HumanoidRenderState.class)
public class DataInfRenderStateAvatarImpl implements DataInfRenderStateAvatar {
    @Unique
    Avatar mmdSkin$setPlayer;

    @Unique
    @Override
    public void mmdSkin$setPlayer(Avatar player) {
        this.mmdSkin$setPlayer = player;
    }

    @Unique
    @Override
    public Avatar mmdSkin$getPlayer() {
        return this.mmdSkin$setPlayer;
    }
}
