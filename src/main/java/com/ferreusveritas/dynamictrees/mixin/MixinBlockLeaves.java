package com.ferreusveritas.dynamictrees.mixin;

import com.ferreusveritas.dynamictrees.Cull;
import com.ferreusveritas.dynamictrees.ICull;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BlockLeaves.class)
public abstract class MixinBlockLeaves extends Block implements ICull
{
	public MixinBlockLeaves(Material materialIn)
	{
		super(materialIn);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT_MIPPED;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
	{
		return Cull.mCULL(blockAccess, pos, side) && super.shouldSideBeRendered(blockState, blockAccess, pos, side);
	}
}