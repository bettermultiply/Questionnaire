package questionnaire.web.dao;

import questionnaire.database.QuestionnaireTable;

import java.util.List;

/**
 * 问卷Dao接口
 */
public interface QuestionnaireDao {
    /**
     * 根据用户的ID获取该用户发布的所有的问卷列表，包括已审核的和未审核的问卷
     *
     * @param userId 用户ID
     * @return 该用户发布的所有的问卷
     */
    List<QuestionnaireTable> getAllQuestionnaires(String userId);

    /**
     * 根据用户的ID获取该用户发布的所有已审核的问卷列表
     *
     * @param userId 用户ID
     * @return 该用户发布的所有已审核的问卷列表
     */
    List<QuestionnaireTable> getCheckedQuestionnaire(String userId);

    /**
     * 根据用户的ID获取该用户发布的所有未审核的问卷列表
     *
     * @param userId 用户ID
     * @return 该用户发布的所有未审核的问卷列表
     */
    List<QuestionnaireTable> getUncheckedQuestionnaire(String userId);

    /**
     * 根据问卷ID查询对应的问卷信息
     *
     * @param questionnaireId 问卷ID
     * @return 对应的问卷对象
     */
    QuestionnaireTable getOneQuestionnaire(String questionnaireId);

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

    /**
     * 更新问卷的信息
     *
     * @param questionnaireTable 新的问卷信息
     */
    void updateQuestionnaire(QuestionnaireTable questionnaireTable);

    /**
     * 获取所有未审核的问卷列表
     *
     * @return 所有未审核的问卷列表
     */
    List<QuestionnaireTable> readAllUncheckedQuestionnaires();
}
