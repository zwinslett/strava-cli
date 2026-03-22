error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/api/StravaAPIClient.java
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/api/StravaAPIClient.java
### com.thoughtworks.qdox.parser.ParseException: syntax error @[41,12]

error in qdox parser
file content:
```java
offset: 1596
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

    public void loadConfig() throws Exception {
        try {
            java.util.Properties properties = new java.util.Properties();
            properties.load(StravaAPIClient.class.getClassLoader().getResourceAsStream("config.properties"));
            CLIENT_ID = properties.getProperty("client_id");
            CLIENT_SECRET = properties.getProperty("client_secret");
            REFRESH_TOKEN = properties.getProperty("refresh_token");
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }
    }

    // Method to get access token using refresh token
    public S@@tring getAccessToken() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(STRAVA_AUTH_URL
                        + "?client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRET + "&refresh_token="
                        + REFRESH_TOKEN + "&grant_type=refresh_token&f=json"))
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

    // Method to get activities in a time range, before and after are epoch
    // timestamps
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

```



#### Error stacktrace:

```
com.thoughtworks.qdox.parser.impl.Parser.yyerror(Parser.java:2025)
	com.thoughtworks.qdox.parser.impl.Parser.yyparse(Parser.java:2147)
	com.thoughtworks.qdox.parser.impl.Parser.parse(Parser.java:2006)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:232)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:190)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:94)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:89)
	com.thoughtworks.qdox.library.SortedClassLibraryBuilder.addSource(SortedClassLibraryBuilder.java:162)
	com.thoughtworks.qdox.JavaProjectBuilder.addSource(JavaProjectBuilder.java:174)
	scala.meta.internal.mtags.JavaMtags.indexRoot(JavaMtags.scala:49)
	scala.meta.internal.metals.SemanticdbDefinition$.foreachWithReturnMtags(SemanticdbDefinition.scala:99)
	scala.meta.internal.metals.Indexer.indexSourceFile(Indexer.scala:560)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3(Indexer.scala:691)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3$adapted(Indexer.scala:688)
	scala.collection.IterableOnceOps.foreach(IterableOnce.scala:630)
	scala.collection.IterableOnceOps.foreach$(IterableOnce.scala:628)
	scala.collection.AbstractIterator.foreach(Iterator.scala:1313)
	scala.meta.internal.metals.Indexer.reindexWorkspaceSources(Indexer.scala:688)
	scala.meta.internal.metals.MetalsLspService.$anonfun$onChange$2(MetalsLspService.scala:936)
	scala.runtime.java8.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.scala:18)
	scala.concurrent.Future$.$anonfun$apply$1(Future.scala:691)
	scala.concurrent.impl.Promise$Transformation.run(Promise.scala:500)
	java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
	java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
	java.base/java.lang.Thread.run(Thread.java:1623)
```
#### Short summary: 

QDox parse error in file://<WORKSPACE>/src/main/java/com/zwinslett/strava/api/StravaAPIClient.java