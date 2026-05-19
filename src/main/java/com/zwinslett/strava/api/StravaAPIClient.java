package com.zwinslett.strava.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zwinslett.strava.model.Activity;
import com.zwinslett.strava.model.Zones;
import com.zwinslett.strava.model.DetailedActivity;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

public class StravaAPIClient {

	private final HttpClient client = HttpClient.newHttpClient();
	private final ObjectMapper mapper = new ObjectMapper();
	private static final String STRAVA_AUTH_URL = "https://www.strava.com/oauth/token";
	private static final String STRAVA_BASE_URL = "https://www.strava.com/api/v3";
	private static final String CLIENT_ID;
	private static final String CLIENT_SECRET;
	private static final String REFRESH_TOKEN;
	private String accessToken;

	static {
		try {
			java.util.Properties properties = new java.util.Properties();
			properties.load(new java.io.FileInputStream("config.properties"));
			CLIENT_ID = properties.getProperty("client_id");
			CLIENT_SECRET = properties.getProperty("client_secret");
			REFRESH_TOKEN = properties.getProperty("refresh_token");
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	private <T> T doGet(String url, TypeReference<T> input) throws Exception {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url))
				.header("Authorization", "Bearer " + this.accessToken).GET().build();

		HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
		if (response.statusCode() == 200) {
			return mapper.readValue(response.body(), input);
		} else {
			throw new Exception("Failed:" + response.statusCode());
		}

	}

	// Method to get access token using refresh token
	public void setAccessToken() throws Exception {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(STRAVA_AUTH_URL + "?client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRET
						+ "&refresh_token=" + REFRESH_TOKEN + "&grant_type=refresh_token&f=json"))
				.POST(HttpRequest.BodyPublishers.noBody()).build();
		HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
		if (response.statusCode() == 200) {
			AccessToken token = mapper.readValue(response.body(), AccessToken.class);
			this.accessToken = token.getToken();
		} else {
			throw new Exception("Failed to get access token: " + response.statusCode());
		}
	}

	// Method to get activity by ID
	public DetailedActivity getActivityById(long activityId) throws Exception {
		String url = STRAVA_BASE_URL + "/activities/" + activityId;
		return doGet(url, new TypeReference<DetailedActivity>() {
		});
	}

	// Method to get a number of activities, default 1, max 10
	public List<Activity> getRecentActivities(int per_page) throws Exception {
		if (per_page < 1 || per_page > 10) {
			throw new IllegalArgumentException("per_page must be between 1 and 10");
		}
		String url = StravaAPIClient.STRAVA_BASE_URL + "/athlete/activities?per_page=" + per_page + "&page=1";
		return doGet(url, new TypeReference<List<Activity>>() {
		});

	}

	// Method to get activities in a time range, before and after are epoch
	// timestamps
	public List<Activity> getRangeActivities(long before, long after) throws Exception {

		String url = StravaAPIClient.STRAVA_BASE_URL + "/athlete/activities?before=" + before + "&after=" + after;
		return doGet(url, new TypeReference<List<Activity>>() {
		});

	}

	// Method to get the zone information associated with an activity. 
	public List<Zones> getActivityZones(long activityId) throws Exception {
		String url = STRAVA_BASE_URL + "/activities/" + activityId + "/zones";
		return doGet(url, new TypeReference<List<Zones>>() {
		});

	}
}