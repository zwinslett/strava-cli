package com.zwinslett.strava.calculator;

import com.zwinslett.strava.model.DistributionBuckets;
import com.zwinslett.strava.model.DistributionBucketsFormatted;
import com.zwinslett.strava.model.Zones;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Comparator;

public class ZonesCalculator {
  public enum ZoneType {
    pace,
    heartrate,
    power
  };

  public record BucketKey(int min, int max) {
  };

  private List<DistributionBuckets> aggregateBuckets(List<Zones> zones) {
    Map<BucketKey, Integer> totals = new TreeMap<>(
        Comparator.comparingInt(BucketKey::min));
    for (Zones zone : zones) {
      for (DistributionBuckets bucket : zone.getDistributionBuckets()) {
        BucketKey key = new BucketKey(bucket.getMin(), bucket.getMax());
        totals.merge(key, bucket.getTime(), Integer::sum);

      }
    }
    List<DistributionBuckets> result = new ArrayList<>();
    for (Map.Entry<BucketKey, Integer> entry : totals.entrySet()) {
      BucketKey key = entry.getKey();
      result.add(new DistributionBuckets(key.min(), key.max(), entry.getValue()));
    }
    return result;
  }

  public List<DistributionBucketsFormatted> calculateZones(List<Zones> zones, ZoneType type) {
    List<Zones> heartRateZones = new ArrayList<>();
    for (Zones zone : zones) {
      if (zone.getType().equals(type.name())) {
        heartRateZones.add(zone);
      }
    }
    List<DistributionBuckets> buckets = aggregateBuckets(heartRateZones);
    List<DistributionBucketsFormatted> cleanBuckets = new ArrayList<>();
    int totalTime = 0;

    for (DistributionBuckets bucket : buckets) {
      totalTime += bucket.getTime();
    }

    for (DistributionBuckets bucket : buckets) {
      double percentInZone = (double) bucket.getTime() / totalTime;
      DistributionBucketsFormatted cleanBucket = new DistributionBucketsFormatted(bucket.getMin(),
          bucket.getMax(), percentInZone, bucket.getTime());
      cleanBuckets.add(cleanBucket);
    }
    return cleanBuckets;

  }

}
