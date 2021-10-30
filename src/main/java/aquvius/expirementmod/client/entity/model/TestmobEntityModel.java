package aquvius.expirementmod.client.entity.model;

import aquvius.expirementmod.Expirementmod;
import aquvius.expirementmod.common.entity.TestmobEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TestmobEntityModel extends AnimatedGeoModel<TestmobEntity> {

    @Override
    public ResourceLocation getModelLocation(TestmobEntity entity) {
        return new ResourceLocation(Expirementmod.MOD_ID, "geo/testmob.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(TestmobEntity entity) {
        return new ResourceLocation(Expirementmod.MOD_ID, "textures/entity/testmob.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(TestmobEntity entity) {
        return new ResourceLocation(Expirementmod.MOD_ID, "animations/testmob.animation.json");
    }
}
