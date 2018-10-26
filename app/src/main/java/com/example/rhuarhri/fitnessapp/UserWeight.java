package com.example.rhuarhri.fitnessapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

@Entity
public class UserWeight {

    @ColumnInfo(name = "pastWeight")
    double pastWeight;

    @ColumnInfo(name = "currentWeight")
    double currentWeight;

    public double getPastWeight() {
        return pastWeight;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setPastWeight(double pastWeight) {
        this.pastWeight = pastWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }
}
