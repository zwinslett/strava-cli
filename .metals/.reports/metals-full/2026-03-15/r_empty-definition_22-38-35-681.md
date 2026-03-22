error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/cli/ActivityByIdCommand.java:com/zwinslett/strava/services/ActivityCalculator#
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/cli/ActivityByIdCommand.java
empty definition using pc, found symbol in pc: com/zwinslett/strava/services/ActivityCalculator#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 275
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/cli/ActivityByIdCommand.java
text:
```scala
package com.zwinslett.strava.cli;

import com.zwinslett.strava.api.StravaAPIClient;
import com.zwinslett.strava.dtos.Activity;
import com.zwinslett.strava.dtos.Stats;
import com.zwinslett.strava.formatters.ActivityFormatter;
import com.zwinslett.strava.services.ActivityCalcu@@lator;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "activity", description = "Display a single Strava activity for a given activity ID")

public class ActivityByIdCommand implements Runnable {

    @Parameters(index = "0", description = "The ID of the activity to display")
    private long activityId;
    
    private final StravaAPIClient stravaRequest;
    private final ActivityCalculator calculator;

    public ActivityByIdCommand() {
        this.stravaRequest = new StravaAPIClient();
        this.calculator = new ActivityCalculator();
    }

    @Override
    public void run() {
        try {
            String accessToken = stravaRequest.getAccessToken();
            Activity activity = stravaRequest.getActivityById(activityId, accessToken);
            Stats activityData = calculator.calculateStat(activity);
            System.out.println(ActivityFormatter.formatActivity(activity, activityData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        int exitCode = new picocli.CommandLine(new ActivityByIdCommand()).execute(args);
        System.exit(exitCode);
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: com/zwinslett/strava/services/ActivityCalculator#