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

 //  ArrayList<QuakeEntry> addToList(Filter filter, ArrayList<QuakeEntry> quakeEntries);
}

/*Странно немного, логично просто для каждого нового фильтра создавать новый наследник,
 и это будет наследование соответственно, если надо несколько фильтров можно использовать декорацию,
 в той книге по паттернам есть этот паттерн, я думаю он лучше всего напрашивается)*/

// то какие методы делать для того класса, от которого будут наследоваться другие фильтры??
// Странно немного, логично просто для каждого нового фильтра создавать новый наследник