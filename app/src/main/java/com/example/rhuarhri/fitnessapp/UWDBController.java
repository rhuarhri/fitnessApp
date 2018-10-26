package com.example.rhuarhri.fitnessapp;

import android.arch.persistence.room.Room;
import android.content.Context;

public class UWDBController {

    /*This is the user weight data base controller class
       The user will only be able to save their weight.
       This class is used to determine where that weight information
       should be store.
     */

    UserWeightDB db;

    UWDBController(Context context)
    {
        db = Room.databaseBuilder(context, UserWeightDB.class, "").build();
    }

    public void addWeight(double Weight)
    {
        //Step 1 check if table empty
        if (IsDatabaseEmpty() == true)
        {
            //Step 2 add first weight measurement
            AddFirstWeight(Weight);
        }else
        {
            //Step 3 add second weight measurement (if there is a second weight measurement update it)
            AddSecondWeight(Weight);
        }

    }

    boolean IsDatabaseEmpty()
    {
        /*selects all rows in the table and returns list
        if list empty table is empty
         */
       return db.UserWeightBDInterface().getAll().isEmpty();
    }

    void AddFirstWeight(double Weight)
    {
        UserWeight firstWeight = new UserWeight();
        firstWeight.setPastWeight(Weight);
        firstWeight.setCurrentWeight(Weight);

        db.UserWeightBDInterface().newWeightRow(firstWeight);
    }

    void AddSecondWeight(double Weight)
    {
        db.UserWeightBDInterface().updateCurrentWeight(Weight);
    }


}
