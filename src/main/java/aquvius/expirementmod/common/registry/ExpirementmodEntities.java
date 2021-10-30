package aquvius.expirementmod.common.registry;

import aquvius.expirementmod.Expirementmod;
import aquvius.expirementmod.common.entity.TestmobEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Expirementmod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExpirementmodEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Expirementmod.MOD_ID);

    // ENTITIES
    public static final RegistryObject<EntityType<TestmobEntity>> TESTMOB = ENTITIES.register("testmob", () -> EntityType.Builder.of(TestmobEntity::new, EntityClassification.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(Expirementmod.MOD_ID, "testmob").toString()));

    // FINAL-STEP REGISTERS

}
