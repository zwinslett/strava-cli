package com.zwinslett.strava.formatter;

import com.zwinslett.strava.model.SplitFormatted;

public class SplitFormatter {

    public static String formatSplitsTableHeader() {
        String header = String.format("%-10s %-30s %-30s%n", "Split", "Moving Time", "Average Heartrate");
        String divider = "-----------------------------------------------------------------------------------";
        return header + divider;
    }

    public static String formatSplitsTableRows(SplitFormatted split) {
        return String.format("%-10d %-30s %-30.2f", split.getMile(), split.getMovingTime(),
                split.getAverageHeartRate());

    }

}
