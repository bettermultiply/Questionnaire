package questionnaire.database;

/**
 * Result of Question
 */
public class QuestionTypeResult {

    private String resultId;

    /**
     * if type is true then the type is text
     */
    private Boolean questionType;

    private QuestionType modelType;

    private Integer questionOrder;

    private QuestionnaireResult parentResult;

    public QuestionTypeResult() {
    }

    public QuestionTypeResult(String resultId, Boolean questionType, QuestionType modelType, Integer questionOrder, QuestionnaireResult parentResult) {
        this.resultId = resultId;
        this.questionType = questionType;
        this.modelType = modelType;
        this.questionOrder = questionOrder;
        this.parentResult = parentResult;
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    public Boolean getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Boolean questionType) {
        this.questionType = questionType;
    }

    public QuestionType getModelType() {
        return modelType;
    }

    public void setModelType(QuestionType modelType) {
        this.modelType = modelType;
    }

    public QuestionnaireResult getParentResult() {
        return parentResult;
    }

    public void setParentResult(QuestionnaireResult parentResult) {
        this.parentResult = parentResult;
    }

    public Integer getQuestionOrder() {
        return questionOrder;
    }

    public void setQuestionOrder(Integer questionOrder) {
        this.questionOrder = questionOrder;
    }
}
