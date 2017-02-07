package task_2_earthquake_filter_starter_program;

/**
 * Created by User on 01.02.2017.
 */
public class MagnitudeFilter implements Filter {

    double minMagnitude;
    double maxMagnitude;

    public MagnitudeFilter(double minMagnitude, double maxMagnitude) {
        this.maxMagnitude = maxMagnitude;
        this.minMagnitude = minMagnitude;
    }



    @Override
    public String getName() {
        return "MagnitudeFilter";
    }

    @Override
    public boolean satisfies(QuakeEntry quakeEntry) {
        if (quakeEntry.getMagnitude() >= minMagnitude && quakeEntry.getMagnitude() <= maxMagnitude) {
            return true;
        } return false;
    }


}
