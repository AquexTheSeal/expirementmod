package expirementmod.expirementmod.client.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import expirementmod.expirementmod.client.entity.model.TestmobEntityModel;
import expirementmod.expirementmod.common.entity.TestmobEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.geo.render.built.GeoBone;

public class TestmobEntityRender extends GeoEntityRenderer<TestmobEntity> {

    public TestmobEntityRender(EntityRendererManager renderManager) {
        super(renderManager, new TestmobEntityModel());
        this.shadowRadius = 0.4F;
    }

    @Override
    public void renderEarly(TestmobEntity animatable, MatrixStack stackIn, float ticks, IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float partialTicks) {
        super.renderEarly(animatable, stackIn, ticks, renderTypeBuffer, vertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, partialTicks);
    }

    @Override
    public ResourceLocation getTextureLocation(TestmobEntity entity) {
        return new ResourceLocation("Expirementmod", "textures/entity/testmob.png");
    }

    @Override
    public RenderType getRenderType(TestmobEntity animatable, float partialTicks, MatrixStack stack, IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }

    @Override
    public void renderRecursively(GeoBone bone, MatrixStack matrixStack, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        super.renderRecursively(bone, matrixStack, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }
}
