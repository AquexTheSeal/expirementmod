package aquvius.expirementmod.common.item;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.tags.ItemTags;

public class TestShieldItem extends ShieldItem {
    public TestShieldItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getUseDuration(ItemStack p_77626_1_) {
        return 180000;
    }

    @Override
    public boolean isValidRepairItem(ItemStack p_82789_1_, ItemStack p_82789_2_) {
        return ItemTags.PIGLIN_LOVED.contains(p_82789_2_.getItem()) || super.isValidRepairItem(p_82789_1_, p_82789_2_);
    }
}
