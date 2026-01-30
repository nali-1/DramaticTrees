package com.ferreusveritas.dynamictrees.mixin.hac;

import defeatedcrow.hac.core.base.ClimateCropBase;
import defeatedcrow.hac.food.block.crop.BlockLeavesLemon;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BlockLeavesLemon.class)
public abstract class MixinBlockLeavesLemon extends ClimateCropBase
{
	public MixinBlockLeavesLemon(Material material, String s, int max)
	{
		super(material, s, max);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
	{
		return super.shouldSideBeRendered(blockState, blockAccess, pos, side);
	}
}
