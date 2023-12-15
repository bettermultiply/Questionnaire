package questionnaire.web.myTag;

import questionnaire.database.Choice;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;

/**
 * sort the choice
 */
public class ChoiceSortTag extends SimpleTagSupport {
    private Set<Choice> choiceSet;

    public void setChoiceSet(Set<Choice> choiceSet) {
        this.choiceSet = choiceSet;
    }

    @Override
    public void doTag() {
        ArrayList<Choice> choiceList = new ArrayList<>(choiceSet);
        choiceList.sort(Comparator.comparing(Choice::getcOrder));
        getJspContext().setAttribute("choiceList", choiceList);
    }
}
