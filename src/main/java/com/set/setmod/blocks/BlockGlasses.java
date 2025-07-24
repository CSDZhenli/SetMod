package com.set.setmod.blocks;

import com.set.setmod.ModTabs;
import com.set.setmod.UtilRegister;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
//这里是Block的最基础模板，是做没有功能（甚至状态只有一种）的方块用的

public class BlockGlasses extends Block {
    // 构造函数，初始化BlockBase对象
    public BlockGlasses(String name, Material material) {
        // 调用父类Block的构造函数，传入材质参数
        super(material);
        // 设置方块类默认放方块Tabs
        setCreativeTab(ModTabs.SecondTabs);
        // 注册当前方块到游戏世界中
        UtilRegister.initBlock(this, name);
        //设置声音
        setSoundType(SoundType.GLASS);
    }
    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        // 返回false，表示该方块不是不透明的
        return false;
    }
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
}