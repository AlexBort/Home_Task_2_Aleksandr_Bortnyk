package example_decorator;

import example_without_decorator.Developer;
import example_without_decorator.JavaDeveloper;

/**
 * Created by User on 08.02.2017.
 */
public class Client {

    public static void main(String[] args) {
        Developer developer = new SeniorJavaDeveloper(new JavaDeveloper());
        System.out.println(developer.makeJob());

        Developer developer2 = new JavaTeamLead(new SeniorJavaDeveloper(new JavaDeveloper()));
        System.out.println(developer2.makeJob());


        Developer developer3 = new JavaDeveloper();
        Developer developer4= new SeniorJavaDeveloper(null);
    }

}
