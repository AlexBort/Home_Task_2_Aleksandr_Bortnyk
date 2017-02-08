package example_decorator;

import example_without_decorator.Developer;

/**
 * Created by User on 08.02.2017.
 */
public class JavaTeamLead extends DeveloperDecorator {


    public JavaTeamLead(Developer developer) {
        super(developer);
    }

    @Override
    public String makeJob() {
        return super.makeJob() + sendWeekReport();
    }

    public String sendWeekReport() {
        return "send week report to customer";
    }


}
