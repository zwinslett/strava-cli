error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/ActivityFormatter.java:java/lang/String#
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/ActivityFormatter.java
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -String.
	 -String#
	 -String().
	 -scala/Predef.String.
	 -scala/Predef.String#
	 -scala/Predef.String().
offset: 79
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/ActivityFormatter.java
text:
```scala
package com.zwinslett.strava;

class ActivityFormatter {
  public static String@@ formatActivity(Activity activity) {
    return String.format("Activity: %s | Distance: %.2f | Type: %s", activity.getName(), activity.getDistance(), activity.getType());
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: 