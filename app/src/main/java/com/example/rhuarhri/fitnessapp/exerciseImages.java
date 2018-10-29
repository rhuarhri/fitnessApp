package com.example.rhuarhri.fitnessapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/*
The way the foreign key works
this table is linked to the exercise table
by
exercise id is linked to exercise table primary key

if an exercise is deleted every row in this table linked
to the exercise is deleted
 */

@Entity(foreignKeys = @ForeignKey(entity = exercises.class,
        parentColumns = "id",
        childColumns = "exercise",
        onDelete = ForeignKey.CASCADE))
public class exerciseImages {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int imageId;

    @ColumnInfo(name = "exercise")
    private int exerciseId;

    @ColumnInfo(name = "order")
    private int imageOrder;

    @ColumnInfo(name = "location")
    private String imageLocation;

    public int getImageId() {
        return imageId;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public int getImageOrder() {
        return imageOrder;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public void setImageOrder(int imageOrder) {
        this.imageOrder = imageOrder;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }
}
