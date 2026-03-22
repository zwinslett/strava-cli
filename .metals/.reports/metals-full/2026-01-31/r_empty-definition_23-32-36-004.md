error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StravaActivityRequest.java:java/net/http/HttpRequest#newBuilder(+2).
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StravaActivityRequest.java
empty definition using pc, found symbol in pc: java/net/http/HttpRequest#newBuilder(+2).
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 722
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StravaActivityRequest.java
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

public class StravaActivityRequest {

    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();
    private static final String STRAVA_AUTH_URL = "https://www.strava.com/oauth/token";
    private static final String STRAVA_BASE_URL = "https://www.strava.com/api/v3";

    public String getAccessToken() throws Exception {
        HttpRequest request = HttpRequest.newBuil@@der()
                .uri(URI.create(STRAVA_AUTH_URL + "?client_id=73037&client_secret=b7c366b06c7650ef6ebc6f0c7bb6800bd922b55f&refresh_token=5e5415cb7c87f07bebc43a7465086f17bafeaac7&grant_type=refresh_token&f=json"))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            // Parse the access token from the response body
            Map<String, Object> responseMap = this.mapper.readValue(response.body(), new TypeReference<Map<String, Object>>() {});
            String accessToken = (String) responseMap.get("access_token");
            return accessToken;
        } else {
            throw new Exception("Failed to get access token: " + response.statusCode());
        }
    }

    public String getActivityById(long activityId, String accessToken) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(StravaActivityRequest.STRAVA_BASE_URL + "/activities/" + activityId))
                .header("Authorization", "Bearer " + accessToken)
                .GET()
                .build();
        HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new Exception("Failed to fetch activity: " + response.statusCode());
        }
    }

    public String getMostRecentActivity(String accessToken) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(StravaActivityRequest.STRAVA_BASE_URL + "/athlete/activities?per_page=1&page=1"))
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

    public static void main(String[] args) {
        StravaActivityRequest test = new StravaActivityRequest();
        try {
            String accessToken = test.getAccessToken();
            System.out.println("Access Token: " + accessToken);
            long activityId = 17072063259L; // Replace with a valid activity ID
            String activityData = test.getActivityById(activityId, accessToken);
            System.out.println("Activity Data: " + JsonFormatter.formatJson(activityData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: java/net/http/HttpRequest#newBuilder(+2).