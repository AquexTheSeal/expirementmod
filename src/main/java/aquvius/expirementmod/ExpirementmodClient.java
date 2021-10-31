package aquvius.expirementmod;

import aquvius.expirementmod.client.entity.render.BufftestmobEntityRenderer;
import aquvius.expirementmod.client.entity.render.TestmobEntityRenderer;
import aquvius.expirementmod.common.registry.ExpirementmodEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus =  Mod.EventBusSubscriber.Bus.MOD)
public class ExpirementmodClient {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerRenderers(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(ExpirementmodEntities.TESTMOB.get(), manager -> new TestmobEntityRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(ExpirementmodEntities.BUFFTESTMOB.get(), manager -> new BufftestmobEntityRenderer(manager));
    }
}
