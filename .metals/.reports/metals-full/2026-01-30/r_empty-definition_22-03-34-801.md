error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StravaCli.java:java/io/PrintStream#println(+8).
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StravaCli.java
empty definition using pc, found symbol in pc: java/io/PrintStream#println(+8).
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 391
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StravaCli.java
text:
```scala
package com.zwinslett.strava;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(
    name = "strava",
    mixinStandardHelpOptions = true,
    description = "A command line interface for Strava API",
    subcommands = {
        ActivityCommand.class,
    }
)
public class StravaCli implements Runnable {
    @Override
    public void run() {
        System.out.printl@@n("Use a subcommand");
    }

    public static void main(String[] args){
        int exitCode = new CommandLine(new StravaCli()).execute(args);
        System.exit(exitCode);
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: java/io/PrintStream#println(+8).