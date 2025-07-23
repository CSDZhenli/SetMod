package com.set.setmod.blocks;

import com.set.setmod.ModTabs;
import com.set.setmod.SetMod;
import com.set.setmod.UtilRegister;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(modid = SetMod.MODID)
public class BlockGrass extends Block {
        // 构造函数，初始化BlockBase对象
        public BlockGrass(String name, Material material , SoundType soundType) {
            // 调用父类Block的构造函数，传入材质参数
            super(material);
            // 设置方块类默认放方块Tabs
            setCreativeTab(ModTabs.SecondTabs);
            // 注册当前方块到游戏世界中
            UtilRegister.initBlock(this, name);
            //设置声音
            setSoundType(soundType);
        }
    //注册颜色处理器
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void registerColor(ColorHandlerEvent.Block event) {
            event.getBlockColors().registerBlockColorHandler(new IBlockColor() {
                public int colorMultiplier(IBlockState state, @Nullable IBlockAccess worldIn, @Nullable BlockPos pos, int tintIndex) {
                    return worldIn != null && pos !=null ? BiomeColorHelper.getFoliageColorAtPos(worldIn, pos) : ColorizerFoliage.getFoliageColorBasic();
                }
            },BlocksRegister.BLOCK_3);
    }
}
