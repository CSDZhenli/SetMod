package com.set.setmod.Items;

import com.set.setmod.Entity.EntityItemAntiBoom;
import com.set.setmod.ModTabs;
import com.set.setmod.UtilRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ItemBolg extends ItemSword {
    // 构造函数，初始化ItemBase对象
    public ItemBolg(String name, ToolMaterial material) {
        super(material);
        UtilRegister.initItem(this, name);
        setCreativeTab(ModTabs.FirstTabs);
    }
    //右键空挥获得疾跑，力量效果
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        player.addPotionEffect(new PotionEffect(MobEffects.SPEED,100,10));
        player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH,100,20));
        //冷却1分钟
        player.getCooldownTracker().setCooldown(this, 200);
        return super.onItemRightClick(world, player, hand);
    }
    //防爆炸，防火代码
    @Nullable
    @Override
    public Entity createEntity(World world, Entity location, ItemStack itemStack) {
        //构造特殊实体，确定位置，物品数量等
        EntityItem entityItem = new EntityItemAntiBoom(world, location.posX, location.posY, location.posZ, itemStack);
        //设置拾取时间，防止扔不出去
        if(location instanceof EntityItem) {
            NBTTagCompound tag = new NBTTagCompound();
            location.writeToNBT(tag);
            entityItem.setPickupDelay(tag.getShort("PickupDelay"));
        }
        //确保速度正确
        entityItem.motionX = location.motionX;
        entityItem.motionY = location.motionY;
        entityItem.motionZ = location.motionZ;
        return entityItem;
    }
}
