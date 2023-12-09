package questionnaire.web.dao;

import questionnaire.database.QuestionnaireTable;

import java.util.List;

public interface QuestionnaireDao {
    /**
     * 根据用户的ID获取该用户发布的所有的问卷列表，包括已审核的和未审核的问卷
     *
     * @return 该用户发布的所有的问卷
     */
    List<QuestionnaireTable> getAllQuestionnaires(String userId);

    /**
     * 根据问卷的ID删除对应的问卷
     *
     * @param questionnaireId 被删除的问卷的ID
     */
    void deleteQuestionnaire(String questionnaireId);

    /**
     * 添加新的问卷
     *
     * @param questionnaireTable 新增的问卷
     * @return 新增问卷的ID
     */
    String addQuestionnaire(QuestionnaireTable questionnaireTable);

}
