package aquvius.expirementmod.common.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;

public class ExpirementmodSwordBaseItem extends SwordItem {
    protected EffectInstance tippedEffect;

    public ExpirementmodSwordBaseItem(ItemTier tier, int attackDamage, float attackSpeed, Properties builder) {
        super(tier, attackDamage, attackSpeed, builder);
    }

    public ExpirementmodSwordBaseItem(ItemTier tier, int attackDamage, float attackSpeed, EffectInstance effect, Properties builder) {
        super(tier, attackDamage, attackSpeed, builder);
        this.tippedEffect = effect;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity entity, LivingEntity source) {
        boolean retval = super.hurtEnemy(stack, entity, source);
        if(this.tippedEffect != null) {
            entity.addEffect(tippedEffect);
        }
        return retval;
    }
}


