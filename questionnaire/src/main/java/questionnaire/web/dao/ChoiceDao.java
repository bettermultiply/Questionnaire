package questionnaire.web.dao;

import questionnaire.database.Choice;

public interface ChoiceDao {
    /**
     * 添加选项
     *
     * @param choice 新选项
     */
    void addChoice(Choice choice);

    /**
     * 删除选项
     *
     * @param choiceId 被删除的选项ID
     */
    void deleteChoice(String choiceId);

    /**
     * 根据ID获取到一个选项
     *
     * @param choiceId 选项ID
     */
    Choice readOneChoice(String choiceId);

    /**
     * 修改选项
     *
     * @param choice 新选项
     */
    void updateChoice(Choice choice);
}
