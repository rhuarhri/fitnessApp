package com.example.rhuarhri.fitnessapp;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserWeightDBInterface {



        @Query("SELECT * FROM UserWeight")
        List<UserWeight> getAll();

        @Insert(onConflict = REPLACE)
        void newWeightRow(UserWeight WeightIn);

        @Query("UPDATE UserWeight SET currentWeight = :WeightIn")
        void updateCurrentWeight(double WeightIn);

        @Query ("SELECT Count(*) FROM UserWeight")
        int getSizeOfTable();


}
