package com.set.setmod;

import com.set.setmod.Items.ItemRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import static com.set.setmod.blocks.BlocksRegister.BLOCK_1;
import static net.minecraft.item.Item.getItemFromBlock;

//Mod的Tabs,用于创造模式方便获取
public class ModTabs {
    // 新建一个创造模式tab，CreativeTabs.getNextID()为获取下一个可用的tab id（未被使用的tab id），直接填入数值可能会导致模组冲突
    public static final CreativeTabs FirstTabs = new CreativeTabs(CreativeTabs.getNextID(), "setmod.tab1") {
        //sideonly注解表示该方法只在客户端执行，不加注解服务端运行会崩溃
        @SideOnly(Side.CLIENT)
        //重写getTabIconItem方法，返回一个物品栈，用于在tab中显示
        public ItemStack getTabIconItem() {return new ItemStack(ItemRegister.USER);
        }
    };
    // 新建一个创造模式tab，CreativeTabs.getNextID()为获取下一个可用的tab id（未被使用的tab id），直接填入数值可能会导致模组冲突
    public static final CreativeTabs SecondTabs = new CreativeTabs(CreativeTabs.getNextID(), "setmod.tab2") {
        //sideonly注解表示该方法只在客户端执行，不加注解服务端运行会崩溃
        @SideOnly(Side.CLIENT)
        //重写getTabIconItem方法，返回一个物品栈，用于在tab中显示
        public ItemStack getTabIconItem() {return new ItemStack(getItemFromBlock(BLOCK_1));
        }
    };
}
