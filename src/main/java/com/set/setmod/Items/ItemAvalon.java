package com.set.setmod.Items;

import com.set.setmod.Entity.EntityItemAntiBoom;
import com.set.setmod.ModTabs;
import com.set.setmod.UtilRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import javax.annotation.Nullable;


public class ItemAvalon extends Item {
    //主要为专门做布尔值做准备的
    boolean SoulBinding = true;
    // 构造函数，初始化ItemBase对象
    public ItemAvalon(String name) {
        super();
        UtilRegister.initItem(this, name);
        setCreativeTab(ModTabs.FirstTabs);
    }
    //防爆炸，防火代码
    @Nullable
    @Override
    public Entity createEntity(World world,Entity location, ItemStack itemStack) {
        //构造特殊实体，确定位置，物品数量等
        EntityItem entityItem = new EntityItemAntiBoom(world, location.posX, location.posY, location.posZ, itemStack);
        //设置拾取时间，防止扔不出去（SoulBinding是决定能不能扔出去的）
        if(location instanceof EntityItem && !SoulBinding) {
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
    //告诉mc，需要特殊实体
    @Override
    public boolean hasCustomEntity(ItemStack stack) {
        return true;
    }

    //右键空挥
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItemMainhand();
        if (SoulBinding &&!world.isRemote&&player instanceof EntityPlayer) {
            //这是字符串，可以修改
            String m_1 = "灵魂解除绑定成功！";
            //这段代码很重要，因为mc不能直接发送字符串
            TextComponentString t_1 = new TextComponentString(m_1);
            //发送字符串，参数是一个TextComponentString类
            player.sendMessage(t_1);
            SoulBinding = false;
            player.getCooldownTracker().setCooldown(this, 20);
        } else if (!SoulBinding &&!world.isRemote&&player instanceof EntityPlayer)
        {
            //这是字符串，可以修改
            String m_1 = "灵魂绑定成功！";
            //这段代码很重要，因为mc不能直接发送字符串
            TextComponentString t_1 = new TextComponentString(m_1);
            //发送字符串，参数是一个TextComponentString类
            player.sendMessage(t_1);
            SoulBinding = true;
            player.getCooldownTracker().setCooldown(this, 20);
        }
        //右键空挥获得生命恢复，如果主手是咖喱棒，那么获得4级生命恢复，如果不是，则获得一级，若为解除灵魂绑定的，则清除所有正面效果
        if ((stack.getItem() == ItemRegister.SWORD || stack.getItem() == ItemRegister.SWORD_CLOSE) && SoulBinding) {
            player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, Integer.MAX_VALUE, 3));
        } else if(SoulBinding) {
            player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, Integer.MAX_VALUE, 0));
        } else {
            player.clearActivePotions();
        }
        return super.onItemRightClick(world, player, hand);
    }
}
