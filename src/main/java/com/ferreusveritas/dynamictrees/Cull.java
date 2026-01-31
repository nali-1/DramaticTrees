package com.ferreusveritas.dynamictrees;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

public class Cull
{
	@SideOnly(Side.CLIENT)
	public static List<Block> vCULL = new ArrayList<Block>();
	@SideOnly(Side.CLIENT)
	public static List<Block> vCULL_BUSH = new ArrayList<Block>();
	@SideOnly(Side.CLIENT)
	public static boolean mCULL(IBlockAccess Viblockaccess, BlockPos Vblockpos, EnumFacing Venumfacing)
	{
		IBlockState Viblockstate = Viblockaccess.getBlockState(Vblockpos.offset(Venumfacing));
		Block Vblock = Viblockstate.getBlock();
		return !(vCULL.contains(Vblock) || (vCULL_BUSH.contains(Vblock) && Vblock.getMetaFromState(Viblockstate) > 1));
	}
}
