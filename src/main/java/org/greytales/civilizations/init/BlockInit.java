package org.greytales.civilizations.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import org.greytales.civilizations.objects.blocks.BlockBase;
import org.greytales.civilizations.objects.blocks.BlockOres;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {

    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block BLOCK_MAGIUM = new BlockBase("block_magium", Material.IRON);

    public static final Block ORE_OVERWORLD = new BlockOres("ore_overworld", "overworld");

}
