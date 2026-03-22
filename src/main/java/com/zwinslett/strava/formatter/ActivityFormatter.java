package com.zwinslett.strava.formatter;

import com.zwinslett.strava.model.Activity;
import com.zwinslett.strava.model.Stats;

public class ActivityFormatter {
  public static String formatActivity(Activity activity,Stats stat) {
    double distance = stat.getTotalMiles();
    double minutes = stat.getTotalMinutes();
    String name = activity.getName();
    return String.format("Name: %s | Distance: %.2f | Minutes: %.2f", name, distance, minutes);
  }

  public static String formatActivities(Stats stat) {
    int totalActivities = stat.getTotalActivities();
    double distance = stat.getTotalMiles();
    double minutes = stat.getTotalMinutes();
    return String.format("Total Activities: %d | Distance: %.2f | Total Minutes: %.2f", totalActivities, distance,
        minutes);
  }
}
