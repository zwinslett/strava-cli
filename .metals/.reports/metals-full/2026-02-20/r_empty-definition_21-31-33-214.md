error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/Activity.java:
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/Activity.java
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 296
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/Activity.java
text:
```scala
package com.zwinslett.strava;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
class Activity {
    private long id;
    private String name;
    private double distance; // meters
    private int moving_time; // seconds
    private int@@ elapsed_time; // seconds
    private String type;

    public Activity() {
    }

    public Activity(long id, String name, double distance, int moving_time, int elapsed_time, Instant start_date,
            String type) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.moving_time = moving_time;
        this.elapsed_time = elapsed_time;
        this.start_date = start_date;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getDistance() {
        return distance;
    }

    public int getMoving_time() {
        return moving_time;
    }

    public int getElapsed_time() {
        return elapsed_time;
    }

    public Instant getStart_date() {
        return start_date;
    }

    public String getType() {
        return type;
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: 