package com.set.setmod.blocks;

import com.set.setmod.ModTabs;
import com.set.setmod.UtilRegister;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;

//做能右键拿相机的功能
public class BlockCarema extends Block {
    //定义边界框
    protected static final AxisAlignedBB BUSH_AABB = new AxisAlignedBB(0.75D, 0.5D, 0.75D, 0.25D, 0D, 0.25D);
    // 构造函数，初始化BlockBase对象
    public BlockCarema(String name, Material material) {
        // 调用父类Block的构造函数，传入材质参数
        super(material);
        // 设置方块类默认放方块Tabs
        setCreativeTab(ModTabs.SecondTabs);
        // 注册当前方块到游戏世界中
        UtilRegister.initBlock(this, name);
    }
    //方块被右键的拿下的方法
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
                                    EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        // 如果不是客户端
        if(!worldIn.isRemote) {
            //生成相机方块掉落物
            spawnAsEntity(worldIn,pos,new ItemStack(BlocksRegister.BLOCK_19));
            //获取空气的默认状态
            IBlockState states = Blocks.AIR.getDefaultState();
            // 在该位置生成空气
            worldIn.setBlockState(pos, states);
            return true;
        }
        return true;
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
    //决定选择框的大小
    public AxisAlignedBB getBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return BUSH_AABB;
    }
    //失去碰撞箱
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return BUSH_AABB;
    }
}
