error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/ActivityCommand.java:_empty_/StravaActivityRequest#
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/ActivityCommand.java
empty definition using pc, found symbol in pc: _empty_/StravaActivityRequest#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 523
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
         System.out.println("Parsed activityId: " + activityId); // <-- debug
        StravaActivityRequest stravaRequest = new StravaAct@@ivityRequest();
        try {
            String accessToken = stravaRequest.getAccessToken();
            String activityData = stravaRequest.getActivity(activityId, accessToken);
            System.out.println("Activity Data: " + activityData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/StravaActivityRequest#