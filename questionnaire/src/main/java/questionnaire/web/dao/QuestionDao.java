package questionnaire.web.dao;

import questionnaire.database.QuestionType;

import java.util.List;

public interface QuestionDao {
    /**
     * 获取问卷的所有问题列表
     *
     * @param questionnaireId 问卷ID
     * @return 问卷的问题列表
     */
    List<QuestionType> readQuestion(String questionnaireId);

    /**
     * 根据问题ID获取单个问题的信息
     *
     * @param questionId 问题的ID
     * @return 问题ID对应的问题对象
     */
    QuestionType readOneQuestion(String questionId);

    /**
     * 添加新问题
     *
     * @param questionType 新问题
     */
    void createQuestion(QuestionType questionType);

    /**
     * 删除某个问题
     *
     * @param questionId
     */
    void deleteQuestion(String questionId);

    /**
     * 根据问题ID修改问题的描述
     *
     * @param question 修改后的问题
     */
    void updateQuestion(QuestionType question);
}
