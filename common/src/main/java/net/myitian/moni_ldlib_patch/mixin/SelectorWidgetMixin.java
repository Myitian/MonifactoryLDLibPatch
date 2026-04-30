package net.myitian.moni_ldlib_patch.mixin;

import com.lowdragmc.lowdraglib.gui.widget.SelectorWidget;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;


@Mixin(value = SelectorWidget.class, remap = false)
abstract class SelectorWidgetMixin {
    @ModifyArg(
        method = "computeLayout",
        at = @At(value = "INVOKE", target = "Lcom/lowdragmc/lowdraglib/gui/texture/TextTexture;<init>(Ljava/lang/String;I)V"),
        require = 0,
        remap = false)
    protected String computeLayout_ModifyArg(String text) {
        return Component.translatable(text).getString();
    }

    @ModifyArg(
        method = "setValue",
        at = @At(value = "INVOKE", target = "Lcom/lowdragmc/lowdraglib/gui/texture/TextTexture;updateText(Ljava/lang/String;)V"),
        require = 0,
        remap = false)
    public String setValue_ModifyArg(String text) {
        return Component.translatable(text).getString();
    }
}