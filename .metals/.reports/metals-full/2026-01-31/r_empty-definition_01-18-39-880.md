error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/ActivityCommand.java:java/lang/String#
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/ActivityCommand.java
empty definition using pc, found symbol in pc: java/lang/String#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 556
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/ActivityCommand.java
text:
```scala
package com.zwinslett.strava;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "activity", description = "Display a single Strava activity")

public class ActivityCommand implements Runnable {

    @Parameters(index = "0", description = "The ID of the activity to display")
    private long activityId;

    @Override
    public void run() {
        StravaActivityRequest stravaRequest = new StravaActivityRequest();
        try {
            String accessToken = stravaRequest.getAccessToken();
            Stri@@ng activityData = stravaRequest.getActivity(activityId, accessToken);
            System.out.println("Activity Data: " + activityData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        // <-- Add this for Maven/Picocli argument parsing
    public static void main(String[] args) {
        int exitCode = new picocli.CommandLine(new ActivityCommand()).execute(args);
        System.exit(exitCode);
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: java/lang/String#