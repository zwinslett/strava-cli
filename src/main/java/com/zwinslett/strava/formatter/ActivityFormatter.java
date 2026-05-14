package com.zwinslett.strava.formatter;

import com.zwinslett.strava.model.Activity;
import com.zwinslett.strava.model.DetailedActivity;
import com.zwinslett.strava.model.Stats;

public class ActivityFormatter {

  public static String baseFormat(Activity activity, Stats stat) {
    double distance = stat.getTotalMiles();
    double minutes = stat.getTotalMinutes();
    String name = activity.getName();
    return String.format("Name: %s | Distance: %.2f | Minutes: %.2f", name, distance, minutes);
  }

  public static String formatDetailedActivity(DetailedActivity activity, Stats stat) {
    String gearName = activity.getGearName();
    return baseFormat(activity, stat) + " | Gear: " + gearName;
  }

  public static String formatActivity(Activity activity, Stats stat) {
    long id = activity.getId();
    return baseFormat(activity, stat) + " | ID: " + id;
  }

  public static String formatActivities(Stats stat) {
    int totalActivities = stat.getTotalActivities();
    double distance = stat.getTotalMiles();
    double minutes = stat.getTotalMinutes();
    return String.format("Total Activities: %d | Distance: %.2f | Total Minutes: %.2f", totalActivities, distance,
        minutes);
  }

  public static String formatActivitiesTableHeader() {
    String header = String.format("%-50s %-10s %-10s %-10s%n", "Name", "Distance", "Minutes", "ID");
    String divider = "-----------------------------------------------------------------------------------";
    return header + divider;

  }

  public static String formatActivitiesTableRows(Activity activity, Stats stat) {
    return String.format("%-50s %-10.2f %-10.2f %-10d", activity.getName(), stat.getTotalMiles(), stat.getTotalMinutes(),
        activity.getId());
  }
}
