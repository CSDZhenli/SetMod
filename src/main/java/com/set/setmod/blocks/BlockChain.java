package com.set.setmod.blocks;

import com.set.setmod.ModTabs;
import com.set.setmod.UtilRegister;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockChain extends Block {
    // 构造函数，初始化BlockBase对象
    public BlockChain(String name, Material material) {
        // 调用父类Block的构造函数，传入材质参数
        super(material);
        // 设置方块类默认放方块Tabs
        setCreativeTab(ModTabs.SecondTabs);
        // 注册当前方块到游戏世界中
        UtilRegister.initBlock(this, name);
    }
    @Override //表示为非完整方块
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    public boolean isOpaqueCube(IBlockState state) {
        // 返回false，表示该方块不是不透明的
        return false;
    }
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
    //失去碰撞箱
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return null;
    }
}
