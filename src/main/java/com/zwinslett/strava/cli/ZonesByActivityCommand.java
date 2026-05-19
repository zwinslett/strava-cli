package com.zwinslett.strava.cli;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import com.zwinslett.strava.formatter.ZoneFormatter;
import com.zwinslett.strava.model.DistributionBucketsFormatted;
import com.zwinslett.strava.model.Zones;
import java.util.List;


@Command(name = "zones", description = "Display an activity's zones for a given activity ID")
public class ZonesByActivityCommand extends BaseCommand implements Runnable {
    @Parameters(index = "0", description ="The ID of an activity.")
    private long activityId;

    @Override
    public void run(){
        try{
            List<Zones> zones = stravaRequest.getActivityZones(activityId);
            Zones zone = zones.stream().filter(z -> z.getType().equals("heartrate")).findFirst().orElseThrow(() -> new RuntimeException("No Heartrate Data for this Activity"));
            List<DistributionBucketsFormatted> buckets = zoneCalculator.calculateZones(zone);
            System.out.println(ZoneFormatter.formatZonesTableHeader());
            for(DistributionBucketsFormatted bucket: buckets){
                System.out.println(ZoneFormatter.formatZoneTableRows(bucket));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  
}
