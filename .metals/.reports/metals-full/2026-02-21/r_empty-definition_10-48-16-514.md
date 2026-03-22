error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/ActivityStats.java:_empty_/Activity#
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/ActivityStats.java
empty definition using pc, found symbol in pc: _empty_/Activity#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 114
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/ActivityStats.java
text:
```scala
package com.zwinslett.strava;

import java.util.List;

class ActivityStats {
  public double totalMiles(List<Activ@@ity> activities){
    double totalMeters = 0.0;
    double totalMetersToMiles = 0.0;
    for (Activity activity : activities){
        totalMeters = totalMeters + activity.getDistance();
        totalMetersToMiles = totalMeters * 0.000621371;
    }
    return totalMetersToMiles;
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/Activity#