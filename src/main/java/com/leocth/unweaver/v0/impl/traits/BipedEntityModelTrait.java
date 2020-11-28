package com.leocth.unweaver.v0.impl.traits;

import com.leocth.unweaver.v0.api.enums.client.render.entity.ArmPose;

public interface BipedEntityModelTrait {
    ArmPose getLeftArmPose();
    void setLeftArmPose(ArmPose pose);
    ArmPose getRightArmPose();
    void setRightArmPose(ArmPose pose);
}
