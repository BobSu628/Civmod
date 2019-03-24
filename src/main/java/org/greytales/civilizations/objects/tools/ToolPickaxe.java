package org.greytales.civilizations.objects.tools;

import net.minecraft.item.ItemPickaxe;
import org.greytales.civilizations.CivilizationsMod;
import org.greytales.civilizations.init.ItemInit;
import org.greytales.civilizations.tabs.CivCreativeTabs;
import org.greytales.civilizations.util.interfaces.IHasModel;

public class ToolPickaxe extends ItemPickaxe implements IHasModel {

    public ToolPickaxe(String name, ToolMaterial material){
        super(material);
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