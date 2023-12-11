package questionnaire.database;

public class QuestionTypeResult {

    private String resultId;

    /**
     * if type is true then the type is text
     */
    private Boolean questionType;

    private QuestionType modelType;

    private QuestionnaireResult parentResult;

    public QuestionTypeResult() {
    }

    public QuestionTypeResult(String resultId, QuestionType modelType, QuestionnaireResult parentResult, Boolean questionType) {
        this.resultId = resultId;
        this.modelType = modelType;
        this.parentResult = parentResult;
        this.questionType = questionType;
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
}
