package questionnaire.web.dao;

import questionnaire.database.QuestionType;
import questionnaire.utils.QuestionTools;

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
     * 添加新问题
     *
     * @param questionType 新问题
     */
    void createQuestion(QuestionType questionType);
}
