package realize_decorator;

/**
 * Created by User on 08.02.2017.
 */
public class FilterDecorator implements Filter {

    Filter filter;

    public FilterDecorator(Filter filter) {
        this.filter = filter;
    }


    @Override
    public boolean satisfies(QuakeEntry quakeEntry) {
        if (filter.satisfies(quakeEntry)) return true; // мне кажется, что такая реализация, это уже херня!!
        return false;
    }

    @Override
    public String getName() {
        return filter.getName();
    }
}
