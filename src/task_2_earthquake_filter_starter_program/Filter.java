package task_2_earthquake_filter_starter_program;

import java.util.ArrayList;

/**
 * Write a description of interface Filter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Filter {
    boolean satisfies(QuakeEntry quakeEntry);

    String getName();

    // ArrayList<QuakeEntry> addToList(Filter filter, ArrayList<QuakeEntry> quakeEntries);
}
