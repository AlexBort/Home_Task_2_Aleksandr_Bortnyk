package example_decorator;

import example_without_decorator.Developer;

/**
 * Created by User on 08.02.2017.
 */
public class DeveloperDecorator implements Developer {

    Developer developer; // создаем поле нашего ИНТЕРФЕЙСА

    public DeveloperDecorator(Developer developer) {
        this.developer = developer;
    }

    @Override
    public String makeJob() {
        return developer.makeJob();
    }
}
