package aquvius.expirementmod.common.registry;

import aquvius.expirementmod.Expirementmod;
import aquvius.expirementmod.common.entity.BufftestmobEntity;
import aquvius.expirementmod.common.entity.TestmobEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Expirementmod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityAttributesHandler {
    @SubscribeEvent
    public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ExpirementmodEntities.TESTMOB.get(), TestmobEntity.setCustomAttributes().build());
        event.put(ExpirementmodEntities.BUFFTESTMOB.get(), BufftestmobEntity.setCustomAttributes().build());
    }
}
