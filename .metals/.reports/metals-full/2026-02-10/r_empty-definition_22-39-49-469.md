error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/RecentCommand.java:_empty_/Parameters#
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/RecentCommand.java
empty definition using pc, found symbol in pc: _empty_/Parameters#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 289
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/RecentCommand.java
text:
```scala
package com.zwinslett.strava;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Range;

@Command(name = "recent", description = "Display the most recent Strava activity")

public class RecentCommand implements Runnable {
        @Paramet@@ers(index = "0", description = "The number of recent activities to display (default: 1, max: 10)", arity = "0..1")
        @Range(min = 1, max = 10)
        private int numActivities = 1;
    @Override
    public void run() {
        StravaActivityRequest stravaRequest = new StravaActivityRequest();
        try {
            String accessToken = stravaRequest.getAccessToken();
            String recentActivityData = stravaRequest.getRecentActivities(accessToken, this.numActivities);
            System.out.println(JsonFormatter.formatJson(recentActivityData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        // <-- Add this for Maven/Picocli argument parsing
    public static void main(String[] args) {
        int exitCode = new picocli.CommandLine(new RecentCommand()).execute(args);
        System.exit(exitCode);
    }

}

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/Parameters#