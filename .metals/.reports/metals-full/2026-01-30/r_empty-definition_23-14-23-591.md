error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StravaActivityRequest.java:java/lang/String#
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StravaActivityRequest.java
empty definition using pc, found symbol in pc: java/lang/String#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 177
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StravaActivityRequest.java
text:
```scala
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class StravaActivityRequest{

    public Strin@@g getAccessToke() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.strava.com/oauth/token"))
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

empty definition using pc, found symbol in pc: java/lang/String#