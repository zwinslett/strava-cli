error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StatsCommand.java:_empty_/Command#description#
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StatsCommand.java
empty definition using pc, found symbol in pc: _empty_/Command#description#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 191
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StatsCommand.java
text:
```scala
package com.zwinslett.strava;

import java.util.List;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.time.Instant;

@Command(name = "stats", descript@@ion = "Display stats about a range of activities", subcommands = {
        StatsWeeklyCommand.class})
public class StatsCommand implements Runnable {
    @Override
    public void run() {
        System.out.println("Please specify either a weekly or monthly time range.");
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/Command#description#