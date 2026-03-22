error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/cli/RecentCommand.java:java/io/PrintStream#println(+8).
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/cli/RecentCommand.java
empty definition using pc, found symbol in pc: java/io/PrintStream#println(+8).
found definition using semanticdb; symbol local1
empty definition using fallback
non-local guesses:

offset: 1056
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/cli/RecentCommand.java
text:
```scala
package com.zwinslett.strava.cli;

import java.util.List;

import com.zwinslett.strava.api.StravaAPIClient;
import com.zwinslett.strava.dtos.Activity;
import com.zwinslett.strava.dtos.Stats;
import com.zwinslett.strava.formatters.ActivityFormatter;
import com.zwinslett.strava.services.ActivityCalculator;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

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
            System.err.print@@ln("Error: numActivities must be between 1 and 10");
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

empty definition using pc, found symbol in pc: java/io/PrintStream#println(+8).