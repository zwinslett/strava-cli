package com.zwinslett.strava.model;

import java.util.List;

public class ActivityReport {
  DetailedActivity activity;
  List<DistributionBucketsFormatted> buckets;

  public ActivityReport() {

  }

  public ActivityReport(DetailedActivity activity, List<DistributionBucketsFormatted> buckets) {
    this.activity = activity;
    this.buckets = buckets;
  }

  public DetailedActivity getActivity() {
    return this.activity;
  }

  public List<DistributionBucketsFormatted> getBuckets() {
    return this.buckets;
  }
}
