package com.set.setmod.Items;
import com.set.setmod.ModTabs;
import com.set.setmod.UtilRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

//ItemBook的“儿子”,本质上是书一块的

public class ItemUser extends Item {
    // 构造函数，初始化ItemUser对象
    public ItemUser(String name) {
        super();
        // 注册当前物品到游戏世界中
        UtilRegister.initItem(this, name);
        // 设置书本类默认放集合Tabs
        setCreativeTab(ModTabs.FirstTabs);
        // 设置最大堆叠数为1
        maxStackSize = 1;
    }
    //这是右键空挥
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        //防止出现重复字符串
        if (!world.isRemote&&player instanceof EntityPlayer) {
            //这是字符串，可以修改
            String m_1 = "这里是setmod," + player.getName() + "!";
            String m_2 = "里面是漫步的真理所写的第一个作品";
            String m_3 = "当然，有布景，也有用来测试的";
            String m_4 = "若有疑问，请寻找漫步的真理，QQ2567113342";
            //这段代码很重要，因为mc不能直接发送字符串
            TextComponentString t_1 = new TextComponentString(m_1);
            TextComponentString t_2 = new TextComponentString(m_2);
            TextComponentString t_3 = new TextComponentString(m_3);
            TextComponentString t_4 = new TextComponentString(m_4);
            //发送字符串，参数是一个TextComponentString类
            player.sendMessage(t_1);
            player.sendMessage(t_2);
            player.sendMessage(t_3);
            player.sendMessage(t_4);
            //冷却1秒
            player.getCooldownTracker().setCooldown(this, 20);
        }
        return super.onItemRightClick(world, player, hand);
    }
}
