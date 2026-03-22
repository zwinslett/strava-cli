package com.zwinslett.strava.service;

import java.util.List;

import com.zwinslett.strava.model.Activity;
import com.zwinslett.strava.model.Stats;

public class ActivityCalculator {
  public double miles(Activity activity) {
    return activity.getDistance() * 0.000621371;
  }

  public double totalMiles(List<Activity> activities) {
    double totalMiles = 0.0;
    for (Activity activity : activities) {
      totalMiles += miles(activity);
    }
    return totalMiles;
  }

  public double minutes(Activity activity) {
    return activity.getMoving_time() / 60.0;
  }

  public double totalMinutes(List<Activity> activities) {
    double totalMinutes = 0.0;
    for (Activity activity : activities) {
      totalMinutes += minutes(activity);
    }
    return totalMinutes;
  }

  public int totalActivities(List<Activity> activities) {
    return activities.size();
  }

  public Stats calculateStats(List<Activity> activities) {
    int totalActivities = totalActivities(activities);
    double totalMiles = totalMiles(activities);
    double totalMinutes = totalMinutes(activities);
    return new Stats(totalActivities, totalMiles, totalMinutes);
  }

  public Stats calculateStat(Activity activity){
    int totalActivities = 1;
    double totalMiles = miles(activity);
    double totalMinutes = minutes(activity);
    return new Stats(totalActivities, totalMiles, totalMinutes);
  }

}
