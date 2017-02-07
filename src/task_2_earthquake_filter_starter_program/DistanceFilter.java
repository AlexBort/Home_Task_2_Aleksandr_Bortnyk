package task_2_earthquake_filter_starter_program;

/**
 * Created by User on 01.02.2017.
 */
public class DistanceFilter implements Filter {

    private Location location;
    private double maximDistance;

    public DistanceFilter(Location location, double maximDistance) {
        this.location = location;
        this.maximDistance = maximDistance;
    }


    @Override
    public boolean satisfies(QuakeEntry quakeEntry) {
        if (quakeEntry.getLocation().distanceTo(location)<maximDistance) {
            return true;
        }

        return false;
    }

    @Override
    public String getName() {
        return "DistanceFilter";
    }
}
