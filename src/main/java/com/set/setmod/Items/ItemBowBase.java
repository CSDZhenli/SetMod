package com.set.setmod.Items;
import com.set.setmod.Entity.ArrowEntity;
import com.set.setmod.ModTabs;
import com.set.setmod.UtilRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import java.util.Objects;

//Item的“儿子”,本质上是弓一块的
public class ItemBowBase extends ItemBow {
    // 构造函数，初始化ItemBowBase对象
    public ItemBowBase(String name) {
        super();
        UtilRegister.initItem(this, name);
        setCreativeTab(ModTabs.FirstTabs);
    }
    // 重写onItemRightClick方法，处理玩家右键点击物品时的逻辑
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn){
        ItemStack itemstack = playerIn.getHeldItem(handIn); // 获取玩家手中持有的物品堆叠
        // 播放声音
        worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        // 如果当前不是客户端世界（即允许生成实体）
        if (!worldIn.isRemote)
        {
            ArrowEntity entityarrows = new ArrowEntity(worldIn, playerIn); // 创建EntityArrows实体
            entityarrows.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F); // 设置实体投射参数
            worldIn.spawnEntity(entityarrows); // 在世界中生成实体
        }

        // 为玩家添加使用该物品的统计信息
        playerIn.addStat(Objects.requireNonNull(StatList.getObjectUseStats(this)));

        // 返回操作结果和更新后的物品堆叠
        return new ActionResult<>(EnumActionResult.SUCCESS, itemstack);
    }
}
