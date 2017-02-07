package task_2_earthquake_filter_starter_program;

import java.util.ArrayList;

/**
 * Created by User on 02.02.2017.
 */
public class MatchAllFilter implements Filter {

    private ArrayList<Filter> filters;

    public MatchAllFilter() {
        filters = new ArrayList<Filter>();

    }

    @Override
    public boolean satisfies(QuakeEntry quakeEntry) {
        for (Filter filter : filters) {
            if (!filter.satisfies(quakeEntry)) return false;
        }
        return true;
    }

    void addFilter(Filter filter) {
        filters.add(filter);
    }

    @Override
    public String getName() {
        StringBuilder sb = new StringBuilder("Filters used: ");

        for (Filter filter : filters) {
            sb.append(filter.getName()+ " ");
        }

        return sb.toString();
    }

}
