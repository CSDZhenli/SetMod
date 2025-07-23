package com.set.setmod.blocks;

import com.set.setmod.ModTabs;
import com.set.setmod.UtilRegister;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
//这里是Block的最基础模板，是做没有功能（甚至状态只有一种）的方块用的

public class BlockBase extends Block {
    // 构造函数，初始化BlockBase对象
    public BlockBase(String name, Material material) {
        // 调用父类Block的构造函数，传入材质参数
        super(material);
        // 设置方块类默认放方块Tabs
        setCreativeTab(ModTabs.SecondTabs);
        // 注册当前方块到游戏世界中
        UtilRegister.initBlock(this, name);
    }
}
