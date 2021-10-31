package aquvius.expirementmod.common.item;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.*;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.ProjectileImpactEvent;

import java.util.function.Predicate;

public class TestbowItem extends BowItem {
    public TestbowItem(Properties properties) {
        super(properties);
    }

    @Override
    public void releaseUsing(ItemStack stack, World worldIn, LivingEntity entity, int timeLeft) {
        if(entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            boolean flag = player.abilities.invulnerable || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY_ARROWS, entity) > 0;
            ItemStack ammo = player.getProjectile(stack);

            int i = this.getUseDuration(stack) - timeLeft;
            i = ForgeEventFactory.onArrowLoose(stack, worldIn, player, i, !ammo.isEmpty() || flag);

            if (i < 0) return;

            if (!ammo.isEmpty() || flag) {
                if (ammo.isEmpty()) {
                    ammo = new ItemStack(Items.ARROW);
                }
                float f = getPowerForTime(i);
                if (!((double) f < 0.1D)) {
                    boolean flag1 = player.abilities.invulnerable || (ammo.getItem() instanceof ArrowItem && ((ArrowItem) ammo.getItem()).isInfinite(ammo, stack, player));
                    if (!worldIn.isClientSide) {
                        ArrowItem arrow = (ArrowItem) (ammo.getItem() instanceof ArrowItem ? ammo.getItem() : Items.ARROW);
                        AbstractArrowEntity projectile = arrow.createArrow(worldIn, ammo, player);
                        projectile = customArrow(projectile);
                        projectile.shootFromRotation(player, player.xRot, player.yRot, 0.0F, f * 3.0F, 0.0F);
                        if (f == 1.0F) {
                            projectile.setCritArrow(true);
                        }

                        int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER_ARROWS, player);

                        if (j > 0) {
                            projectile.setBaseDamage(projectile.getBaseDamage() + (double) j * 0.75D + 0.75D);
                        }

                        int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH_ARROWS, player);
                        if (k > 0) {
                            projectile.setKnockback(k);
                        }
                        if (!(EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAMING_ARROWS, player) > 0)) {
                            projectile.setSecondsOnFire(100);
                        } else {
                            int d = EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAMING_ARROWS, player) + 1;
                            projectile.setBaseDamage(projectile.getBaseDamage() + (double) d);
                        }

                        stack.hurtAndBreak(1, player, (p) -> {
                            p.broadcastBreakEvent(player.getUsedItemHand());
                        });

                        if (flag1 || player.abilities.invulnerable && (ammo.getItem() == Items.SPECTRAL_ARROW || ammo.getItem() == Items.TIPPED_ARROW)) {
                            projectile.pickup = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;

                        }
                        worldIn.addFreshEntity(projectile);
                        worldIn.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5f);
                        if (!flag1 && !player.abilities.invulnerable) {
                            ammo.shrink(1);
                            if (ammo.isEmpty()) {
                                player.inventory.removeItem(ammo);
                            }
                        }
                        player.awardStat(Stats.ITEM_USED.get(this));
                        // yay
                    }
                }
            }
        }
    }
    public static float getPowerForTime(int var0) {
        float f = (float)var0 / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    public int getUseDuration(ItemStack stack)
    {
        return 54000;
    }

    public UseAction getUseAction(ItemStack stack)
    {
        return UseAction.BOW;
    }

    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        ItemStack itemstack = p_77659_2_.getItemInHand(p_77659_3_);
        boolean flag = !p_77659_2_.getProjectile(itemstack).isEmpty();
        ActionResult<ItemStack> ret = ForgeEventFactory.onArrowNock(itemstack, p_77659_1_, p_77659_2_, p_77659_3_, flag);
        if (ret != null) {
            return ret;
        } else if (!p_77659_2_.abilities.instabuild && !flag) {
            return ActionResult.fail(itemstack);
        } else {
            p_77659_2_.startUsingItem(p_77659_3_);
            return ActionResult.consume(itemstack);
        }
    }

    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_ONLY;
    }

    public AbstractArrowEntity customArrow(AbstractArrowEntity p_customArrow_1_) {
        return p_customArrow_1_;
    }

    public int getDefaultProjectileRange() {
        return 15;
    }
}
