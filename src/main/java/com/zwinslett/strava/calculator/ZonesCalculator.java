package com.zwinslett.strava.calculator;

import com.zwinslett.strava.model.DistributionBuckets;
import com.zwinslett.strava.model.DistributionBucketsFormatted;
import com.zwinslett.strava.model.Zones;

import java.util.ArrayList;
import java.util.List;

public class ZonesCalculator {
    private String secsToMins(DistributionBuckets bucket) {
        int time = bucket.getTime();

        int minutes = time / 60;
        int seconds = time % 60;
        return String.format("%d Minute(s) %d Second(s)", minutes, seconds);

    }

    public List<DistributionBucketsFormatted> calculateZones(Zones zones) {
        List<DistributionBuckets> buckets = zones.getDistributionBuckets();
        List<DistributionBucketsFormatted> cleanBuckets = new ArrayList<>();
        int totalTime = 0;

        for (DistributionBuckets bucket : buckets) {
            totalTime += bucket.getTime();
        }

        for (DistributionBuckets bucket : buckets) {
            String minutes = secsToMins(bucket);
            double percentInZone = (double) bucket.getTime() / totalTime;
            DistributionBucketsFormatted cleanBucket = new DistributionBucketsFormatted(bucket.getMin(),
                    bucket.getMax(), percentInZone, minutes);
            cleanBuckets.add(cleanBucket);
        }
        return cleanBuckets;

    }

}
