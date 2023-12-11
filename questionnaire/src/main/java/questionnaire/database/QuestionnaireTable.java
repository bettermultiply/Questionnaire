package questionnaire.database;

import java.util.List;
import java.util.Set;

public class QuestionnaireTable {

    private String tableId;

    private String tableName;

    /**
     * to show whether the table has been checked by the manager
     */
    private Boolean isChecked;

    private Boolean isPublished;

    /**
     * which commonUser the table belongs to;
     */
    private CommonUser user;

    private Set<QuestionnaireResult> results;

    /**
     * TODO we've set the order field maybe the Set structure is better?
     */
    private List<QuestionType> questions;

    public QuestionnaireTable() {
    }

    public QuestionnaireTable(String tableId, String tableName, Boolean isChecked, Boolean isPublished, CommonUser user, Set<QuestionnaireResult> results, List<QuestionType> questions) {
        this.tableId = tableId;
        this.tableName = tableName;
        this.isChecked = isChecked;
        this.isPublished = isPublished;
        this.user = user;
        this.results = results;
        this.questions = questions;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public Boolean getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(Boolean published) {
        isPublished = published;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Boolean isChecked) {
        this.isChecked = isChecked;
    }

    public CommonUser getUser() {
        return user;
    }

    public void setUser(CommonUser user) {
        this.user = user;
    }

    public Set<QuestionnaireResult> getResults() {
        return results;
    }

    public void setResults(Set<QuestionnaireResult> results) {
        this.results = results;
    }

    public List<QuestionType> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionType> questions) {
        this.questions = questions;
    }
}
