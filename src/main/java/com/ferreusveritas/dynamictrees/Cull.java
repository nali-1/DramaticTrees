package com.ferreusveritas.dynamictrees;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Cull
{
	@SideOnly(Side.CLIENT)
	public static boolean mCULL(IBlockAccess Viblockaccess, BlockPos Vblockpos, EnumFacing Venumfacing)
	{
		IBlockState Viblockstate = Viblockaccess.getBlockState(Vblockpos.offset(Venumfacing));
		Block Vblock = Viblockstate.getBlock();
		if (Vblock instanceof ICull)
		{
			return false;
		}
		if (Vblock instanceof ICullBush)
		{
			return !(Vblock.getMetaFromState(Viblockstate) > 1);
		}
		return true;
	}
}
