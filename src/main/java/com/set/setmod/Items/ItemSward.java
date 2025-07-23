package com.set.setmod.Items;


import com.set.setmod.Entity.EntityItemAntiBoom;
import com.set.setmod.ModTabs;
import com.set.setmod.SetMod;
import com.set.setmod.UtilRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import javax.annotation.Nullable;


//ItemSword的“儿子”,本质上是剑这一块的
@Mod.EventBusSubscriber(modid = SetMod.MODID)
public class ItemSward extends ItemSword {
    // 构造函数，初始化ItemBase对象
    public ItemSward(String name, ToolMaterial material) {
        super(material);
        UtilRegister.initItem(this, name);
        setCreativeTab(ModTabs.FirstTabs);
    }
    //定义一个名为KILLER的工具材料，当然，也就做这种无敌剑用用（这种伤害真处理不了还有秒怪机制）
    public static final ToolMaterial KILL = EnumHelper.addToolMaterial(
            "KILL", 3, 999999999, 10000.0F, 999999.0F, 1000);

    //订阅事件
    @SubscribeEvent
    //当该生物受到该剑的伤害
    public void onAttack(LivingHurtEvent event) {
        World world = event.getEntity().world;
        if(!world.isRemote) {
            EntityLivingBase hurt = event.getEntityLiving();
            EntityLivingBase attacker = (EntityLivingBase) event.getSource().getTrueSource();
            if (attacker != null && attacker.getHeldItemMainhand().getItem() == this) {
                //造成最大伤害值（Integer.MAX_VALUE）的伤害
                hurt.attackEntityFrom(
                        DamageSource.causeThrownDamage(attacker, hurt), (float) Integer.MAX_VALUE);
            }
        }
    }
    //右键空挥获得夜视药水效果，回满血
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION,Integer.MAX_VALUE,1));
        player.heal((float) Integer.MAX_VALUE);
        return super.onItemRightClick(world, player, hand);
    }
    //告诉mc，需要特殊实体
    @Override
    public boolean hasCustomEntity(ItemStack stack) {
        return true;
    }
    //防爆炸，防火代码
    @Nullable
    @Override
    public Entity createEntity(World world,Entity location, ItemStack itemStack) {
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

//    @SideOnly(Side.CLIENT)
//    @SubscribeEvent
//    public static void onLivingUpdate(LivingEvent.LivingUpdateEvent event) {
//        if (event.getEntityLiving() instanceof EntityPlayer) {
//
//        }
//    }
}
