error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/cli/StatsCommand.java:_empty_/BaseCommand#
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/cli/StatsCommand.java
empty definition using pc, found symbol in pc: _empty_/BaseCommand#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 249
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/cli/StatsCommand.java
text:
```scala
package com.zwinslett.strava.cli;

import picocli.CommandLine.Command;

@Command(name = "stats", description = "Display stats about a range of activities", subcommands = {
        StatsWeeklyCommand.class })
public class StatsCommand extends BaseCom@@mand implements Runnable {
    @Override
    public void run() {
        System.out.println("Please specify either a weekly or monthly time range.");
    }

    public static void main(String[] args) {
        int exitCode = new picocli.CommandLine(new StatsCommand()).execute(args);
        System.exit(exitCode);
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/BaseCommand#