package questionnaire.web.entity;

import java.util.List;

public class QuestionAnswerForm {
    String questionId;
    List<String> answer;

    public QuestionAnswerForm(String questionId, List<String> answer) {
        this.questionId = questionId;
        this.answer = answer;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public List<String> getAnswer() {
        return answer;
    }

    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }
}
