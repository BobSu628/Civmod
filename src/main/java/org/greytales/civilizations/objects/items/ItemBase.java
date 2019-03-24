package org.greytales.civilizations.objects.items;

import net.minecraft.item.Item;
import org.greytales.civilizations.CivilizationsMod;
import org.greytales.civilizations.init.ItemInit;
import org.greytales.civilizations.tabs.CivCreativeTabs;
import org.greytales.civilizations.util.interfaces.IHasModel;

public class ItemBase extends Item implements IHasModel {

    public ItemBase(String name){
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CivCreativeTabs.civTab);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        CivilizationsMod.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
