package example_without_decorator;

/**
 * Created by User on 08.02.2017.
 */
public class Task {

    public static void main(String[] args) {

        Developer developer = new JavaDeveloper(); // пока что я вижу в этом примере как раз таки использование интерфейса, как и в моей случае с фильтрами!!
        System.out.println(developer.makeJob());

    }
}
