package com.zwinslett.strava.cli;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "strava", mixinStandardHelpOptions = true, description = "A command line interface for the Strava API", subcommands = {
        ActivityByIdCommand.class,
        RecentCommand.class,
        StatsCommand.class,
        SplitsByIdCommand.class,
        ZonesByActivityCommand.class
})
public class StravaCli implements Runnable {
    @Override
    public void run() {
        System.out.println("Use a subcommand");
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new StravaCli()).execute(args);
        System.exit(exitCode);
    }
}
