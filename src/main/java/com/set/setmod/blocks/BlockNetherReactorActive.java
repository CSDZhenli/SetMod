package com.set.setmod.blocks;

import com.set.setmod.ModTabs;
import com.set.setmod.UtilRegister;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockNetherReactorActive extends Block {
    //放置所用函数
    boolean first = true;
    boolean second = true;
    boolean third = true;
    boolean fourth = true;
    // 构造函数，初始化BlockBase对象
    public BlockNetherReactorActive(String name, Material material) {
        // 调用父类Block的构造函数，传入材质参数
        super(material);
        // 设置方块类默认放方块Tabs
        setCreativeTab(ModTabs.SecondTabs);
        // 注册当前方块到游戏世界中
        UtilRegister.initBlock(this, name);
    }
    //当该方块被放置时使用的函数

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        if (!worldIn.isRemote){
            //放东西
            worldIn.scheduleBlockUpdate(pos,this,5,0);
        }
    }
    //更新时使用该函数
    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (!worldIn.isRemote) {
            //获取激活的黑曜石的默认状态
            IBlockState states0 = BlocksRegister.BLOCK_12.getDefaultState();
            if (first) {
                // 生成第一层
                worldIn.setBlockState(pos.down(), states0);
                worldIn.setBlockState(pos.down().east(), states0);
                worldIn.setBlockState(pos.down().south(), states0);
                worldIn.setBlockState(pos.down().north(), states0);
                worldIn.setBlockState(pos.down().west(), states0);
                //调用该函数，进行下一次更新
                worldIn.scheduleBlockUpdate(pos,this,5,0);
                first = false;
            } else if (second) {
                //生成第二层
                worldIn.setBlockState(pos.east().south(), states0);
                worldIn.setBlockState(pos.east().north(), states0);
                worldIn.setBlockState(pos.west().south(), states0);
                worldIn.setBlockState(pos.west().north(), states0);
                //调用该函数，进行下一次更新
                worldIn.scheduleBlockUpdate(pos,this,5,0);
                second = false;
            } else if (third) {
                //生成第三层
                worldIn.setBlockState(pos.up(), states0);
                worldIn.setBlockState(pos.up().east(), states0);
                worldIn.setBlockState(pos.up().south(), states0);
                worldIn.setBlockState(pos.up().north(), states0);
                worldIn.setBlockState(pos.up().west(), states0);
                //调用该函数，进行下一次更新
                worldIn.scheduleBlockUpdate(pos,this,5,0);
                third = false;
            } else if(fourth){
                worldIn.setBlockState(pos.down().east().south(), states0);
                worldIn.setBlockState(pos.down().east().north(), states0);
                worldIn.setBlockState(pos.down().west().south(), states0);
                worldIn.setBlockState(pos.down().west().north(), states0);
                //调用该函数，进行下一次更新
                worldIn.scheduleBlockUpdate(pos,this,5,0);
                fourth= false;
            }else{
                first=true;
                second=true;
                third=true;
                fourth=true;
            }
        }
    }
}
