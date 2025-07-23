package com.set.setmod.blocks;

import com.set.setmod.ModTabs;
import com.set.setmod.UtilRegister;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
//这里是Block的改进模板，破坏声音可调节

public class BlockNewBase extends Block {
    // 构造函数，初始化BlockBase对象
    public BlockNewBase(String name, Material material , SoundType soundType) {
        // 调用父类Block的构造函数，传入材质参数
        super(material);
        // 设置方块类默认放方块Tabs
        setCreativeTab(ModTabs.SecondTabs);
        // 注册当前方块到游戏世界中
        UtilRegister.initBlock(this, name);
        //设置声音
        setSoundType(soundType);
    }
}
