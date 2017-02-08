package example_decorator;

import example_without_decorator.Developer;

/**
 * Created by User on 08.02.2017.
 */
public class SeniorJavaDeveloper extends DeveloperDecorator {
    public SeniorJavaDeveloper(Developer developer) {
        super(developer);
    }

    @Override
    public String makeJob() {
        return super.makeJob() + makeCodeReview();
    }

    public String makeCodeReview() {
        return "Make code review";
    }
}
