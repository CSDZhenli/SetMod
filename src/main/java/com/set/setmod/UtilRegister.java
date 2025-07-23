package com.set.setmod;

import com.set.setmod.Items.ItemRegister;
import com.set.setmod.blocks.BlocksRegister;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

//封装ItemBowBase那些的，主要是用于方便改东西用的，可以删也可以不删,就相当于py的del方法
public class UtilRegister {
    public static void initItem(Item item,String name) {
        // 设置物品的翻译键
        item.setRegistryName(name);
        // 设置物品的注册名
        item.setUnlocalizedName(name);
        // 设置物品的创造模式Tab
        ItemRegister.ITEMS_LIST.add(item);
    }

    public static void initBlock(Block block, String name) {
        // 设置物品的翻译键
        block.setRegistryName(name);
        // 设置物品的注册名
        block.setUnlocalizedName(name);
        // 设置物品的创造模式Tab
        BlocksRegister.BLOCK_LIST.add(block);
        // 创建一个新的方块物品，对应方块
        ItemBlock item = new ItemBlock(block);
        // 初始化物品，并将其添加到物品注册列表中
        initItem(item,name);
    }
}
