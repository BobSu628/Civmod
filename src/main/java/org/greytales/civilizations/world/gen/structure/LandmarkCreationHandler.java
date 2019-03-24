package org.greytales.civilizations.world.gen.structure;

import net.minecraft.util.EnumFacing;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

import java.util.List;
import java.util.Random;

public class LandmarkCreationHandler implements VillagerRegistry.IVillageCreationHandler {

    @Override
    public StructureVillagePieces.PieceWeight getVillagePieceWeight(Random rand, int parType)
    {
        // DEBUG
        System.out.println("Getting landmark piece weight");

        return new StructureVillagePieces.PieceWeight(getComponentClass(), 100, 1);
    }

    @Override
    public Class<? extends StructureVillagePieces.Village> getComponentClass()
    {
        return Landmark.class;
    }

    @Override
    public StructureVillagePieces.Village buildComponent(
            StructureVillagePieces.PieceWeight parPieceWeight,
            StructureVillagePieces.Start parStart,
            List<StructureComponent> parPiecesList,
            Random parRand,
            int parMinX, int parMinY, int parMinZ,
            EnumFacing parFacing,
            int parType
    )
    {
        // DEBUG
        //System.out.println("Village House Cloud buildComponent() at "+parMinX+", "+parMinY+", "+parMinZ);

        StructureBoundingBox structBB = StructureBoundingBox.getComponentToAddBoundingBox(parMinX, parMinY, parMinZ, 0, 0, 0, 9, 7, 12, parFacing);
        return new Landmark(parStart, parType, parRand, structBB, parFacing);
    }

}
