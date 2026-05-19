package com.zwinslett.strava.calculator;

import com.zwinslett.strava.model.DetailedActivity;
import com.zwinslett.strava.model.Split;
import com.zwinslett.strava.model.SplitFormatted;

import java.util.ArrayList;
import java.util.List;


public class SplitCalculator {

    private String secsToMins(Split split){
        int moving_time = split.getMovingTime();

        int minutes = moving_time / 60;
        int seconds = moving_time % 60;
        return String.format("%d Minute(s) %d Second(s)", minutes, seconds);

    }

    public List<SplitFormatted> calculateSplits(DetailedActivity activity){
        List<Split> splits = activity.getSplits();
        List<SplitFormatted> cleanSplits = new ArrayList<>();

        for(Split split : splits){
            String minutes = secsToMins(split);
            SplitFormatted cleanSplit = new SplitFormatted(split.getSplit(), minutes, split.getAverageHeartrate());
            cleanSplits.add(cleanSplit);
        }
        return cleanSplits;

    }
}
