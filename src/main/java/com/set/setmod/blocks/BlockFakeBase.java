package com.set.setmod.blocks;

import com.set.setmod.ModTabs;
import com.set.setmod.UtilRegister;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nullable;

//做没有碰撞的方块用的
public class BlockFakeBase extends Block {
    // 构造函数，初始化BlockBase对象
    public BlockFakeBase(String name, Material material) {
        // 调用父类Block的构造函数，传入材质参数
        super(material);
        // 设置方块类默认放方块Tabs
        setCreativeTab(ModTabs.SecondTabs);
        // 注册当前方块到游戏世界中
        UtilRegister.initBlock(this, name);
    }
    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return null;
    }
}
