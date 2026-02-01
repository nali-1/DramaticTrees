package com.ferreusveritas.dynamictrees.mixin.hac;

import com.ferreusveritas.dynamictrees.Cull;
import com.ferreusveritas.dynamictrees.ICull;
import defeatedcrow.hac.core.base.BlockDC;
import defeatedcrow.hac.core.base.ClimateCropBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ClimateCropBase.class)
public abstract class MixinClimateCropBase extends BlockDC implements ICull
{
	public MixinClimateCropBase(Material m, String s)
	{
		super(m, s);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
	{
		return Cull.mCULL(blockAccess, pos, side) && super.shouldSideBeRendered(blockState, blockAccess, pos, side);
	}
}
