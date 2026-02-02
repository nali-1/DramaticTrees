package com.ferreusveritas.dynamictrees.mixin.cuisine;

import com.ferreusveritas.dynamictrees.Cull;
import com.ferreusveritas.dynamictrees.ICull;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import snownee.cuisine.blocks.BlockModLeaves;
import snownee.cuisine.blocks.BlockShearedLeaves;
import snownee.kiwi.block.BlockMod;

@Mixin(BlockShearedLeaves.class)
public abstract class MixinBlockShearedLeaves extends BlockMod implements ICull
{
	public MixinBlockShearedLeaves(String name, Material materialIn)
	{
		super(name, materialIn);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
	{
		return Cull.mCULL(blockAccess, pos, side) && super.shouldSideBeRendered(blockState, blockAccess, pos, side);
	}
}
