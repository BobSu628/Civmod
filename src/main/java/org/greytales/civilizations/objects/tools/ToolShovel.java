package org.greytales.civilizations.objects.tools;

import net.minecraft.item.ItemSpade;
import org.greytales.civilizations.CivilizationsMod;
import org.greytales.civilizations.init.ItemInit;
import org.greytales.civilizations.tabs.CivCreativeTabs;
import org.greytales.civilizations.util.interfaces.IHasModel;

public class ToolShovel extends ItemSpade implements IHasModel {

    public ToolShovel(String name, ToolMaterial material){
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
