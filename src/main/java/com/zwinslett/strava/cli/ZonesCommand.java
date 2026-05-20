package com.zwinslett.strava.cli;

import picocli.CommandLine.Command;

@Command(name = "zones", description = "Display zones about a single activity or range of activities.", subcommands = {
    ZonesByActivityCommand.class,
    ZonesWeekly.class,
    ZonesMonthly.class
})
public class ZonesCommand implements Runnable {
  @Override
  public void run() {
    System.out.println("Please specify an id, weekly, or monthly.");
  }
}
