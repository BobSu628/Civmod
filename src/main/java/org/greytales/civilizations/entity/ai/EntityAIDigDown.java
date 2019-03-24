package org.greytales.civilizations.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.greytales.civilizations.entity.EntityTestVillager;

import javax.annotation.Nonnull;

public class EntityAIDigDown extends EntityAIBase {

    private final EntityTestVillager villager;
    private BlockPos blockDownPos;
    private IBlockState blockState;
    private float blockDownHardness;
    private boolean digging;
    private float digSpeed;
    private float breakProgress = 0f;

    public EntityAIDigDown(EntityTestVillager villager) {
        this.villager = villager;
        this.setMutexBits(4);

    }

    @Override
    public boolean shouldExecute() {
        return villager.canDigDown();
    }

    
    @Override
    public boolean shouldContinueExecuting(){
        return digging;
    }


    @Override
    public void startExecuting() {
        blockDownPos = new BlockPos(this.villager).down();
        blockState = this.villager.world.getBlockState(blockDownPos);
        blockDownHardness = this.villager.getBlockHardness(blockDownPos, blockState);
        System.out.println(blockDownHardness);

        digSpeed = this.villager.getDigSpeed(blockDownPos);
        digging = true;
        breakProgress = 0f;
    }

    @Override
    public void resetTask() {
        super.resetTask();
        this.villager.world.sendBlockBreakProgress(this.villager.getEntityId(), blockDownPos, -1);
        reset();
    }

    @Override
    public void updateTask() {

        if(this.villager.world.getBlockState(blockDownPos).getBlock() != blockState.getBlock()){
            digging = false;
            return;
        }

        breakProgress += this.digSpeed;
        int breakProgressNorm = (int)(breakProgress / (blockDownHardness*30) * 10);
        this.villager.world.sendBlockBreakProgress(this.villager.getEntityId(), blockDownPos, breakProgressNorm);

        if(breakProgressNorm >= 10){
            this.villager.breakBlock(blockDownPos);
            reset();
        }

    }

    private void reset(){
        digging = false;
    }


}
