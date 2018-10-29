package com.example.rhuarhri.fitnessapp;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {UserProgress.class}, version = 1)
public abstract class UserProgressDB extends RoomDatabase {
    public abstract UserProgressDBInterface UserProgressDBInterface();
}
