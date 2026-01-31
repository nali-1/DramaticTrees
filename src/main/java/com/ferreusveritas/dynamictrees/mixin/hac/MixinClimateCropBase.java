package com.ferreusveritas.dynamictrees.mixin.hac;

import com.ferreusveritas.dynamictrees.Cull;
import defeatedcrow.hac.core.base.BlockDC;
import defeatedcrow.hac.core.base.ClimateCropBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.FMLLaunchHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClimateCropBase.class)
public abstract class MixinClimateCropBase extends BlockDC
{
	public MixinClimateCropBase(Material m, String s)
	{
		super(m, s);
	}

	@Inject(method = "<init>", at = @At("TAIL"))
	public void Mset(CallbackInfo ci)
	{
		if (FMLLaunchHandler.side().isClient())
			Cull.vCULL.add(this);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
	{
		return Cull.mCULL(blockAccess, pos, side) && super.shouldSideBeRendered(blockState, blockAccess, pos, side);
	}
}
