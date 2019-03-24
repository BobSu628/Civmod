package org.greytales.civilizations.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import org.greytales.civilizations.CivilizationsMod;
import org.greytales.civilizations.init.BlockInit;
import org.greytales.civilizations.init.ItemInit;
import org.greytales.civilizations.tabs.CivCreativeTabs;
import org.greytales.civilizations.util.interfaces.IHasModel;

public class BlockBase extends Block implements IHasModel {

    public BlockBase(String name, Material material){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CivCreativeTabs.civTab);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName())) ;
    }

    @Override
    public void registerModels() {
        CivilizationsMod.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
