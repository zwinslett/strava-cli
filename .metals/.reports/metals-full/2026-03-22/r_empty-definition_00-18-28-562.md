error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/cli/BaseCommand.java:com/zwinslett/strava/service/ActivityCalculator#
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/cli/BaseCommand.java
empty definition using pc, found symbol in pc: com/zwinslett/strava/service/ActivityCalculator#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 132
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/cli/BaseCommand.java
text:
```scala
package com.zwinslett.strava.cli;
import com.zwinslett.strava.api.StravaAPIClient;
import com.zwinslett.strava.service.ActivityCalcu@@lator;

public class BaseCommand {
    public final StravaAPIClient stravaRequest;
    public final ActivityCalculator calculator;
    public BaseCommand() {
        this.stravaRequest = new StravaAPIClient();
        this.calculator = new ActivityCalculator();
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: com/zwinslett/strava/service/ActivityCalculator#