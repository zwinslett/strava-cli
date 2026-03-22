package com.zwinslett.strava.cli;

import picocli.CommandLine.Command;

@Command(name = "stats", description = "Display stats about a range of activities", subcommands = {
        StatsWeeklyCommand.class, StatsMonthlyCommand.class })
public class StatsCommand implements Runnable {
    @Override
    public void run() {
        System.out.println("Please specify either a weekly or monthly time range.");
    }

    public static void main(String[] args) {
        int exitCode = new picocli.CommandLine(new StatsCommand()).execute(args);
        System.exit(exitCode);
    }
}
