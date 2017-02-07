
package task_2_earthquake_filter_starter_program;

import java.util.*;


public class EarthQuakeClient2 {
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
      quakesWithFilter();
        //   testMatchAllFilter();
     //   testMatchAllFilter2();
    }

    public static ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter filter) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for (QuakeEntry quakeEntry : quakeData) {
            if (filter.satisfies(quakeEntry)) {
                answer.add(quakeEntry);
            }
        }
        return answer;
    }






    public static void quakesWithFilter() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        //      System.out.println("read data for " + list.size() + " quakes");

        Filter filter = new MinMagFilter(4.0);
        Filter magnitudeFilter = new MagnitudeFilter(4.0, 5.0);
        Filter depthFilter = new DepthFilter(-35000.0, -12000.0);

        ArrayList<QuakeEntry> magQuakes = filter(list, magnitudeFilter);

        ArrayList<QuakeEntry> depQuakes = filter(magQuakes, depthFilter);

        for (QuakeEntry quake : depQuakes) {
            System.out.println(quake);
        }
        System.out.printf("Found %d matching.", depQuakes.size());

    }

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for (QuakeEntry qe : list) {
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                    qe.getLocation().getLatitude(),
                    qe.getLocation().getLongitude(),
                    qe.getMagnitude(),
                    qe.getInfo());
        }
    }

    public static void testMatchAllFilter() {

        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String sourceSmall = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list = parser.read(sourceSmall);
        System.out.println("read data for " + list.size() + " quakes");

        MatchAllFilter matchAllFilter = new MatchAllFilter();
        matchAllFilter.addFilter(new MagnitudeFilter(0.0, 2.0));
        matchAllFilter.addFilter(new DepthFilter(-100000.0, -10000.0));
        matchAllFilter.addFilter(new PhraseFilter("any", "a"));

        ArrayList<QuakeEntry> filtered = filter(list, matchAllFilter);

        for (QuakeEntry qe : filtered) System.out.println(qe);

        System.out.println(matchAllFilter.getName());
        System.out.printf("Found %d matching.", filtered.size());

    }

    public static void testMatchAllFilter2() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("read data for " + list.size() + " quakes");

        MatchAllFilter matchAllFilter = new MatchAllFilter();
        matchAllFilter.addFilter(new MagnitudeFilter(0.0, 3.0));

        Location location = new Location(36.1314, -95.9372);
        matchAllFilter.addFilter(new DistanceFilter(location, 10000000)); // 10000000 meters (10000 km)
        matchAllFilter.addFilter(new PhraseFilter("any", "Ca"));

        ArrayList<QuakeEntry> filtered = filter(list, matchAllFilter);

        for (QuakeEntry qe : filtered) System.out.println(qe);

        System.out.println(matchAllFilter.getName());
        System.out.printf("Found %d matching.", filtered.size());
    }

}
