package expirementmod.expirementmod.common.item;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class Experimentfoods {
    public static final Food SAJEVIUS_MEAT = new Food.Builder().nutrition(10).saturationMod(1.5F).alwaysEat().effect(() -> new EffectInstance(Effects.DAMAGE_BOOST, 3900, 2), 1.0F).effect(() -> new EffectInstance(Effects.REGENERATION, 4800, 3), 1.0F).effect(() -> new EffectInstance(Effects.HEALTH_BOOST, 5400, 2), 1.0F).effect(() -> new EffectInstance(Effects.DAMAGE_RESISTANCE, 7200, 0), 1.0F).effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 7200, 0), 1.0F).build();
}
