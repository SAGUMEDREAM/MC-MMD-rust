package com.shiroha.mmdskin.mixin.forge;

import com.shiroha.mmdskin.inf.DataInfRenderStateAvatar;
import net.minecraft.client.entity.ClientAvatarEntity;
import net.minecraft.client.model.player.PlayerModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.world.entity.Avatar;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AvatarRenderer.class)
public abstract class AvatarRendererMixin<AvatarlikeEntity extends Avatar & ClientAvatarEntity> extends LivingEntityRenderer<AvatarlikeEntity, AvatarRenderState, PlayerModel> {

    public AvatarRendererMixin(EntityRendererProvider.Context arg, PlayerModel arg2, float f) {
        super(arg, arg2, f);
    }

    @Inject(method = "extractRenderState(Lnet/minecraft/world/entity/Avatar;Lnet/minecraft/client/renderer/entity/state/AvatarRenderState;F)V",
            at = @At("TAIL"),
            cancellable = true
    )
    public void mmdSkin$setPlayerData(AvatarlikeEntity avatar, AvatarRenderState state, float f, CallbackInfo ci) {
        DataInfRenderStateAvatar accessor = DataInfRenderStateAvatar.mmdSkin$$tryGetInf(state);
        if (accessor != null) {
            accessor.mmdSkin$setPlayer(avatar);
        }
    }
}
