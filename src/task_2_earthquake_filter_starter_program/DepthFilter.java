package task_2_earthquake_filter_starter_program;

import java.util.ArrayList;

/**
 * Created by User on 01.02.2017.
 */
public class DepthFilter implements Filter {


    private double minimDepth;
    private double maximDepth;

    public DepthFilter(double minimDepth, double maximDepth) {
        this.maximDepth = maximDepth;
        this.minimDepth = minimDepth;
    }


   /* @Override
    public ArrayList<QuakeEntry> addToList(Filter filter, ArrayList<QuakeEntry> quakeEntries) {
        if (filter.satisfies())
    }*/




    @Override
    public String getName() {
        return "DepthFilter";
    }


    @Override
    public boolean satisfies(QuakeEntry quakeEntry) {
        if (quakeEntry.getDepth() >= minimDepth && quakeEntry.getDepth() <= maximDepth) {
            return true;
        }
        return false;
    }


}
