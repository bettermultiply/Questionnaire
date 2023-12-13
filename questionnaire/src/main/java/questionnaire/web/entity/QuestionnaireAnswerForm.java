package questionnaire.web.entity;

import java.util.List;

public class QuestionnaireAnswerForm {
    String questionnaireId;
    List<QuestionAnswerForm> questionAnswers;

    public QuestionnaireAnswerForm(String questionnaireId, List<QuestionAnswerForm> questionAnswers) {
        this.questionnaireId = questionnaireId;
        this.questionAnswers = questionAnswers;
    }

    public String getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(String questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public List<QuestionAnswerForm> getQuestionAnswers() {
        return questionAnswers;
    }

    public void setQuestionAnswers(List<QuestionAnswerForm> questionAnswers) {
        this.questionAnswers = questionAnswers;
    }
}
