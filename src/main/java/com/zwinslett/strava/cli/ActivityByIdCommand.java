package com.zwinslett.strava.cli;

import com.zwinslett.strava.formatter.ActivityFormatter;
import com.zwinslett.strava.model.Activity;
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
            String accessToken = stravaRequest.getAccessToken();
            Activity activity = stravaRequest.getActivityById(activityId, accessToken);
            Stats activityData = calculator.calculateStat(activity);
            System.out.println(ActivityFormatter.formatActivity(activity, activityData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int exitCode = new picocli.CommandLine(new ActivityByIdCommand()).execute(args);
        System.exit(exitCode);
    }
}