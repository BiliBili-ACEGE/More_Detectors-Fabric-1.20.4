package net.ace.moredetectors;

import net.fabricmc.api.ModInitializer;

import net.ace.moredetectors.item.ModItemGroups;
import net.ace.moredetectors.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class moredetectors implements ModInitializer {
	public static final String MOD_ID = "moredetectors";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
	}
}