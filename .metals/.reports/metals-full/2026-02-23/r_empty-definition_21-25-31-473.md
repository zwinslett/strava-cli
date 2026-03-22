error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/ActivityStats.java:java/util/List#
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/ActivityStats.java
empty definition using pc, found symbol in pc: java/util/List#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 417
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/ActivityStats.java
text:
```scala
package com.zwinslett.strava;

import java.util.List;

class ActivityStats {
  public double totalMiles(List<Activity> activities){
    double totalMeters = 0.0;
    double totalMetersToMiles = 0.0;
    for (Activity activity : activities){
        totalMeters = totalMeters + activity.getDistance();
        totalMetersToMiles = totalMeters;
    }
    return totalMetersToMiles;
  }
  public double totalMinutes(List@@<Activity> activities){
    int totalSeconds = 0;
    double totalSecondsToMinutes = 0.0;
    for (Activity activity : activities){
      totalSeconds = totalSeconds + activity.getMoving_time();
      totalSecondsToMinutes = totalSeconds / 60.0;
    }
    return totalSecondsToMinutes;
  }
  public int totalActivities(List<Activity> activities){
    return activities.size();
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: java/util/List#