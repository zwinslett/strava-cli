error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/cli/BaseCommand.java:com/zwinslett/strava/api/StravaAPIClient#
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/cli/BaseCommand.java
empty definition using pc, found symbol in pc: com/zwinslett/strava/api/StravaAPIClient#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 77
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/cli/BaseCommand.java
text:
```scala
package com.zwinslett.strava.cli;
import com.zwinslett.strava.api.StravaAPICl@@ient;
import com.zwinslett.strava.service.ActivityCalculator;

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

empty definition using pc, found symbol in pc: com/zwinslett/strava/api/StravaAPIClient#