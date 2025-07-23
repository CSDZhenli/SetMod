package com.set.setmod.Items;
import com.set.setmod.ModTabs;
import com.set.setmod.UtilRegister;
import net.minecraft.item.ItemBow;
//Item的“儿子”,本质上是弓一块的
public class ItemBowBase extends ItemBow {
    // 构造函数，初始化ItemBowBase对象
    public ItemBowBase(String name) {
        super();
        UtilRegister.initItem(this, name);
        setCreativeTab(ModTabs.FirstTabs);
    }

}
