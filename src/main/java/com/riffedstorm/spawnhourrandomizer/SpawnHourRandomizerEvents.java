package com.riffedstorm.spawnhourrandomizer;

import com.riffedstorm.spawnhourrandomizer.data.SpawnHourRandomizerData;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.level.LevelEvent;

public class SpawnHourRandomizerEvents {

    @SubscribeEvent
    public void onWorldLoad(LevelEvent.Load event) {
        // Only run on server side - client doesn't need to modify time.
        if (!(event.getLevel() instanceof ServerLevel serverLevel)) return;

        // computeIfAbsent takes a SavedData.Factory: supplier + load function.
        SpawnHourRandomizerData data = serverLevel.getDataStorage().computeIfAbsent(
            new net.minecraft.world.level.saveddata.SavedData.Factory<>(
                SpawnHourRandomizerData::new,  // constructor for new instances
                (nbt, lookup) -> {             // load from existing NBT and return instance
                    SpawnHourRandomizerData result = new SpawnHourRandomizerData();
                    if (nbt.contains("initial_time_set")) {
                        result.setInitialTimeSet(nbt.getBoolean("initial_time_set"));
                    } else {
                        result.setDirty(false);  // loaded data is not dirty.
                    }
                    return result;
                }
            ),
            SpawnHourRandomizerData.ID
        );

        // Skip if we've already randomized the spawn time for this world.
        if (data.hasInitialTimeSet()) return;

        // Only apply to the overworld dimension.
        if (!serverLevel.dimension().equals(ServerLevel.OVERWORLD)) return;

        long dayTime = serverLevel.getDayTime();
        if (dayTime >= 24000) return;

        long randomTime = Math.round(24000 * java.util.concurrent.ThreadLocalRandom.current().nextDouble());
        serverLevel.setDayTime(randomTime);

        data.setInitialTimeSet(true);
    }
}
