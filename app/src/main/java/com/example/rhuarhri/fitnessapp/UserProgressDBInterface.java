package com.example.rhuarhri.fitnessapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserProgressDBInterface {

    @Query ("SELECT * FROM UserProgress WHERE type = 'overall'")
    UserProgress getOverall();

    @Query ("SELECT legs, arms, chest FROM UserProgress WHERE type = 'today'")
    UserProgress getToday();

    @Insert (onConflict = REPLACE)
    void setUp(UserProgress defaultData);

    @Update (onConflict = REPLACE)
    void update(UserProgress newInfo);

    @Query ("SELECT Count(*) FROM UserProgress")
    int getSizeOfTable();



}
