package questionnaire.database;

public class QuestionTypeResult {

    private String resultId;

    private QuestionType modelType;

    private QuestionnaireResult parentResult;

    public QuestionTypeResult() {
    }

    public QuestionTypeResult(String resultId, QuestionType modelType, QuestionnaireResult parentResult) {
        this.resultId = resultId;
        this.modelType = modelType;
        this.parentResult = parentResult;
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
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
