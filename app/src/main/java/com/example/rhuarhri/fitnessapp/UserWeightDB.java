package com.example.rhuarhri.fitnessapp;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;


    @Database(entities = {UserWeight.class}, version = 1)
    public abstract class UserWeightDB extends RoomDatabase {
        public abstract UserWeightDBInterface UserWeightDBInterface();
    }

