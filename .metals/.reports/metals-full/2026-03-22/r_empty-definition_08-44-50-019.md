error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/cli/StatsMonthlyCommand.java:
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/cli/StatsMonthlyCommand.java
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 392
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/cli/StatsMonthlyCommand.java
text:
```scala
package com.zwinslett.strava.cli;

import java.time.Instant;
import java.util.List;
import com.zwinslett.strava.formatter.ActivityFormatter;
import com.zwinslett.strava.model.Activity;
import com.zwinslett.strava.model.Stats;

import picocli.CommandLine.Command;

@Command(name = "monthly", description = "Show stats for the last 30 days")
public class StatsMonthlyCommand extends BaseCommand@@ implements Runnable {

    @Override
    public void run() {
        long epochNow = Instant.now().getEpochSecond();
        long sevenDaysAgo = epochNow - 604800;
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

empty definition using pc, found symbol in pc: 