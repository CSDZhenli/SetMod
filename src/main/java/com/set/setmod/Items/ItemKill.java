package com.set.setmod.Items;

import com.set.setmod.ModTabs;
import com.set.setmod.Potion.PotionRegister;
import com.set.setmod.UtilRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

//这里是ItemBase的最基础模板，这里是做空物品用的
//Item的“儿子”,本质上是物品一块的

public class ItemKill extends Item {
    // 构造函数，初始化ItemBase对象
    public ItemKill(String name) {
        super();
        UtilRegister.initItem(this, name);
        setCreativeTab(ModTabs.FirstTabs);
    }

    //又是你，右键空挥
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        //获得10000级的瞬间伤害效果（生存模式你右键一下绝对死，我不清楚创造怎么搞，就先这样）
        player.addPotionEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE,1,10000));
        player.addPotionEffect(new PotionEffect(PotionRegister.FIRST,10000,0));
        //丢该东西（死掉会多生产一个，合理（笑））
            player.dropItem(new ItemStack(this), false);
        if (!world.isRemote&&player instanceof EntityPlayer) {
            //这是字符串，可以修改
            String m_1 = player.getName() + "§c§l,你为什么要动这个!";
            //这段代码很重要，因为mc不能直接发送字符串
            TextComponentString t_1 = new TextComponentString(m_1);
            //发送字符串，参数是一个TextComponentString类
            player.sendMessage(t_1);
        }
        return super.onItemRightClick(world, player, hand);
    }

}
