error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StravaCli.java:java/lang/Runnable#
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StravaCli.java
empty definition using pc, found symbol in pc: java/lang/Runnable#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 332
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StravaCli.java
text:
```scala
package com.zwinslett.strava;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "strava", mixinStandardHelpOptions = true, description = "A command line interface for the Strava API", subcommands = {
        ActivityCommand.class,
        RecentCommand.class
    })
public class StravaCli implements @@Runnable {
    @Override
    public void run() {
        System.out.println("Use a subcommand");
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new StravaCli()).execute(args);
        System.exit(exitCode);
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: java/lang/Runnable#