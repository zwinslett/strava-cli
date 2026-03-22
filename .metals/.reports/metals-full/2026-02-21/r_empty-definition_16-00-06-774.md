error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StatsCommand.java:java/lang/Runnable#
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StatsCommand.java
empty definition using pc, found symbol in pc: java/lang/Runnable#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 330
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StatsCommand.java
text:
```scala
package com.zwinslett.strava;

import java.util.List;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.time.Instant;

@Command(name = "stats", description = "Display stats about a range of activities", subcommands = {
        StatsWeeklyCommand.class})
public class StatsCommand implements @@Runnable {
    @Override
    public void run() {
        System.out.println("Please specify either a weekly or monthly time range.");
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: java/lang/Runnable#