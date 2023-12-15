package questionnaire.web.myTag;

import questionnaire.database.QuestionType;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;

/**
 * sort question
 */
public class QuestionSortTag extends SimpleTagSupport {
    private Set<QuestionType> questionSet;

    public void setQuestionSet(Set<QuestionType> questionSet) {
        this.questionSet = questionSet;
    }

    @Override
    public void doTag() {
        ArrayList<QuestionType> questionList = new ArrayList<>(questionSet);
        questionList.sort(Comparator.comparing(QuestionType::getQuestionOrder));
        getJspContext().setAttribute("questionList", questionList);
    }
}
