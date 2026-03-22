error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/ActivityCalculator.java:java/util/List#
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/ActivityCalculator.java
empty definition using pc, found symbol in pc: java/util/List#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 360
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/ActivityCalculator.java
text:
```scala
package com.zwinslett.strava;

import java.util.List;

class ActivityCalculator {
  public double totalMiles(List<Activity> activities){
    double totalMiles = 0.0;
    for (Activity activity : activities){
        totalMiles += activity.getDistance();
    }
    return totalMiles * 0.000621371; // Convert meters to miles
  }
  public double totalMinutes(Lis@@t<Activity> activities){
    int totalMinutes = 0;
    for (Activity activity : activities){
      totalMinutes += activity.getMoving_time();
    }
    return totalMinutes / 60.0; // Convert seconds to minutes
  }
  public int totalActivities(List<Activity> activities){
    return activities.size();
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: java/util/List#