error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/api/StravaAPIClient.java:java/net/http/HttpRequest#Builder#uri().
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/api/StravaAPIClient.java
empty definition using pc, found symbol in pc: java/net/http/HttpRequest#Builder#uri().
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 1678
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/api/StravaAPIClient.java
text:
```scala
package com.zwinslett.strava.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zwinslett.strava.formatter.ActivityFormatter;
import com.zwinslett.strava.model.Activity;
import com.zwinslett.strava.model.Stats;
import com.zwinslett.strava.service.ActivityCalculator;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Map;

public class StravaAPIClient {

    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();
    private static final String STRAVA_AUTH_URL = "https://www.strava.com/oauth/token";
    private static final String STRAVA_BASE_URL = "https://www.strava.com/api/v3";
    private static final String CLIENT_ID;
    private static final String CLIENT_SECRET;
    private static final String REFRESH_TOKEN;

    static {
        try {
            java.util.Properties properties = new java.util.Properties();
            properties.load(new java.io.FileInputStream("src/main/java/com/zwinslett/strava/api/config.properties"));
            CLIENT_ID = properties.getProperty("client_id");
            CLIENT_SECRET = properties.getProperty("client_secret");
            REFRESH_TOKEN = properties.getProperty("refresh_token");
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    // Method to get access token using refresh token
    public String getAccessToken() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .u@@ri(URI.create(STRAVA_AUTH_URL
                        + "?client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRET + "&refresh_token=" + REFRESH_TOKEN + "&grant_type=refresh_token&f=json"))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            Map<String, Object> responseMap = this.mapper.readValue(response.body(),
                    new TypeReference<Map<String, Object>>() {
                    });
            String accessToken = (String) responseMap.get("access_token");
            return accessToken;
        } else {
            throw new Exception("Failed to get access token: " + response.statusCode());
        }
    }

    // Method to get activity by ID
    public Activity getActivityById(long activityId, String accessToken) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(StravaAPIClient.STRAVA_BASE_URL + "/activities/" + activityId))
                .header("Authorization", "Bearer " + accessToken)
                .GET()
                .build();
        HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            Activity activity = this.mapper.readValue(response.body(), Activity.class);
            return activity;
        } else {
            throw new Exception("Failed to fetch activity: " + response.statusCode());
        }
    }

    // Method to get a number of activities, default 1, max 10
    public List<Activity> getRecentActivities(String accessToken, int per_page) throws Exception {
        if (per_page < 1 || per_page > 10) {
            throw new IllegalArgumentException("per_page must be between 1 and 10");
        }
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                        StravaAPIClient.STRAVA_BASE_URL + "/athlete/activities?per_page=" + per_page + "&page=1"))
                .header("Authorization", "Bearer " + accessToken)
                .GET()
                .build();
        HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            List<Activity> activities = this.mapper.readValue(response.body(), new TypeReference<List<Activity>>() {
            });
            return activities;
        } else {
            throw new Exception("Failed to fetch most recent activity: " + response.statusCode());
        }

    }
    // Method to get activities in a time range, before and after are epoch timestamps
    public List<Activity> getRangeActivities(String accessToken, long before, long after) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                        StravaAPIClient.STRAVA_BASE_URL + "/athlete/activities?before=" + before + "&after=" + after))
                .header("Authorization", "Bearer " + accessToken)
                .GET()
                .build();
        HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            List<Activity> activities = this.mapper.readValue(response.body(), new TypeReference<List<Activity>>() {
            });
            return activities;
        } else {
            throw new Exception("Failed to fetch activities in range: " + response.statusCode());
        }

    }

    // Test method to verify API client functionality
    public static void main(String[] args) {
        StravaAPIClient test = new StravaAPIClient();
        try {
            String accessToken = test.getAccessToken();
            System.out.println("Access Token: " + accessToken);
            // long activityId = 17072063259L; // Replace with a valid activity ID
            // Activity activity = test.getActivityById(activityId, accessToken);
            // System.out.println(ActivityFormatter.formatActivity(activity));
            // List<Activity> recentActivityData = test.getRecentActivities(accessToken,
            // 10);
            // for (Activity a : recentActivityData){
            // System.out.println(ActivityFormatter.formatActivity(a));
            // }
            List<Activity> rangeActivities = test.getRangeActivities(accessToken, 1771708624, 1771276624);
            Stats rangeActivityStates = new ActivityCalculator().calculateStats(rangeActivities);
            System.out.println(ActivityFormatter.formatActivities(rangeActivityStates));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: java/net/http/HttpRequest#Builder#uri().