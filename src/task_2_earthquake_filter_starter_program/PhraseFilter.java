package task_2_earthquake_filter_starter_program;

/**
 * Created by User on 02.02.2017.
 */
public class PhraseFilter implements Filter {

    private String where;
    private String phrase;

    public PhraseFilter(String where, String phrase) {
        this.where = where;
        this.phrase = phrase;
    }


    @Override
    public boolean satisfies(QuakeEntry quakeEntry) {

        switch (where) {
            case "start":
                return (quakeEntry.getInfo().startsWith(phrase));
            case "end":
                return (quakeEntry.getInfo().endsWith(phrase));
            case "any":
                return (quakeEntry.getInfo().contains(phrase));
        }
        return false;
    }

    @Override
    public String getName() {
        return "PhraseFilter";
    }
}
