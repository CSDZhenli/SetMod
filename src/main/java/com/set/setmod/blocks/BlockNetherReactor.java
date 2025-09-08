package com.set.setmod.blocks;

import com.set.setmod.ModTabs;
import com.set.setmod.UtilRegister;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockNetherReactor extends Block {
    // 构造函数，初始化BlockBase对象
    public BlockNetherReactor(String name, Material material) {
        // 调用父类Block的构造函数，传入材质参数
        super(material);
        // 设置方块类默认放方块Tabs
        setCreativeTab(ModTabs.SecondTabs);
        // 注册当前方块到游戏世界中
        UtilRegister.initBlock(this, name);
    }
    // 方块被右键时的方法
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
                                    EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        // 如果不是客户端
        if(!worldIn.isRemote) {
            //获取激活下界反应核的默认状态
            IBlockState states = BlocksRegister.BLOCK_13.getDefaultState();
            //获取激活的黑曜石的默认状态
            IBlockState states0 = BlocksRegister.BLOCK_12.getDefaultState();
            // 在该位置生成激活的下界反应堆
            worldIn.setBlockState(pos, states);
            // 生成第一层
            worldIn.setBlockState(pos.down(), states0);
            worldIn.setBlockState(pos.down().east(), states0);
            worldIn.setBlockState(pos.down().south(), states0);
            worldIn.setBlockState(pos.down().north(), states0);
            worldIn.setBlockState(pos.down().west(), states0);
            //冷却到了，放第二层
            worldIn.setBlockState(pos.east().south(), states0);
            worldIn.setBlockState(pos.east().north(), states0);
            worldIn.setBlockState(pos.west().south(), states0);
            worldIn.setBlockState(pos.west().north(), states0);
            //冷却到了，放第三层
            worldIn.setBlockState(pos.up(), states0);
            worldIn.setBlockState(pos.up().east(), states0);
            worldIn.setBlockState(pos.up().south(), states0);
            worldIn.setBlockState(pos.up().north(), states0);
            worldIn.setBlockState(pos.up().west(), states0);
            //冷却到了，放第四层
            worldIn.setBlockState(pos.down().east().south(), states0);
            worldIn.setBlockState(pos.down().east().north(), states0);
            worldIn.setBlockState(pos.down().west().south(), states0);
            worldIn.setBlockState(pos.down().west().north(), states0);
            return true;
        }
        return true;
    }
}
