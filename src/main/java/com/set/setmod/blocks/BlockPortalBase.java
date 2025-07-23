package com.set.setmod.blocks;

import com.set.setmod.ModTabs;
import com.set.setmod.UtilRegister;
import net.minecraft.block.BlockPortal;
//继承传送门方法
public class BlockPortalBase extends BlockPortal {
    // 构造函数，初始化BlockPortalBase对象
    public BlockPortalBase(String name) {
        // 调用父类Block的构造函数，传入材质参数
        super();
        // 设置方块类默认放方块Tabs
        setCreativeTab(ModTabs.SecondTabs);
        // 注册当前方块到游戏世界中
        UtilRegister.initBlock(this, name);
    }
}
