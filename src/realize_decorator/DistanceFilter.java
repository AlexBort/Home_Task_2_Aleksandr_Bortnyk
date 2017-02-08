package realize_decorator;



/**
 * Created by User on 08.02.2017.
 */
public class DistanceFilter {

    private Location location;
    private double maximDistance;

    public DistanceFilter(Location location, double maximDistance) {
        this.location = location;
        this.maximDistance = maximDistance;
    }

    public DistanceFilter(DepthFilter depthFilter) {

    }
}
