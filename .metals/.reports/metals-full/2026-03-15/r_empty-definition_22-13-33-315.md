error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/ActivityCommand.java:java/io/PrintStream#println(+7).
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/ActivityCommand.java
empty definition using pc, found symbol in pc: java/io/PrintStream#println(+7).
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 914
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/ActivityCommand.java
text:
```scala
package com.zwinslett.strava;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "activity", description = "Display a single Strava activity for a given activity ID")

public class ActivityCommand implements Runnable {

    @Parameters(index = "0", description = "The ID of the activity to display")
    private long activityId;
    
    private final StravaAPIClient stravaRequest;
    private final ActivityCalculator calculator;

    public ActivityCommand() {
        this.stravaRequest = new StravaAPIClient();
        this.calculator = new ActivityCalculator();
    }

    @Override
    public void run() {
        try {
            String accessToken = stravaRequest.getAccessToken();
            Activity activity = stravaRequest.getActivityById(activityId, accessToken);
            Stats activityData = calculator.calculateStat(activity)
            System.out.p@@rintln(ActivityFormatter.formatActivity(activityData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        int exitCode = new picocli.CommandLine(new ActivityCommand()).execute(args);
        System.exit(exitCode);
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: java/io/PrintStream#println(+7).