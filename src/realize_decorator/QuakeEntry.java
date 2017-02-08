package realize_decorator;


public class QuakeEntry implements Comparable<QuakeEntry> {

    private Location myLocation;
    private String title;
    private double depth;
    private double magnitude;

    public QuakeEntry(double lat, double lon, double mag, String t, double d) {
        myLocation = new Location(lat, lon);

        magnitude = mag;
        title = t;
        depth = d;
    }

    public Location getLocation() {
        return myLocation;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getInfo() {
        return title;
    }

    public double getDepth() {
        return depth;
    }


    // зачем вообще этот метод тут прописывали
    // какую он функцию ВЫПОЛНЯЕТ?!
    @Override
    public int compareTo(QuakeEntry loc) {
        double difflat = myLocation.getLatitude() - loc.myLocation.getLatitude();
        if (Math.abs(difflat) < 0.001) { // если разница широт будет меньше 0.001
            double diff = myLocation.getLongitude() - loc.myLocation.getLongitude(); // разность долготы
            if (diff < 0) return -1; // что вообще эти возвраты -1, или 1 нам дают?!?!?
            if (diff > 0) return 1;
            return 0;
        }
        if (difflat < 0) return -1;
        if (difflat > 0) return 1;

        // never reached
        return 0;
    }

    public String toString() {
        return String.format("(%3.2f, %3.2f), mag = %3.2f, depth = %3.2f, title = %s", myLocation.getLatitude(), myLocation.getLongitude(), magnitude, depth, title);
    }

}
