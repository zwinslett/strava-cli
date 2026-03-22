error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StatsWeeklyCommand.java:
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StatsWeeklyCommand.java
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 737
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StatsWeeklyCommand.java
text:
```scala
package com.zwinslett.strava;

import java.time.Instant;
import java.util.List;

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
                double totalMinutes@@ = stats.totalMinutes(recentActivityData);
                System.out.println("Total Miles: " + totalMiles + "m" + " | Total Minutes: " + totalMinutes + "min");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
```


#### Short summary: 

empty definition using pc, found symbol in pc: 