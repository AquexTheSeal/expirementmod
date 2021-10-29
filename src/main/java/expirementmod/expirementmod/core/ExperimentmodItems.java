package expirementmod.expirementmod.core;

import expirementmod.expirementmod.common.item.Experimentfoods;
import expirementmod.expirementmod.common.item.ExperimentswordTool;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import expirementmod.expirementmod.Expirementmod;

public class ExperimentmodItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Expirementmod.MOD_ID);

    //SWORDS
    public static final RegistryObject<Item> AQUBLADE = ITEMS.register("aqublade", () -> new ExperimentswordTool(ItemTier.NETHERITE, 1000, -2.5f, new Item.Properties().rarity(Rarity.EPIC).durability(5540)));

    //FOOD
    public static final RegistryObject<Item> SAJEVIUS_MEAT = ITEMS.register("sajevius_meat", () -> new Item(new Item.Properties().food(Experimentfoods.SAJEVIUS_MEAT)));
   // public static final RegistryObject<Item> SAJEVIUS_MEAT = ITEMS.register("sajevius_meat", () -> new Food.Builder().nutrition(10).saturationMod(1.5f).alwaysEat().effect(() -> new EffectInstance(Effects.DAMAGE_BOOST, 3900, 2), 1.0F).effect(() -> new EffectInstance(Effects.REGENERATION, 4800, 3), 1.0F).effect(() -> new EffectInstance(Effects.HEALTH_BOOST, 5400, 2), 1.0F).effect(() -> new EffectInstance(Effects.DAMAGE_RESISTANCE, 7200, 0), 1.0F).effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 7200, 0), 1.0F).build());
}
