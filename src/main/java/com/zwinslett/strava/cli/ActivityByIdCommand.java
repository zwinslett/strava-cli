package com.zwinslett.strava.cli;

import com.zwinslett.strava.formatter.ActivityFormatter;
import com.zwinslett.strava.model.DetailedActivity;
import com.zwinslett.strava.model.Stats;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "activity", description = "Display a single Strava activity for a given activity ID")

public class ActivityByIdCommand extends BaseCommand implements Runnable {

    @Parameters(index = "0", description = "The ID of the activity to display")
    private long activityId;

    @Override
    public void run() {
        try {
            DetailedActivity activity = stravaRequest.getActivityById(activityId);
            Stats activityData = calculator.calculateStat(activity);
            System.out.println(ActivityFormatter.formatDetailedActivity(activity, activityData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}