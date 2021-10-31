package aquvius.expirementmod.client.entity.model;

import aquvius.expirementmod.Expirementmod;
import aquvius.expirementmod.common.entity.BufftestmobEntity;
import aquvius.expirementmod.common.entity.TestmobEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BufftestmobEntityModel extends AnimatedGeoModel<BufftestmobEntity> {

    @Override
    public ResourceLocation getModelLocation(BufftestmobEntity entity) {
        return new ResourceLocation(Expirementmod.MOD_ID, "geo/bufftestmob.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(BufftestmobEntity entity) {
        return new ResourceLocation(Expirementmod.MOD_ID, "textures/entity/bufftestmob.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(BufftestmobEntity entity) {
        return new ResourceLocation(Expirementmod.MOD_ID, "animations/bufftestmob.animation.json");
    }
}
