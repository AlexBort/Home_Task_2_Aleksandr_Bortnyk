package task_1_searching_earthquake_data;
/**
 * Find N-closest quakes
 *
 * @author Duke Software/Learn to Program
 * @version 1.0, November 2015
 */

import java.util.*;


public class ClosestQuakes {

    public static void main(String[] args) {
        findClosestQuakes();

    }


    private static ArrayList<QuakeEntry> getClosest(ArrayList<QuakeEntry> quakeData, Location current, int howMany) {

        ArrayList<QuakeEntry> copy = new ArrayList<>(quakeData);
        ArrayList<QuakeEntry> ret = new ArrayList<QuakeEntry>();
        for (int j = 0; j < howMany; j++) {

            int minIndex = 0;
            for (int i = 1; i < copy.size(); i++) {
                QuakeEntry quake = copy.get(i);
                if (quake.getLocation().distanceTo(current) <
                        copy.get(minIndex).getLocation().distanceTo(current)) {
                    minIndex = i;
                }
            }
            ret.add(copy.get(minIndex));
            copy.remove(minIndex);
        }
        return ret;
    }

    private static void findClosestQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
       String sourceSmall = "data/nov20quakedata.atom";
        String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list = parser.read(sourceSmall);
        System.out.println("read data for " + list.size());

        Location jakarta = new Location(-6.211, 106.845);

        ArrayList<QuakeEntry> close = getClosest(list, jakarta, 3);
        for (int k = 0; k < close.size(); k++) {
            QuakeEntry entry = close.get(k);
            double distanceInMeters = jakarta.distanceTo(entry.getLocation());
            System.out.printf("%4.2f\t %s\n", distanceInMeters / 1000, entry);
        }
        System.out.println("number found: " + close.size());
    }



}
