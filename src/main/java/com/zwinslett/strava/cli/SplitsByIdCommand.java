package com.zwinslett.strava.cli;

import com.zwinslett.strava.formatter.SplitFormatter;
import com.zwinslett.strava.model.DetailedActivity;
import com.zwinslett.strava.model.SplitFormatted;
import java.util.List;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "splits", description = "Display an activity's splits for a given activity ID")

public class SplitsByIdCommand extends BaseCommand implements Runnable {
  @Parameters(index = "0", description = "The ID of an activity.")
  private long activityId;

  @Override
  public void run() {
    try {
      DetailedActivity activity = this.activityDetailsService.getDetailedActivity(activityId);
      List<SplitFormatted> splits = this.activityDetailsService.getSplits(activity);
      System.out.println(SplitFormatter.formatSplitsTableHeader());
      for (SplitFormatted split : splits) {
        System.out.println(SplitFormatter.formatSplitsTableRows(split));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
