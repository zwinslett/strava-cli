error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StatsWeeklyCommand.java:java/io/PrintStream#println(+8).
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StatsWeeklyCommand.java
empty definition using pc, found symbol in pc: java/io/PrintStream#println(+8).
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 929
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StatsWeeklyCommand.java
text:
```scala
package com.zwinslett.strava;

import java.time.Instant;
import java.util.List;

import picocli.CommandLine.Command;
@Command(
    name = "weekly",
    description = "Show stats for the last 7 days"
)
public class StatsWeeklyCommand implements Runnable {
        @Override
        public void run() {
            long epochNow = Instant.now().getEpochSecond();
            long sevenDaysAgo = epochNow - 604800;
            StravaAPIClient stravaRequest = new StravaAPIClient();
            try {
                String accessToken = stravaRequest.getAccessToken();
                List<Activity> recentActivityData = stravaRequest.getRangeActivities(accessToken, epochNow, sevenDaysAgo);
                ActivityStats stats = new ActivityStats();
                double totalMiles = stats.totalMiles(recentActivityData);
                double totalMinutes = stats.totalMinutes(recentActivityData);
                System.out.pr@@intln("Total Miles: " + totalMiles + "m" + " | Total Minutes: " + totalMinutes + "min");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
```


#### Short summary: 

empty definition using pc, found symbol in pc: java/io/PrintStream#println(+8).