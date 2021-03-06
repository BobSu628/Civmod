package org.greytales.civilizations.entity;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.AbstractIllager;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import org.greytales.civilizations.entity.ai.EntityAIDigDown;

public class EntityTestVillager extends EntityVillager {

    private InventoryBasic inventory;

    public EntityTestVillager(World worldIn) {
        super(worldIn);
        this.setSize(0.6f, 1.8f);
        this.inventory = new InventoryBasic("Items", false, 8);
        this.setHeldItem(EnumHand.MAIN_HAND, new ItemStack(Items.IRON_HOE));

        /*
        if(this.getItemStackFromSlot(EntityEquipmentSlot.CHEST) == ItemStack.EMPTY){
            this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
        }
        if(this.getItemStackFromSlot(EntityEquipmentSlot.HEAD) == ItemStack.EMPTY){
            this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.DIAMOND_HELMET));
        }
        if(this.getItemStackFromSlot(EntityEquipmentSlot.LEGS) == ItemStack.EMPTY){
            this.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(Items.DIAMOND_LEGGINGS));
        }
        if(this.getItemStackFromSlot(EntityEquipmentSlot.FEET) == ItemStack.EMPTY){
            this.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(Items.DIAMOND_BOOTS));
        }
        */
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_SPEED);

    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        this.updateArmSwingProgress();
    }

    @Override
    protected void initEntityAI() {
        //this.tasks.addTask(0, new EntityAIDigDown(this));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
        this.applyEntityAI();
    }

    protected void applyEntityAI(){
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<EntityZombie>(this, EntityZombie.class, false));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<EntitySlime>(this, EntitySlime.class, false));
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        float damage = (float)this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
        int knockbackModifier = 0;

        if (entityIn instanceof EntityLivingBase)
        {
            damage += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(), ((EntityLivingBase)entityIn).getCreatureAttribute());
            knockbackModifier += EnchantmentHelper.getKnockbackModifier(this);
        }

        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), damage);

        if (flag)
        {
            if (knockbackModifier > 0 && entityIn instanceof EntityLivingBase)
            {
                ((EntityLivingBase)entityIn).knockBack(this, (float)knockbackModifier * 0.5F, (double)MathHelper.sin(this.rotationYaw * 0.017453292F), (double)(-MathHelper.cos(this.rotationYaw * 0.017453292F)));
                this.motionX *= 0.6D;
                this.motionZ *= 0.6D;
            }

            int fireAspectModifier = EnchantmentHelper.getFireAspectModifier(this);

            if (fireAspectModifier > 0)
            {
                entityIn.setFire(fireAspectModifier * 4);
            }

            if (entityIn instanceof EntityPlayer)
            {
                EntityPlayer entityplayer = (EntityPlayer)entityIn;
                ItemStack itemstack = this.getHeldItemMainhand();
                ItemStack itemstack1 = entityplayer.isHandActive() ? entityplayer.getActiveItemStack() : ItemStack.EMPTY;

                if (!itemstack.isEmpty() && !itemstack1.isEmpty() && itemstack.getItem() instanceof ItemAxe && itemstack1.getItem() == Items.SHIELD)
                {
                    float f1 = 0.25F + (float)EnchantmentHelper.getEfficiencyModifier(this) * 0.05F;

                    if (this.rand.nextFloat() < f1)
                    {
                        entityplayer.getCooldownTracker().setCooldown(Items.SHIELD, 100);
                        this.world.setEntityState(entityplayer, (byte)30);
                    }
                }
            }

            this.applyEnchantments(this, entityIn);
        }

        return flag;
    }

    @Override
    public float getEyeHeight(){
        return 1.62F;
    }

    @Override
    protected boolean canEquipItem(ItemStack stack) {
        return stack.getItem() == Items.SLIME_BALL;
    }

    public void breakBlock(BlockPos pos){
        this.world.destroyBlock(pos, true);
    }

    public float getDigSpeed(BlockPos pos)
    {
        IBlockState state = this.world.getBlockState(pos);

        float f = this.getHeldItemMainhand().getStrVsBlock(state);
        //System.out.println(f);

        if (f > 1.0F)
        {
            int i = EnchantmentHelper.getEfficiencyModifier(this);
            ItemStack itemstack = this.getHeldItemMainhand();

            if (i > 0 && !itemstack.isEmpty())
            {
                f += (float)(i * i + 1);
            }
        }

        if (this.isPotionActive(MobEffects.HASTE))
        {
            f *= 1.0F + (float)(this.getActivePotionEffect(MobEffects.HASTE).getAmplifier() + 1) * 0.2F;
        }

        if (this.isPotionActive(MobEffects.MINING_FATIGUE))
        {
            float f1;

            switch (this.getActivePotionEffect(MobEffects.MINING_FATIGUE).getAmplifier())
            {
                case 0:
                    f1 = 0.3F;
                    break;
                case 1:
                    f1 = 0.09F;
                    break;
                case 2:
                    f1 = 0.0027F;
                    break;
                case 3:
                default:
                    f1 = 8.1E-4F;
            }

            f *= f1;
        }

        if (this.isInsideOfMaterial(Material.WATER) && !EnchantmentHelper.getAquaAffinityModifier(this))
        {
            f /= 5.0F;
        }

        if (prevPosY != posY)
        {
            f /= 5.0F;
        }

        //Don't delete this line, probably used for registering break event
        //f = net.minecraftforge.event.ForgeEventFactory.getBreakSpeed(this, state, f, pos);
        return (f < 0 ? 0 : f);
    }

    public boolean canDigDown(){

        Block block = this.world.getBlockState(new BlockPos(this).down()).getBlock();

        return block != Blocks.AIR && block != Blocks.WATER && block != Blocks.LAVA && block != Blocks.BEDROCK;
    }

    public float getBlockHardness(BlockPos blockDownPos, IBlockState blockState){

        float blockDownHardness = blockState.getBlock().getBlockHardness(blockState, this.world, blockDownPos);

        if(ForgeHooks.canToolHarvestBlock(this.world, blockDownPos, this.getHeldItemMainhand())) {
            blockDownHardness *= 1.5;
        }else{
            blockDownHardness *= 5;
        }

        return blockDownHardness;
    }

}
