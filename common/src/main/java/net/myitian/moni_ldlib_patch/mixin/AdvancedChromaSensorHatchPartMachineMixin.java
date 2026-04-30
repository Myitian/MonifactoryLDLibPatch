package net.myitian.moni_ldlib_patch.mixin;

import net.myitian.moni_ldlib_patch.Utils;
import net.neganote.monilabs.common.machine.multiblock.Color;
import net.neganote.monilabs.common.machine.part.AdvancedChromaSensorHatchPartMachine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.function.Function;
import java.util.stream.Stream;


@Mixin(value = AdvancedChromaSensorHatchPartMachine.class, remap = false)
abstract class AdvancedChromaSensorHatchPartMachineMixin {
    @Redirect(
        method = "<clinit>",
        at = @At(value = "INVOKE", target = "Ljava/util/stream/Stream;map(Ljava/util/function/Function;)Ljava/util/stream/Stream;"),
        require = 0,
        remap = false
    )
    private static Stream<String> redirectFieldInitialization(Stream<Color> instance, Function<Color, String> function) {
        return instance.map(Utils::getTranslateKey);
    }
}