package com.example.rhuarhri.fitnessapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class exercises {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int exerciseId;

    private String exerciseType;

    private String exerciseName;

    public int getExerciseId() {
        return exerciseId;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }
}
