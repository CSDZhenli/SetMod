package com.set.setmod.Items;

import com.set.setmod.ModTabs;
import com.set.setmod.UtilRegister;
import net.minecraft.item.Item;
//这里是ItemBase的最基础模板，这里是做空物品用的
//Item的“儿子”,本质上是物品一块的

public class ItemBase extends Item {
    //主要为专门做布尔值做准备的
//    boolean isGlittering;
    // 构造函数，初始化ItemBase对象
    public ItemBase(String name) {
        super();
        UtilRegister.initItem(this, name);
        setCreativeTab(ModTabs.FirstTabs);
    }

}
