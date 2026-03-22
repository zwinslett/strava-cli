error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/cli/RecentCommand.java:picocli/CommandLine/Parameters#
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/cli/RecentCommand.java
empty definition using pc, found symbol in pc: picocli/CommandLine/Parameters#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 373
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/cli/RecentCommand.java
text:
```scala
package com.zwinslett.strava.cli;

import java.util.List;

import com.zwinslett.strava.api.StravaAPIClient;
import com.zwinslett.strava.formatter.ActivityFormatter;
import com.zwinslett.strava.model.Activity;
import com.zwinslett.strava.model.Stats;
import com.zwinslett.strava.service.ActivityCalculator;

import picocli.CommandLine.Command;
import picocli.CommandLine.Par@@ameters;

@Command(name = "recent", description = "Display the most recent Strava activites up to 10")
public class RecentCommand implements Runnable {
    @Parameters(index = "0", description = "The number of recent activities to display (default: 1, max: 10)", arity = "0..1")
    private int numActivities = 1;

    private final StravaAPIClient stravaRequest;
    private final ActivityCalculator calculator;
    public RecentCommand(){
        this.stravaRequest = new StravaAPIClient();
        this.calculator = new ActivityCalculator();
    }

    @Override
    public void run() {
        if (this.numActivities < 1 || this.numActivities > 10) {
            System.err.println("Error: numActivities must be between 1 and 10");
            System.exit(2);
        }
        try {
            String accessToken = stravaRequest.getAccessToken();
            List<Activity> recentActivityData = stravaRequest.getRecentActivities(accessToken, this.numActivities);
            for(Activity a: recentActivityData){
                Stats stat = calculator.calculateStat(a);
                System.out.println(ActivityFormatter.formatActivity(a, stat));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int exitCode = new picocli.CommandLine(new RecentCommand()).execute(args);
        System.exit(exitCode);
    }

}

```


#### Short summary: 

empty definition using pc, found symbol in pc: picocli/CommandLine/Parameters#