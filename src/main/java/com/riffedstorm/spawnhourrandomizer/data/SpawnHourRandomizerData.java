package com.riffedstorm.spawnhourrandomizer.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.saveddata.SavedData;

public class SpawnHourRandomizerData extends SavedData {

    public static final String ID = "spawn_hour_randomizer_data";

    private boolean initialTimeSet = false;

    public void setInitialTimeSet(boolean value) {
        this.initialTimeSet = value;
        setDirty();
    }

    public boolean hasInitialTimeSet() {
        return initialTimeSet;
    }

    @Override
    public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
        nbt.putBoolean("initial_time_set", initialTimeSet);
        return nbt;
    }
}
