package com.riffedstorm.spawnhourrandomizer;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

@Mod(SpawnHourRandomizer.MOD_ID)
public class SpawnHourRandomizer {
    public static final String MOD_ID = "spawn_hour_randomizer";

    public SpawnHourRandomizer(IEventBus modEventBus) {
        // Use an instance so event methods don't need to be static.
        NeoForge.EVENT_BUS.register(new SpawnHourRandomizerEvents());
    }
}
