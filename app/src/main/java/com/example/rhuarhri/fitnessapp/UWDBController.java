package com.example.rhuarhri.fitnessapp;

import android.arch.persistence.room.Room;
import android.content.Context;

public class UWDBController {

    /*This is the user weight data base controller class
       The user will only be able to save their weight.
       This class is used to determine where that weight information
       should be store.
     */

    private UserWeightDB db;

    UWDBController(Context context)
    {
        db = Room.databaseBuilder(context, UserWeightDB.class, "weightDB").build();
    }

    public void addWeight(double Weight)
    {
        //Step 1 check if table empty
        if (IsTableEmpty() == true)
        {
            //Step 2 add first weight measurement
            AddFirstWeight(Weight);
        }else
        {
            //Step 3 add second weight measurement (if there is a second weight measurement update it)
            AddSecondWeight(Weight);
        }

    }

    private boolean IsTableEmpty()
    {
        /*counts all fo the rows on the table
         */

        if (db.UserWeightDBInterface().getSizeOfTable() <= 0)
        {
            //nothing in data base
            return true;
        }
        else
        {
            return false;
        }


    }

    private void AddFirstWeight(double Weight)
    {
        UserWeight firstWeight = new UserWeight();
        firstWeight.setPastWeight(Weight);
        firstWeight.setCurrentWeight(Weight);

        db.UserWeightDBInterface().newWeightRow(firstWeight);
    }

    private void AddSecondWeight(double Weight)
    {
        db.UserWeightDBInterface().updateCurrentWeight(Weight);
    }


}
