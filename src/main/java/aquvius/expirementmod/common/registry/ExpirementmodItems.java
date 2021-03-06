package aquvius.expirementmod.common.registry;

import aquvius.expirementmod.common.entity.TestmobEntity;
import aquvius.expirementmod.common.item.ExpirementmodSpawnEggItem;
import aquvius.expirementmod.common.item.ExpirementmodSwordBaseItem;
import aquvius.expirementmod.common.item.ExpirementmodFoods;
import aquvius.expirementmod.common.item.TestShieldItem;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import aquvius.expirementmod.Expirementmod;
import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil;

public class ExpirementmodItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Expirementmod.MOD_ID);

    // SWORDS
    public static final RegistryObject<Item> AQUBLADE = ITEMS.register("aqublade", () -> new ExpirementmodSwordBaseItem(ItemTier.NETHERITE, 500, -2.5f, new EffectInstance(Effects.WITHER, 200, 5), new Item.Properties().rarity(Rarity.EPIC).durability(3540).tab(ItemGroup.TAB_MISC)));

    // SPAWN EGGS
    public static final RegistryObject<Item> TESTMOB_SPAWN_EGG = ITEMS.register("testmob_spawn_egg", () -> new ExpirementmodSpawnEggItem(ExpirementmodEntities.TESTMOB, 0x000000, 0xFF0000, new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> BUFFTESTMOB_SPAWN_EGG = ITEMS.register("bufftestmob_spawn_egg", () -> new ExpirementmodSpawnEggItem(ExpirementmodEntities.BUFFTESTMOB, 0xf76b60, 0xb3ffe5, new Item.Properties().tab(ItemGroup.TAB_MISC)));

    // FOOD
    public static final RegistryObject<Item> SAJEVIUS_MEAT = ITEMS.register("sajevius_meat", () -> new Item(new Item.Properties().food(ExpirementmodFoods.SAJEVIUS_MEAT)));

    //OTHER GEAR (SHIELDS / BOWS / CROSSBOWS / ETC. )
    public static final RegistryObject<Item> DRAGONAR_SHIELD = ITEMS.register("dragonar_shield", () -> new TestShieldItem(new Item.Properties().rarity(Rarity.EPIC).tab(ItemGroup.TAB_MISC)));
}
