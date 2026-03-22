error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/cli/StatsWeeklyCommand.java:java/lang/Runnable#
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/cli/StatsWeeklyCommand.java
empty definition using pc, found symbol in pc: java/lang/Runnable#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 443
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/cli/StatsWeeklyCommand.java
text:
```scala
package com.zwinslett.strava.cli;

import java.time.Instant;
import java.util.List;
import com.zwinslett.strava.formatter.ActivityFormatter;
import com.zwinslett.strava.model.Activity;
import com.zwinslett.strava.model.Stats;
import java.time.temporal.ChronoUnit;

import picocli.CommandLine.Command;

@Command(name = "weekly", description = "Show stats for the last 7 days")
public class StatsWeeklyCommand extends BaseCommand implements Runn@@able {

    @Override
    public void run() {
        long epochNow = Instant.now().getEpochSecond();
        long sevenDaysAgo = Instant.now().minus(7, ChronoUnit.DAYS).getEpochSecond();
        try {
            String accessToken = stravaRequest.getAccessToken();
            List<Activity> recentActivityData = stravaRequest.getRangeActivities(accessToken, epochNow, sevenDaysAgo);
            Stats stats = calculator.calculateStats(recentActivityData);
            System.out.println("In the last seven days ... \n" + ActivityFormatter.formatActivities(stats));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: java/lang/Runnable#