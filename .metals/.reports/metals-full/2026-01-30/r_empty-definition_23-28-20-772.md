error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StravaActivityRequest.java:_empty_/ObjectMapper#
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StravaActivityRequest.java
empty definition using pc, found symbol in pc: _empty_/ObjectMapper#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 680
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StravaActivityRequest.java
text:
```scala
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public class StravaActivityRequest{

    public String getAccessToken() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.strava.com/oauth/token"))
                .POST(HttpRequest.BodyPublishers.ofString("my body"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Objec@@tMapper mapper = new ObjectMapper();
        Map<String, Object> responseMap = mapper.readValue(response.body(), Map.class);
        String accessToken = (String) responseMap.get("access_token");
        if (response.statusCode() == 200) {
            // Parse the access token from the response body
            return accessToken;
        } else {
            throw new Exception("Failed to get access token: " + response.statusCode());
        }
    }

    public String getActivity(long activityId) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.strava.com/api/v3/activities/" + activityId))
                .header("Authorization", "Bearer " + accessToken)
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new Exception("Failed to fetch activity: " + response.statusCode());
        }
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/ObjectMapper#