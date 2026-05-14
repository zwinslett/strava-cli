package com.zwinslett.strava.cli;

import java.util.List;

import com.zwinslett.strava.formatter.ActivityFormatter;
import com.zwinslett.strava.model.Activity;
import com.zwinslett.strava.model.Stats;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "recent", description = "Display the most recent Strava activites up to 10")
public class RecentCommand extends BaseCommand implements Runnable {
    @Parameters(index = "0", description = "The number of recent activities to display (default: 1, max: 10)", arity = "0..1")
    private int numActivities = 1;

    @Override
    public void run() {
        if (this.numActivities < 1 || this.numActivities > 10) {
            System.err.println("Error: numActivities must be between 1 and 10");
            System.exit(2);
        }
        try {
            List<Activity> recentActivityData = stravaRequest.getRecentActivities(this.numActivities);
            System.out.println(ActivityFormatter.formatActivitiesTableHeader());
            for (Activity a : recentActivityData) {
                Stats stat = calculator.calculateStat(a);
                System.out.println(ActivityFormatter.formatActivitiesTableRows(a, stat));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
