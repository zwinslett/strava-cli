error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/RecentCommand.java:_empty_/ActivityFormatter#formatActivity#
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/RecentCommand.java
empty definition using pc, found symbol in pc: _empty_/ActivityFormatter#formatActivity#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 1034
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/RecentCommand.java
text:
```scala
package com.zwinslett.strava;

import java.util.List;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "recent", description = "Display the most recent Strava activites up to 10")
public class RecentCommand implements Runnable {
    @Parameters(index = "0", description = "The number of recent activities to display (default: 1, max: 10)", arity = "0..1")
    private int numActivities = 1;

    @Override
    public void run() {
        if (this.numActivities < 1 || this.numActivities > 10) {
            System.err.println("Error: numActivities must be between 1 and 10");
            System.exit(2);
        }
        StravaAPIClient stravaRequest = new StravaAPIClient();
        try {
            String accessToken = stravaRequest.getAccessToken();
            List<Activity> recentActivityData = stravaRequest.getRecentActivities(accessToken, this.numActivities);
            for (Activity a : recentActivityData) {
                System.out.println(ActivityFormatter.formatActivit@@y(a));
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

empty definition using pc, found symbol in pc: _empty_/ActivityFormatter#formatActivity#