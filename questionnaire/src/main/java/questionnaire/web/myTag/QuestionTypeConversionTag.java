package questionnaire.web.myTag;

import questionnaire.database.QChoose;
import questionnaire.database.QuestionType;

import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * convert question type to qChoose
 */
public class QuestionTypeConversionTag extends SimpleTagSupport {
    private QuestionType question;

    public void setQuestion(QuestionType question) {
        this.question = question;
    }

    @Override
    public void doTag(){
        QChoose qChoose = null;
        if (question instanceof QChoose){
            qChoose = (QChoose) question;
        }

        getJspContext().setAttribute("QChoose", qChoose);
    }
}
