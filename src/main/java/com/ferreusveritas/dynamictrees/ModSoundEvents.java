package com.ferreusveritas.dynamictrees;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Tags.MOD_ID)
public class ModSoundEvents
{

	public final static SoundEvent TREE_CRACK_SMALL = new SoundEvent(new ResourceLocation(Tags.MOD_ID + ":entities.tree.crack_small"));
	public final static SoundEvent TREE_CRACK_LARGE = new SoundEvent(new ResourceLocation(Tags.MOD_ID + ":entities.tree.crack_large"));
	public final static SoundEvent TREE_LANDING = new SoundEvent(new ResourceLocation(Tags.MOD_ID + ":entities.tree.landing"));

	@SubscribeEvent
	public static void register(RegistryEvent.Register<SoundEvent> event) {
		TREE_CRACK_SMALL.setRegistryName(new ResourceLocation(Tags.MOD_ID + ":entities.tree.crack_small"));
		event.getRegistry().register(TREE_CRACK_SMALL);
		TREE_CRACK_LARGE.setRegistryName(new ResourceLocation(Tags.MOD_ID + ":entities.tree.crack_large"));
		event.getRegistry().register(TREE_CRACK_LARGE);
		TREE_LANDING.setRegistryName(new ResourceLocation(Tags.MOD_ID + ":entities.tree.landing"));
		event.getRegistry().register(TREE_LANDING);
	}

}