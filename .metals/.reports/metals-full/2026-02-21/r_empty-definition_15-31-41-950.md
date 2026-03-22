error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StatsCommand.java:_empty_/StravaAPIClient#
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StatsCommand.java
empty definition using pc, found symbol in pc: _empty_/StravaAPIClient#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 576
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StatsCommand.java
text:
```scala
package com.zwinslett.strava;

import java.util.List;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import java.time.Instant;

@Command(name = "stats", description = "Display stats about a range of activities")
public class StatsCommand implements Runnable {
    @Parameters(index = "0", description = "The time range of activities to calculate stats for (e.g., 'week', 'month', 'year')", arity = "0...1")
    private String timeRange;

    @Override
    public void run() {
        int epochNow = Instant.now().getEpochSecond();
        StravaAP@@IClient stravaRequest = new StravaAPIClient();
        try {
            String accessToken = stravaRequest.getAccessToken();
            List<Activity> recentActivityData = stravaRequest.getRangeActivities(accessToken, epochNow, 1771276624);
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

empty definition using pc, found symbol in pc: _empty_/StravaAPIClient#