package io.github.concerncraft.unweaver.mixinext;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.struct.InjectionPointData;

import java.util.Collection;

@InjectionPoint.AtCode("SWITCH")
public class SwitchInsnPoint extends InjectionPoint {

    private final int opCode;
    private final int ordinal;

    public SwitchInsnPoint(InjectionPointData data) {
        this.opCode = data.getOpcode(-1, Opcodes.LOOKUPSWITCH, Opcodes.TABLESWITCH, -1);
        this.ordinal = data.getOrdinal();
    }

    @Override
    public boolean find(String desc, InsnList insns, Collection<AbstractInsnNode> nodes) {
        boolean found = false;
        int ordinal = 0;

        for (AbstractInsnNode insn : insns) {
            if (
                (insn instanceof LookupSwitchInsnNode || insn instanceof TableSwitchInsnNode)
                &&
                (this.opCode == -1 || insn.getOpcode() == this.opCode)
            ) {
                if (this.ordinal == -1 || this.ordinal == ordinal) {
                    nodes.add(insn);
                    found = true;
                }
                ordinal++;
            }
        }
        return found;
    }
}
