package task_2_earthquake_filter_starter_program;

import java.util.ArrayList;

/**
 * Created by User on 07.02.2017.
 */
public class FilterImpl implements Filter {


    @Override
    public boolean satisfies(QuakeEntry quakeEntry) {
        return false;
    }

    @Override
    public String getName() {
        return getClass().getName();
    }


    public ArrayList<QuakeEntry> addToList(Filter filter, ArrayList<QuakeEntry> quakeData) {
        ArrayList<QuakeEntry> answer = new ArrayList<>();
        for (QuakeEntry quakeEntry : quakeData) {
            if (filter.satisfies(quakeEntry)) {
                answer.add(quakeEntry);
            }
        }
        return answer;
    }
}
