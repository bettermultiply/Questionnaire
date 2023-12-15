package questionnaire.web.dao;

import questionnaire.database.ChoiceResult;
import questionnaire.database.QuestionTypeResult;
import questionnaire.database.QuestionnaireResult;

import java.util.List;

public interface QuestionResultDao {
    /**
     * 添加一个新的问题回答记录
     *
     * @param questionTypeResult 新的问题回答的记录
     * @return 新添加对象的主键
     */
    String addQuestionTypeResult(QuestionTypeResult questionTypeResult);

    /**
     * 添加一个新的问卷回答记录
     *
     * @param questionnaireResult 新的问卷回答记录
     * @return 新添加对象的主键
     */
    String addQuestionnaireResult(QuestionnaireResult questionnaireResult);

    /**
     * 添加一个新的选项回答记录
     *
     * @param choiceResult 新的问题回答记录
     */
    void addChoiceResult(ChoiceResult choiceResult);

    List<QuestionTypeResult> readResultsByModel(String parentid);
}
