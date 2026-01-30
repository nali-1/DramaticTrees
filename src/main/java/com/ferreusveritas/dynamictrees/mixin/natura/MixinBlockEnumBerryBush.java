package com.ferreusveritas.dynamictrees.mixin.natura;

import com.progwml6.natura.common.block.BlockEnumBerryBush;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BlockEnumBerryBush.class)
public abstract class MixinBlockEnumBerryBush extends Block
{
	@Shadow(remap = false)
	@Final
	public static PropertyInteger AGE;

	public MixinBlockEnumBerryBush(Material blockMaterialIn, MapColor blockMapColorIn)
	{
		super(blockMaterialIn, blockMapColorIn);
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
		IBlockState Viblockstate = blockAccess.getBlockState(pos.offset(side));
		Block Vblock = Viblockstate.getBlock();
		return !(Vblock instanceof BlockLeaves || (Vblock instanceof MixinBlockEnumBerryBush && Viblockstate.getValue(AGE) > 1)) && super.shouldSideBeRendered(blockState, blockAccess, pos, side);
	}
}
