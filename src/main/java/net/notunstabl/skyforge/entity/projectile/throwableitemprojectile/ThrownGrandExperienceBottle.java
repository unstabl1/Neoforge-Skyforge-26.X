package net.notunstabl.skyforge.entity.projectile.throwableitemprojectile;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrownExperienceBottle;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class ThrownGrandExperienceBottle extends ThrowableItemProjectile {
    public ThrownGrandExperienceBottle(EntityType<? extends ThrownExperienceBottle> type, Level level) {
        super(type, level);
    }

    public ThrownGrandExperienceBottle(Level level, LivingEntity mob, ItemStack itemStack) {
        super(EntityType.EXPERIENCE_BOTTLE, mob, level, itemStack);
    }

    protected Item getDefaultItem() {
        return Items.EXPERIENCE_BOTTLE;
    }

    protected double getDefaultGravity() {
        return 0.07;
    }

    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        Level var3 = this.level();
        if (var3 instanceof ServerLevel level) {
            level.levelEvent(2002, this.blockPosition(), -13083194);
            int xpCount = 4500;
            if (hitResult instanceof BlockHitResult blockHitResult) {
                Vec3 blockNormalHit = blockHitResult.getDirection().getUnitVec3();
                ExperienceOrb.awardWithDirection(level, hitResult.getLocation(), blockNormalHit, xpCount);
            } else {
                ExperienceOrb.awardWithDirection(level, hitResult.getLocation(), this.getDeltaMovement().scale((double)-1.0F), xpCount);
            }

            this.discard();
        }

    }

}
