package com.set.setmod.Entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ArrowEntity extends EntityThrowable {
    // 构造函数：创建一个由指定实体抛出的实体
    public ArrowEntity(World worldIn, EntityLivingBase throwerIn) {
        super(worldIn, throwerIn);
    }
    /**
     * 当此可投掷实体撞击到方块或实体时调用
     */
    @Override
    protected void onImpact(RayTraceResult result) {
        // 如果撞击到了实体，则对该实体造成最大伤害值（Integer.MAX_VALUE）的伤害
        if (result.entityHit != null) {
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.ignoreEntity), (float) Integer.MAX_VALUE);
        }
        // 如果不是客户端世界，则更新实体状态并销毁此实体
        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte) 3);
            this.setDead();
        }
    }
}
