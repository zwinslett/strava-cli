error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StatsCommand.java:_empty_/ActivityStats#
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StatsCommand.java
empty definition using pc, found symbol in pc: _empty_/ActivityStats#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 1041
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StatsCommand.java
text:
```scala
package com.zwinslett.strava;

import java.util.List;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.time.Instant;

@Command(name = "stats", description = "Display stats about a range of activities", subcommands = {
        StatsWeeklyCommand.class, StatsMonthlyCommand.class })
public class StatsCommand implements Runnable {
    @Override
    public void run() {
        System.out.println("Please specify either a weekly or monthly time range.");
    }

    public class StatsWeeklyCommand implements Runnable {
        @Override
        public void run() {
            long epochNow = Instant.now().getEpochSecond();
            long sevenDaysAgo = epochNow - 604800;
            StravaAPIClient stravaRequest = new StravaAPIClient();
            try {
                String accessToken = stravaRequest.getAccessToken();
                List<Activity> recentActivityData = stravaRequest.getRangeActivities(accessToken, epochNow, sevenDaysAgo);
                ActivityStats stats = new Activity@@Stats();
                double totalMiles = stats.totalMiles(recentActivityData);
                double totalMinutes = stats.totalMinutes(recentActivityData);
                System.out.println("Total Miles: " + totalMiles + "m" + " | Total Minutes: " + totalMinutes + "min");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/ActivityStats#