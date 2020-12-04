package io.github.concerncraft.unweaver.impl.useactions.v0;

import io.github.concerncraft.unweaver.api.useactions.v0.ArmPose;

public interface BipedEntityModelTrait {
    ArmPose getLeftArmPose();
    void setLeftArmPose(ArmPose pose);
    ArmPose getRightArmPose();
    void setRightArmPose(ArmPose pose);
}
