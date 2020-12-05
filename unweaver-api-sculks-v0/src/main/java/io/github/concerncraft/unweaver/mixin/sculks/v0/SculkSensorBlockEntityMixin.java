package io.github.concerncraft.unweaver.mixin.sculks.v0;

import io.github.concerncraft.unweaver.api.sculks.v0.SculkFrequencyRegistry;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.class_5704;
import net.minecraft.class_5712;
import net.minecraft.class_5714;
import net.minecraft.world.World;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Optional;
import java.util.OptionalInt;

@Mixin(class_5704.class)
public class SculkSensorBlockEntityMixin {

    @Redirect(
        method = "method_32969",
        at = @At(
            value = "INVOKE",
            target = "Lit/unimi/dsi/fastutil/objects/Object2IntMap;getInt(Ljava/lang/Object;)I"
        )
    )
    private int modifyLastVibrationFrequency(Object2IntMap<class_5712> object2IntMap, Object key) {
        class_5712 vibration = (class_5712) key;
        return SculkFrequencyRegistry.INSTANCE.getFrequency(vibration).orElseGet(() -> object2IntMap.getInt(vibration));
    }

}
