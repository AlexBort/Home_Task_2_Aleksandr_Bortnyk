package realize_decorator;

/**
 * Created by User on 08.02.2017.
 */
public class Client {

    public static void main(String[] args) {

        Filter filter = (Filter) new DistanceFilter(new DepthFilter(7.0,8.0));

    }
}
