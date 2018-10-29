package com.example.rhuarhri.fitnessapp;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity
public class UserProgress {

    @PrimaryKey
    @ColumnInfo(name = "type")
    private String type;

    @ColumnInfo(name = "legs")
    private int legs;

    @ColumnInfo(name = "arms")
    private int arms;

    @ColumnInfo(name = "chest")
    private int chest;

    @ColumnInfo(name = "recordDate")
    private Date recordDate;

    public String getType() {
        return type;
    }

    public int getLegs() {
        return legs;
    }

    public int getArms() {
        return arms;
    }

    public int getChest() {
        return chest;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public void setArms(int arms) {
        this.arms = arms;
    }

    public void setChest(int chest) {
        this.chest = chest;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }
}
