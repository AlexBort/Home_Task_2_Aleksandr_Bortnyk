
package task_1_searching_earthquake_data;

import java.util.*;


public class EarthQuakeClient {


    public static void main(String[] args) {
        //  bigQuakes();
        closeToMe();
        // quakesOfDepth();
        // quakesByPhrase();
        //  closeToMe();
    }

    public EarthQuakeClient() {
        // TODO Auto-generated constructor stub
    }


    public static ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData, double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for (int i = 0; i < quakeData.size(); i++) {
            if (quakeData.get(i).getMagnitude() > magMin) {
                answer.add(quakeData.get(i));
            }
        }
        return answer;
    }


    public static void bigQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        String sourceSmall = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list = parser.read(sourceSmall);
        for (int i = 0; i < list.size(); i++) {
            list = filterByMagnitude(list, 5.0);
        }
        System.out.println("read data for " + list.size() + " quakes");
        System.out.println(list);
    }



    private static ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> quakeData, double minDepth, double maxDepth) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for (int i = 0; i < quakeData.size(); i++) {

            if (quakeData.get(i).getDepth() > minDepth && quakeData.get(i).getDepth() < maxDepth) {
                answer.add(quakeData.get(i));
            }
        }
        return answer;
    }

    private static void quakesOfDepth() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String sourceSmall = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list = parser.read(sourceSmall);
        for (int i = 0; i < list.size(); i++) {
            list = filterByDepth(list, -10000.0, -5000.0);
        }
        System.out.println("read data for " + list.size() + " quakes");
        System.out.println("Find quakes with depth between -10000.0 and -5000.0");
        System.out.println(list);

    }


    private static ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> quakeData, String where, String phrase) {

        ArrayList<QuakeEntry> answer = new ArrayList<>();
        for (int i = 0; i < quakeData.size(); i++) {
            switch (where) {
                case "start":
                    if (quakeData.get(i).getInfo().startsWith(phrase)) {
                        answer.add(quakeData.get(i));
                    }
                    break;
                case "end":
                    if (quakeData.get(i).getInfo().endsWith(phrase)) {
                        answer.add(quakeData.get(i));
                    }
                    break;
                case "any":
                    if (quakeData.get(i).getInfo().contains(phrase)) {
                        answer.add(quakeData.get(i));
                    }
                    break;
            }
        }
        return answer;
    }

    static void quakesByPhrase() {

        EarthQuakeParser parser = new EarthQuakeParser();
        String sourceSmall = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list = parser.read(sourceSmall);

        ArrayList<QuakeEntry> listPhrase = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listPhrase = filterByPhrase(list, "end", "California"); // should be 4 quakes
            //  listPhrase = filterByPhrase(list, "any", "Can");
            //  listPhrase = filterByPhrase(list, "start", "Explosion");
        }
        System.out.println("read data for " + listPhrase.size() + " quakes");
        System.out.println(listPhrase);

    }


    public static ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData, double distMax, Location location) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();

        for (int i = 0; i < quakeData.size(); i++) {
            if (quakeData.get(i).getLocation().distanceTo(location) < distMax) {
                answer.add(quakeData.get(i));
            }
        }
        return answer;
    }


    public static void closeToMe() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String sourceSmall = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list = parser.read(sourceSmall);

        // Durham, NC
        Location city = new Location(35.988, -78.907); // ничего не должно вывести

        // Bridgeport, CA
        Location city2 = new Location(38.17, -118.82); // должно показать 7 землетрясений

        ArrayList<QuakeEntry> quakeClose = filterByDistanceFrom(list, 1000000, city2);
        for (QuakeEntry quakeEntry : quakeClose) {
            System.out.println(quakeEntry);
        }

    }




    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }
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

}
