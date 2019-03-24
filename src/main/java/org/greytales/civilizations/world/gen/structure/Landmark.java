package org.greytales.civilizations.world.gen.structure;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureVillagePieces;

import java.util.Random;

public class Landmark extends StructureVillagePieces.Village {

    public Landmark(StructureVillagePieces.Start start, int type, Random rand, StructureBoundingBox structBB, EnumFacing facing){
        super(start, type);
        setCoordBaseMode(facing);
        this.boundingBox = structBB;
    }

    @Override
    public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn) {
        if (averageGroundLvl < 0)
        {
            averageGroundLvl = getAverageGroundLevel(worldIn, structureBoundingBoxIn);

            if (averageGroundLvl < 0)
            {
                return true;
            }

            boundingBox.offset(0, averageGroundLvl - boundingBox.maxY - 1, 0);
        }
        IBlockState brick = this.getBiomeSpecificBlockState(Blocks.BRICK_BLOCK.getDefaultState());
        this.fillWithBlocks(worldIn, structureBoundingBoxIn, 0,0,0,2,20,2, brick, brick, false);

        return true;

    }
}
