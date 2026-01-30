package com.ferreusveritas.dynamictrees;

import zone.rong.mixinbooter.ILateMixinLoader;

import java.util.Collections;
import java.util.List;

public class Late implements ILateMixinLoader
{
	@Override
	public List<String> getMixinConfigs()
	{
		return Collections.singletonList("mixins." + Tags.MOD_ID + "_late.json");
	}
}
