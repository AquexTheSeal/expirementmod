package aquvius.expirementmod;

import aquvius.expirementmod.common.entity.TestmobEntity;
import aquvius.expirementmod.common.registry.ExpirementmodEntities;
import aquvius.expirementmod.common.registry.ExpirementmodItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

@Mod(Expirementmod.MOD_ID)
public class Expirementmod {
    public static Expirementmod instance;

    public static final String MOD_ID = "expirementmod";
    public static final String MOD_NAME = "Expirementmod";
    private static final Logger LOGGER = LogManager.getLogger();

    public Expirementmod() {
        instance = this;
        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        // final step of registering elements like Items, Entities, etc.
        ExpirementmodItems.ITEMS.register(bus);
        ExpirementmodEntities.ENTITIES.register(bus);

        // add all required listeners
        bus.addListener(this::setup);

        GeckoLib.initialize();

        // register this class through the Minecraft Forge Event Bus
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("[" + MOD_NAME + "] - Setting everything up uwu");
        LOGGER.info("Hello from Aqu and Sajevius. Btw, we have your IP Address");
    }
}
