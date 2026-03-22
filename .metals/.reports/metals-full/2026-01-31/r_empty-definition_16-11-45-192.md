error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/RecentCommand.java:_empty_/Command#description#
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/RecentCommand.java
empty definition using pc, found symbol in pc: _empty_/Command#description#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 93
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/RecentCommand.java
text:
```scala
package com.zwinslett.strava;
import picocli.CommandLine.Command;

@Command(name = "recent", @@description = "Display the most recent Strava activity")

public class RecentCommand implements Runnable {
    @Override
    public void run() {
        StravaActivityRequest stravaRequest = new StravaActivityRequest();
        try {
            String accessToken = stravaRequest.getAccessToken();
            String recentActivityData = stravaRequest.getMostRecentActivity(accessToken);
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

empty definition using pc, found symbol in pc: _empty_/Command#description#