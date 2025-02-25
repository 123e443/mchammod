package com.arrl.radiocraft.datagen;

import com.arrl.radiocraft.Radiocraft;
import com.arrl.radiocraft.common.init.RadiocraftBlocks;
import com.arrl.radiocraft.common.init.RadiocraftItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Datagen class for localization files.
 */
public class RadiocraftLanguageProvider extends LanguageProvider {

	private final String locale;

	// Add translations to this map-- crude way to allow for multiple language sets without a ton of classes
	private static final Map<String, Consumer<LanguageProvider>> TRANSLATION_PROVIDERS = new HashMap<>();

	static {
		// Add translation sets here.
		TRANSLATION_PROVIDERS.put("en_us", (provider) -> {
			provider.add(Radiocraft.translationKey("tabs", "main_tab"), "RadioCraft");
			provider.addItem(RadiocraftItems.RADIO_CRYSTAL, "Radio Crystal");
			provider.addItem(RadiocraftItems.RADIO_SPEAKER, "Radio Speaker");
			provider.addItem(RadiocraftItems.MICROPHONE, "Microphone");
			provider.addItem(RadiocraftItems.HAND_MICROPHONE, "Hand Microphone");
			provider.addItem(RadiocraftItems.HF_CIRCUIT_BOARD, "HF Circuit Board");
			provider.addItem(RadiocraftItems.SMALL_BATTERY, "Small Alkaline Battery");
			provider.addItem(RadiocraftItems.FERRITE_CORE, "Ferrite Core");
			provider.addItem(RadiocraftItems.COAXIAL_CORE, "Coaxial Core");
			provider.addItem(RadiocraftItems.ANTENNA_ANALYZER, "Antenna Analyzer");
			provider.addItem(RadiocraftItems.VHF_HANDHELD, "VHF Handheld Radio");

			provider.addBlock(RadiocraftBlocks.WIRE, "Wire");
			provider.addBlock(RadiocraftBlocks.WATERPROOF_WIRE, "Waterproof Wire");
			provider.addBlock(RadiocraftBlocks.SOLAR_PANEL, "Solar Panel");
			provider.addBlock(RadiocraftBlocks.SOLAR_WEATHER_STATION, "Solar Weather Station");
			provider.addBlock(RadiocraftBlocks.LARGE_BATTERY, "Large Battery");
			provider.addBlock(RadiocraftBlocks.VHF_BASE_STATION, "VHF Base Station");
			provider.addBlock(RadiocraftBlocks.VHF_RECEIVER, "VHF Receiver");
			provider.addBlock(RadiocraftBlocks.VHF_REPEATER, "VHF Repeater");
			provider.addBlock(RadiocraftBlocks.HF_RADIO_10M, "HF Radio (10m)");
			provider.addBlock(RadiocraftBlocks.HF_RADIO_20M, "HF Radio (20m)");
			provider.addBlock(RadiocraftBlocks.HF_RADIO_40M, "HF Radio (40m)");
			provider.addBlock(RadiocraftBlocks.HF_RADIO_80M, "HF Radio (80m)");
			provider.addBlock(RadiocraftBlocks.HF_RECEIVER, "HF Receiver");
			provider.addBlock(RadiocraftBlocks.ALL_BAND_RADIO, "All Band Radio");
			provider.addBlock(RadiocraftBlocks.QRP_RADIO_20M, "QRP Radio (20m)");
			provider.addBlock(RadiocraftBlocks.QRP_RADIO_40M, "QRP Radio (40m)");
			provider.addBlock(RadiocraftBlocks.ANTENNA_POLE, "Antenna Pole");
			provider.addBlock(RadiocraftBlocks.DUPLEXER, "Duplexer");
			provider.addBlock(RadiocraftBlocks.ANTENNA_TUNER, "Antenna Tuner");
			provider.addBlock(RadiocraftBlocks.ANTENNA_WIRE, "Antenna Wire");
			provider.addBlock(RadiocraftBlocks.ANTENNA_CONNECTOR, "Antenna Connector");
			provider.addBlock(RadiocraftBlocks.COAX_WIRE, "Coaxial Wire");
			provider.addBlock(RadiocraftBlocks.DIGITAL_INTERFACE, "Digital Interface (TNC)");
		});
	}

	public RadiocraftLanguageProvider(PackOutput output, String locale) {
		super(output, Radiocraft.MOD_ID, locale);
		this.locale = locale;
	}

	@Override
	protected void addTranslations() {
		// No error checking, I want a hard crash here if datagen has something bad as it's all hardcoded and should not run if erroring.
		// Only runs with datagen run config
		TRANSLATION_PROVIDERS.get(locale).accept(this);
	}

}
