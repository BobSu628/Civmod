package org.greytales.civilizations.objects.armor;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import org.greytales.civilizations.CivilizationsMod;
import org.greytales.civilizations.init.ItemInit;
import org.greytales.civilizations.tabs.CivCreativeTabs;
import org.greytales.civilizations.util.interfaces.IHasModel;

public class ArmorBase extends ItemArmor implements IHasModel {

    public ArmorBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);

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
