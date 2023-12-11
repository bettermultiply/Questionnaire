package questionnaire.database;

import java.util.Set;

public class QuestionType {

    private String questionId;

    private String description;

    /**
     * if type is true then the type is text
     */
    private Boolean questionType;

    private QuestionnaireTable parentTable;

    private Set<QuestionTypeResult> results;

    /**
     * the order of the question
     */
    //it's useless now for we can add index directly in the table TODO but how can we know which choice is chosen?
//    private Integer order;

    public QuestionType() {
    }

    public QuestionType(String questionId, String description,Boolean questionType, QuestionnaireTable parentTable, Set<QuestionTypeResult> results) {
        this.questionId = questionId;
        this.questionType = questionType;
        this.description = description;
        this.parentTable = parentTable;
        this.results = results;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Boolean questionType) {
        this.questionType = questionType;
    }

    public QuestionnaireTable getParentTable() {
        return parentTable;
    }

    public void setParentTable(QuestionnaireTable parentTable) {
        this.parentTable = parentTable;
    }

    public Set<QuestionTypeResult> getResults() {
        return results;
    }

    public void setResults(Set<QuestionTypeResult> results) {
        this.results = results;
    }
}
