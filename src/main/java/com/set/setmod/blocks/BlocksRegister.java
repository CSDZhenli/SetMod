package com.set.setmod.blocks;
import com.set.setmod.SetMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = SetMod.MODID)
/**setBlockUnbreakable方法用于设定方块的硬度为-1，即不能损坏。
setHardness方法用于设定方块的硬度，如黑曜石是50，铁块5，金块3，圆石2，石头1.5，南瓜1，泥土0.5，甘蔗0，基岩-1。
setHarvestLevel方法用于设定方块的可挖掘等级，如钻石镐是3，铁2，石1，木金0。
setLightLevel方法用于设定方块的光照，其周围的光照为设定值x15，如岩浆1.0，对应15，红石火把0.5，对应7.5。
setLightOpacity方法用于设定方块的透光率，数值越大透光率越低，如树叶和蜘蛛网是1，水和冰3。
setResistance方法用于设定方块的爆炸抗性，如木头的抗性为4，石头为10，黑曜石为2000，基岩为6000000。
setStepSound方法用于设定走在方块上的响声。
setSoundType方法用于声音套装类型
setTickRandomly方法用于设定方块是否会接受随机Tick（如农作物）。*/
public class BlocksRegister {
//    public static final Block BLOCK_1 = new Block(Material.ROCK).setRegistryName("block").setHardness(30.0f).setResistance(500.0f).setLightLevel(15.0f);
    //跟ItemRegister一样，下面的是注册表/列表，只不过这里可以调方块的参数
    public static final List<Block> BLOCK_LIST= new ArrayList<Block>();
    public static final Block BLOCK_1= new BlockNewBase("block1", Material.GLASS, SoundType.GLASS).setLightLevel(1).setHardness(1.5F);
    public static final Block BLOCK_2= new BlockBase("block2", Material.ROCK);
    public static final Block BLOCK_3= new BlockGrass("block3", Material.GRASS, SoundType.PLANT).setHardness(1.5F);
    public static final Block BLOCK_4= new BlockBase("block4", Material.ROCK).setHardness(1.5F);
    public static final Block BLOCK_5= new BlockFakeBase("portal",Material.ROCK).setHardness(-1);
    @SubscribeEvent
    //注册方块
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
//        event.getRegistry().register(BLOCK_1);
        event.getRegistry().registerAll(BLOCK_LIST.toArray(new Block[0]));
    }
}
