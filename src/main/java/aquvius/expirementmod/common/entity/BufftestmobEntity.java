package aquvius.expirementmod.common.entity;

import aquvius.expirementmod.common.entity.ai.AnimatableMeleeGoal;
import aquvius.expirementmod.common.entity.ai.AnimatableMoveToTargetGoal;
import aquvius.expirementmod.common.registry.ExpirementmodEntities;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.BossInfo;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class BufftestmobEntity extends AnimatableHostileEntity implements IAnimatable {

    private final AnimationFactory factory = new AnimationFactory(this);
    private final ServerBossInfo bossInfo = (ServerBossInfo)(new ServerBossInfo(this.getDisplayName(), BossInfo.Color.RED, BossInfo.Overlay.PROGRESS));

    public BufftestmobEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
        this.noCulling = true;
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createLivingAttributes()
                .add(Attributes.ARMOR, 8)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1)
                .add(Attributes.ATTACK_SPEED, 10)
                .add(Attributes.ATTACK_DAMAGE, 30)
                .add(Attributes.ATTACK_KNOCKBACK, 5.0D)
                .add(Attributes.MAX_HEALTH, 750)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.FOLLOW_RANGE, 64D);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (this.getAttacking()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.bufftestmob.attack", true));
            return PlayState.CONTINUE;
        }

        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.bufftestmob.walking", true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.bufftestmob.idle", true));
        return PlayState.CONTINUE;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 24.0F));
        this.goalSelector.addGoal(2, new AnimatableMoveToTargetGoal(this, 1.6, 8));
        this.goalSelector.addGoal(2, new AnimatableMeleeGoal(this, 40, 0.5, 0.6));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(7, new SwimGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
    }

    @Override
    public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
        return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
    }

    @Override
    public net.minecraft.util.SoundEvent getDeathSound() {
        return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "bufftestmobcontroller", 0, this::predicate));
    }

    @Override
    public boolean isPersistenceRequired() {
        return true;
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
        if (((getEntity().getPersistentData().getDouble("BuffTestmobSummon")) == 0)) {
            getEntity().getPersistentData().putDouble("BuffTestmobSummon", 300);
        } else {
            getEntity().getPersistentData().putDouble("BuffTestmobSummon", ((getEntity().getPersistentData().getDouble("BuffTestmobSummon")) - 1));
        }
        if ((((getEntity().getPersistentData().getDouble("BuffTestmobSummon")) == 0))) {
            if (level instanceof ServerWorld) {
                Entity entityToSpawn = new TestmobEntity(ExpirementmodEntities.TESTMOB.get(), (World) level);
                entityToSpawn.moveTo((getX() + -2), (getY() + 1), (getZ()), level.getRandom().nextFloat() * 360F, 0);
                if (entityToSpawn instanceof MobEntity)
                    ((MobEntity) entityToSpawn).finalizeSpawn((ServerWorld) level, level.getCurrentDifficultyAt(entityToSpawn.getEntity().blockPosition()),
                            SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
                level.addFreshEntity(entityToSpawn);
            }
            if (level instanceof ServerWorld) {
                Entity entityToSpawn = new TestmobEntity(ExpirementmodEntities.TESTMOB.get(), (World) level);
                entityToSpawn.moveTo((getX() + 2), (getY() + 1), (getZ()), level.getRandom().nextFloat() * 360F, 0);
                if (entityToSpawn instanceof MobEntity)
                    ((MobEntity) entityToSpawn).finalizeSpawn((ServerWorld) level, level.getCurrentDifficultyAt(entityToSpawn.getEntity().blockPosition()),
                            SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
                level.addFreshEntity(entityToSpawn);
            }
        }
    }

    @Override
    public void startSeenByPlayer(ServerPlayerEntity player) {
        super.startSeenByPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayerEntity player) {
        super.stopSeenByPlayer(player);
        this.bossInfo.removePlayer(player);
    }
}
