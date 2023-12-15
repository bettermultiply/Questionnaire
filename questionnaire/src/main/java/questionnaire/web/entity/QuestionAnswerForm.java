package questionnaire.web.entity;

import java.util.List;

/**
 * 问卷每一题答案的JSON串所对应的Java对象
 */
public class QuestionAnswerForm {
    /**
     * 问题ID
     */
    String questionId;
    /**
     * 答案内容列表,文本填空题为填入的内容,选择题为选中的选项ID
     */
    List<String> answer;

    /**
     * QuestionAnswerForm的构造方法
     *
     * @param questionId 问题ID
     * @param answer 答案内容列表
     */
    public QuestionAnswerForm(String questionId, List<String> answer) {
        this.questionId = questionId;
        this.answer = answer;
    }

    /**
     * questionId的Get方法
     *
     * @return questionId
     */
    public String getQuestionId() {
        return questionId;
    }

    /**
     * questionId的Set方法
     *
     * @param questionId 问题的ID
     */
    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    /**
     * answer的Get方法
     *
     * @return answer
     */
    public List<String> getAnswer() {
        return answer;
    }

    /**
     * answer的Set方法
     *
     * @param answer 答案内容列表
     */
    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }
}
