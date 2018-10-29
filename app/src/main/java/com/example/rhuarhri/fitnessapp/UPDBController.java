package com.example.rhuarhri.fitnessapp;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.provider.ContactsContract;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UPDBController {

    /*There should be only two public functions
    one that returns an array with the calculated progress
    expressed in colours
    i.e.
    red for bad
    amber for intermediate
    green for good

    The other is used to update the progress information
     */

    private UserProgressDB db;

    UPDBController(Context context)
    {
        db = Room.databaseBuilder(context, UserProgressDB.class, "UserProgressDB").build();

        if (IsTableEmpty() == true)
        {
            Date defaultDate  = Calendar.getInstance().getTime();

            UserProgress defaultUP = new UserProgress();
            defaultUP.setType("overall");
            defaultUP.setLegs(0);
            defaultUP.setArms(0);
            defaultUP.setChest(0);
            defaultUP.setRecordDate(defaultDate);

            db.UserProgressDBInterface().setUp(defaultUP);
            defaultUP.setType("today");
            db.UserProgressDBInterface().setUp(defaultUP);
        }
        else
        {

        }
    }

    private boolean IsTableEmpty()
    {
        /*counts all fo the rows on the table
         */

        if (db.UserProgressDBInterface().getSizeOfTable() <= 0)
        {
            //nothing in data base
            return true;
        }
        else
        {
            return false;
        }


    }




    public String[] getProgress(String Type)
    {

        String[] progress;
        UserProgress savedProgress;

        if (Type == "overall")
        {


            savedProgress = db.UserProgressDBInterface().getOverall();

            Date savedDate = savedProgress.getRecordDate();
            Date currentDate = Calendar.getInstance().getTime();

            long dateDifference = currentDate.getTime() - savedDate.getTime();

            long days = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);

            String legsEffort = progressLevel(savedProgress.getLegs(), days);
            String armsEffort = progressLevel(savedProgress.getArms(), days);
            String chestEffort = progressLevel(savedProgress.getChest(), days);

            progress = new String[] {legsEffort, armsEffort, chestEffort};
        }
        else{

            savedProgress = db.UserProgressDBInterface().getToday();

            String legsEffort = progressLevel(savedProgress.getLegs(), 1);
            String armsEffort = progressLevel(savedProgress.getArms(), 1);
            String chestEffort = progressLevel(savedProgress.getChest(), 1);

            progress = new String[] {legsEffort, armsEffort, chestEffort};
        }

        return progress;
    }

    private String progressLevel(int effort, long days)
    {

        long desiredValue = days * 10; //This is the desired amount of exercise that a user should do

        if (effort >= desiredValue )
        {
            return "green";
        }
        else if (effort >= (desiredValue / 2) && effort < desiredValue)
        {
            return "amber";
        }
        else if(effort < (desiredValue /2))
        {
            return "red";
        }
        else
        {
            return "error";
        }
    }

    public void UpdateProgress(int legs, int arms, int chest)
    {
        //This should only run after the user has completed their exercise routine

        UserProgress newInfo = new UserProgress();

        //update today's progress
        newInfo.setType("today");
        newInfo.setLegs(legs);
        newInfo.setArms(arms);
        newInfo.setChest(chest);
        db.UserProgressDBInterface().update(newInfo);

        //update overall progress
        UserProgress savedData = db.UserProgressDBInterface().getOverall();

        newInfo.setType(savedData.getType());
        newInfo.setLegs(savedData.getLegs() + legs);
        newInfo.setArms(savedData.getArms() + arms);
        newInfo.setChest(savedData.getChest() + chest);
        newInfo.setRecordDate(savedData.getRecordDate());

        db.UserProgressDBInterface().update(newInfo);

    }

}
