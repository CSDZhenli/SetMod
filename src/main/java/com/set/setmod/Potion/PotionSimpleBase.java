package com.set.setmod.Potion;

import net.minecraft.potion.Potion;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


//这里是SimplePotionBase,是做空药水效果用的

public class PotionSimpleBase extends Potion {
    protected static final ResourceLocation resource = new ResourceLocation("setmod","textures/misc/potions.png");
    protected final int iconIndex;

//    if (!this.world.isRemote)
//    {
//        layer.getPotion().applyAttributesModifiersToEntity(this, this.getAttributeMap(), layer.getAmplifier());
//    }

    //这个是给buff（或者说药水效果）搞名字的
    public PotionSimpleBase(boolean isBadEffectIn, int liquidColorIn, String name, int icon) {
        super(isBadEffectIn, liquidColorIn);
        setRegistryName(new ResourceLocation(name));
        setPotionName("setmod.potion." + name);
        iconIndex = icon;
    }
    //以下为渲染（这玩意能别动尽量别动，不然调整起来巨麻烦，除非非常有自信去调整）
    @SideOnly(Side.CLIENT)
    protected void render(int x, int y, float alpha) {
        Minecraft.getMinecraft().renderEngine.bindTexture(resource);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buf = tessellator.getBuffer();
        buf.begin(7, DefaultVertexFormats.POSITION_TEX);
        GlStateManager.color(1, 1, 1, alpha);

        int textureX = iconIndex % 14 * 18;
        int textureY = 198 - iconIndex / 14 * 18;

        buf.pos(x, y + 18, 0).tex(textureX * 0.00390625, (textureY + 18) * 0.00390625).endVertex();
        buf.pos(x + 18, y + 18, 0).tex((textureX + 18) * 0.00390625, (textureY + 18) * 0.00390625).endVertex();
        buf.pos(x + 18, y, 0).tex((textureX + 18) * 0.00390625, textureY * 0.00390625).endVertex();
        buf.pos(x, y, 0).tex(textureX * 0.00390625, textureY * 0.00390625).endVertex();

        tessellator.draw();
    }
    //重写renderInventoryEffect，该renderInventoryEffect类负责处理玩家物品栏里的图标绘制
    @Override
    @SideOnly(Side.CLIENT)
    public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
        render(x + 6, y + 7, 1);
    }
    //重写renderHUDEffect，该renderHUDEffect类负责正常游戏时 HUD 中药水效果图标的绘制
    @Override
    @SideOnly(Side.CLIENT)
    public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha) {
        render(x + 3, y + 3, alpha);
    }
}