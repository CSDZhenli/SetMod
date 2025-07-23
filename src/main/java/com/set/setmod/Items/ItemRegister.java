package com.set.setmod.Items;

import com.set.setmod.SetMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = SetMod.MODID)
public class ItemRegister {
    //测试的
//    public static final ItemBow BOW_3= (ItemBow) new ItemBow().setRegistryName("ceshibow2").setCreativeTab(ModTabs.FirstTabs).setUnlocalizedName("ceshibow2");
//    public static final ItemUser CS= new ItemUser("ceshi");
    //以下是注册表/列表
    public static final List<Item> ITEMS_LIST = new ArrayList<Item>();
    public static final ItemUser USER = new ItemUser("user");
    public static final ItemBase THETHIRD = new ItemBase("thethird");
    public static final ItemBase BASE = new ItemBase("base");
    public static final ItemKill KILL = new ItemKill("kill_item");
    public static final ItemSword SWORD= new ItemSward("sward0",ItemSward.KILL);
    public static final ItemSword SWORD_CLOSE= new ItemSward("sward1",ItemSward.KILL);
    public static final ItemAvalon AVALON = new ItemAvalon("avalon");
    public static final ItemBolg BOLG = new ItemBolg("bolg", Item.ToolMaterial.DIAMOND);
    public static final ItemBowBase BOWS = new ItemBowBase("bows");
    @SubscribeEvent
    //物品注册表
    public static void ItemFirst(RegistryEvent.Register<Item> event) {
        //以下注释的为之前的内容
//        event.getRegistry().register(new ItemUser("user"));
//        event.getRegistry().register(new Item().setRegistryName("ceshibase").setCreativeTab(ModTabs.FirstTabs).setUnlocalizedName("ceshibase"));
//        event.getRegistry().register(CS);
//        event.getRegistry().register(new ItemBow().setRegistryName("ceshibow").setCreativeTab(ModTabs.FirstTabs).setUnlocalizedName("ceshibow"));
//        event.getRegistry().register(new ItemBowBase("ceshibow1"));
//        event.getRegistry().register(BOW_3);
        event.getRegistry().registerAll(ITEMS_LIST.toArray(new Item[0]));
    }
    //物品模型（材质等等）
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void ModelRegister(ModelRegistryEvent event) {
        for (Item item : ITEMS_LIST) {
            ModelLoader.setCustomModelResourceLocation(
                    item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
    }
}
