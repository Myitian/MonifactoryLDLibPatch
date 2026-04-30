package net.myitian.moni_ldlib_patch;

import net.neganote.monilabs.common.machine.multiblock.Color;
import net.neganote.monilabs.common.machine.multiblock.Microverse;

public final class Utils {
    public static String getTranslateKey(Color color) {
        if (color.nameKey != null && !color.nameKey.isEmpty()) {
            return color.nameKey;
        }
        return color.serializedName;
    }

    public static String getTranslateKey(Microverse microverse) {
        if (microverse.langKey != null && !microverse.langKey.isEmpty()) {
            return microverse.langKey;
        }
        return microverse.serializedName;
    }
}
