error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StravaAPIClient.java:java/net/http/HttpResponse#
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StravaAPIClient.java
empty definition using pc, found symbol in pc: java/net/http/HttpResponse#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 2064
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StravaAPIClient.java
text:
```scala
package com.zwinslett.strava;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Map;

public class StravaAPIClient {

    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();
    private static final String STRAVA_AUTH_URL = "https://www.strava.com/oauth/token";
    private static final String STRAVA_BASE_URL = "https://www.strava.com/api/v3";

    // Method to get access token using refresh token
    public String getAccessToken() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(STRAVA_AUTH_URL
                        + "?client_id=73037&client_secret=b7c366b06c7650ef6ebc6f0c7bb6800bd922b55f&refresh_token=5e5415cb7c87f07bebc43a7465086f17bafeaac7&grant_type=refresh_token&f=json"))
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
    public List<Activity> getActivityById(long activityId, String accessToken) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(StravaAPIClient.STRAVA_BASE_URL + "/activities/" + activityId))
                .header("Authorization", "Bearer " + accessToken)
                .GET()
                .build();
        HttpRes@@ponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new Exception("Failed to fetch activity: " + response.statusCode());
        }
    }

    // Method to get a number of activities, default 1, max 10
    public String getRecentActivities(String accessToken, int per_page) throws Exception {
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
            return response.body();
        } else {
            throw new Exception("Failed to fetch most recent activity: " + response.statusCode());
        }

    }

    // Test method to verify API client functionality
    public static void main(String[] args) {
        StravaAPIClient test = new StravaAPIClient();
        try {
            String accessToken = test.getAccessToken();
            System.out.println("Access Token: " + accessToken);
            long activityId = 17072063259L; // Replace with a valid activity ID
            String activityData = test.getActivityById(activityId, accessToken);
            System.out.println("Activity Data: " + JsonFormatter.formatJson(activityData));
            String recentActivityData = test.getRecentActivities(accessToken, 11);
            System.out.println("Recent Activity Data: " + JsonFormatter.formatJson(recentActivityData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: java/net/http/HttpResponse#