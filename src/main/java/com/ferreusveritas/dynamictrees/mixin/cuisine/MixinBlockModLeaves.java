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
import snownee.kiwi.block.BlockMod;

@Mixin(BlockModLeaves.class)
public abstract class MixinBlockModLeaves extends BlockMod implements ICull
{
	public MixinBlockModLeaves(String name, Material materialIn)
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
