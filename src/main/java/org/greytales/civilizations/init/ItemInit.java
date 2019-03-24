package org.greytales.civilizations.init;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import org.greytales.civilizations.objects.armor.ArmorBase;
import org.greytales.civilizations.objects.items.ItemBase;
import org.greytales.civilizations.objects.tools.*;
import org.greytales.civilizations.util.Reference;

import java.util.ArrayList;
import java.util.List;

public class ItemInit {

    public static final List<Item> ITEMS = new ArrayList<Item>();

    //Material
    public static final Item.ToolMaterial TOOL_MAGIUM = EnumHelper.addToolMaterial("tool_magium", 0, 250, 2.0f, 0.0f, 0);
    public static final ItemArmor.ArmorMaterial ARMOR_MAGIUM = EnumHelper.addArmorMaterial("armor_magium", Reference.MODID+":magium", 15, new int[]{1,2,3,1}, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f);

    //Items
    public static final Item INGOT_MAGIUM = new ItemBase("ingot_magium");

    //Tools
    public static final Item AXE_MAGIUM = new ToolAxe("axe_magium", TOOL_MAGIUM);
    public static final Item HOE_MAGIUM = new ToolHoe("hoe_magium", TOOL_MAGIUM);
    public static final Item PICKAXE_MAGIUM = new ToolPickaxe("pickaxe_magium", TOOL_MAGIUM);
    public static final Item SHOVEL_MAGIUM = new ToolShovel("shovel_magium", TOOL_MAGIUM);
    public static final Item SWORD_MAGIUM = new ToolSword("sword_magium", TOOL_MAGIUM);

    //Armor
    public static final Item HELMET_MAGIUM = new ArmorBase("helmet_magium", ARMOR_MAGIUM, 1, EntityEquipmentSlot.HEAD);
    public static final Item CHESTPLATE_MAGIUM = new ArmorBase("chestplate_magium", ARMOR_MAGIUM, 1, EntityEquipmentSlot.CHEST);
    public static final Item LEGGINGS_MAGIUM = new ArmorBase("leggings_magium", ARMOR_MAGIUM, 2, EntityEquipmentSlot.LEGS);
    public static final Item BOOTS_MAGIUM = new ArmorBase("boots_magium", ARMOR_MAGIUM, 1, EntityEquipmentSlot.FEET);

}
