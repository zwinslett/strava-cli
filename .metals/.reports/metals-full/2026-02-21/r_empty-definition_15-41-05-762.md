error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StatsCommand.java:java/time/LocalDate#today#
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StatsCommand.java
empty definition using pc, found symbol in pc: java/time/LocalDate#today#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 659
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StatsCommand.java
text:
```scala
package com.zwinslett.strava;

import java.util.List;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;

@Command(name = "stats", description = "Display stats about a range of activities")
public class StatsCommand implements Runnable {
    @Parameters(index = "0", description = "The time range of activities to calculate stats for (e.g., 'week', 'month', 'year')", arity = "0...1")
    private String timeRange;

    @Override
    public void run() {
        long epochNow = Instant.now().getEpochSecond();
        long startOfWeek = LocalDate.toda@@y.with(DayOfWeek.MONDAY).getEpochSecond();
        StravaAPIClient stravaRequest = new StravaAPIClient();
        try {
            String accessToken = stravaRequest.getAccessToken();
            List<Activity> recentActivityData = stravaRequest.getRangeActivities(accessToken, epochNow, startOfWeek);
            ActivityStats stats = new ActivityStats();
            double totalMiles = stats.totalMiles(recentActivityData);
            double totalMinutes = stats.totalMinutes(recentActivityData);
            System.out.println("Total Miles: " + totalMiles + "m" + " | Total Minutes: " + totalMinutes + "min");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: java/time/LocalDate#today#