package questionnaire.web.entity;

import java.util.List;

/**
 * 问卷答卷JSON串对于的Java对象
 */
public class QuestionnaireAnswerForm {
    /**
     * 问卷ID
     */
    String questionnaireId;
    /**
     * 问卷每一题的答案列表
     */
    List<QuestionAnswerForm> questionAnswers;

    /**
     * QuestionnaireAnswerFrom的构造方法
     *
     * @param questionnaireId 问卷ID
     * @param questionAnswers 问卷每一题的答案列表
     */
    public QuestionnaireAnswerForm(String questionnaireId, List<QuestionAnswerForm> questionAnswers) {
        this.questionnaireId = questionnaireId;
        this.questionAnswers = questionAnswers;
    }

    /**
     * questionnaireId的Get方法
     *
     * @return questionnaireId
     */
    public String getQuestionnaireId() {
        return questionnaireId;
    }

    /**
     * questionnaire的Set方法
     *
     * @param questionnaireId 问卷ID
     */
    public void setQuestionnaireId(String questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    /**
     * questionAnswers的Get方法
     *
     * @return questionAnswers
     */
    public List<QuestionAnswerForm> getQuestionAnswers() {
        return questionAnswers;
    }

    /**
     * questionAnswers的Set方法
     *
     * @param questionAnswers 问卷每一题的答案列表
     */
    public void setQuestionAnswers(List<QuestionAnswerForm> questionAnswers) {
        this.questionAnswers = questionAnswers;
    }
}
