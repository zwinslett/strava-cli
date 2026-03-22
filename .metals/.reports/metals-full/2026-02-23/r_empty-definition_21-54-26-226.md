error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/ActivityFormatter.java:_empty_/Activity#getName#
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/ActivityFormatter.java
empty definition using pc, found symbol in pc: _empty_/Activity#getName#
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -activity/getName.
	 -activity/getName#
	 -activity/getName().
	 -scala/Predef.activity.getName.
	 -scala/Predef.activity.getName#
	 -scala/Predef.activity.getName().
offset: 218
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/ActivityFormatter.java
text:
```scala
package com.zwinslett.strava;

import java.util.List;

class ActivityFormatter {
  public static String formatActivity(Activity activity) {
    return String.format("Activity: %s | Distance: %.2f | Type: %s", activity.@@getName(), activity.getDistance() * 0.000621371, activity.getType());
  }
  public static String formatActivities(List<Activity> activities){
    ActivityStats stats = new ActivityStats();
    double distance = stats.totalMiles(activities);
    double minutes = stats.totalMinutes(activities);
    int totalActivities = stats.totalActivities(activities);
    return String.format("Total Activities: %d | Distance: %.2f | Total Minutes: %.2f", totalActivities, distance, minutes);
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/Activity#getName#