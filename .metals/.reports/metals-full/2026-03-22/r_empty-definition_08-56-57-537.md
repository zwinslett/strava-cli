error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/cli/StatsMonthlyCommand.java:java/time/Instant#getEpochSecond().
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/cli/StatsMonthlyCommand.java
empty definition using pc, found symbol in pc: java/time/Instant#getEpochSecond().
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 503
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
public class StatsMonthlyCommand extends BaseCommand implements Runnable {

    @Override
    public void run() {
        long epochNow = Instant.now().getEpochSec@@ond();
        long thirtyDaysAgo = epochNow - 26280000;
        System.out.println(thirtyDaysAgo);
        try {
            String accessToken = stravaRequest.getAccessToken();
            List<Activity> recentActivityData = stravaRequest.getRangeActivities(accessToken, epochNow, thirtyDaysAgo);
            Stats stats = calculator.calculateStats(recentActivityData);
            System.out.println("In the last 30 days ... \n" + ActivityFormatter.formatActivities(stats));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: java/time/Instant#getEpochSecond().