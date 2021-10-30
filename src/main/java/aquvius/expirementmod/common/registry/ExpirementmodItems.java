package aquvius.expirementmod.common.registry;

import aquvius.expirementmod.common.entity.TestmobEntity;
import aquvius.expirementmod.common.item.ExpirementmodSwordBaseItem;
import aquvius.expirementmod.common.item.ExpirementmodFoods;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import aquvius.expirementmod.Expirementmod;

public class ExpirementmodItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Expirementmod.MOD_ID);

    // SWORDS
    public static final RegistryObject<Item> AQUBLADE = ITEMS.register("aqublade", () -> new ExpirementmodSwordBaseItem(ItemTier.NETHERITE, 5, -2.5f, new EffectInstance(Effects.WITHER, 200), new Item.Properties().rarity(Rarity.EPIC).durability(5540)));

    // SPAWN EGGS
    //public static final RegistryObject<Item> TESTMOB_SPAWN_EGG = ITEMS.register("testmob_spawn_egg", () -> new SpawnEggItem(ExpirementmodEntities.TESTMOB.get(), 0x000000, 0xFF0000, new Item.Properties().tab(ItemGroup.TAB_MISC)));

    // FOOD
    public static final RegistryObject<Item> SAJEVIUS_MEAT = ITEMS.register("sajevius_meat", () -> new Item(new Item.Properties().food(ExpirementmodFoods.SAJEVIUS_MEAT)));
}
