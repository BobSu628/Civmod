package org.greytales.civilizations.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import org.greytales.civilizations.init.ItemInit;

public class CivTab extends CreativeTabs {

    public CivTab(String label){
        super(label);
        this.setBackgroundImageName("civ.png");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemInit.INGOT_MAGIUM);
    }
}
