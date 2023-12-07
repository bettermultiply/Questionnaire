package questionnaire.database;

public class QTextResult extends QuestionTypeResult{

    private String answer;

    public QTextResult() {
    }

    public QTextResult(Integer resultId, QuestionType modelType, QuestionnaireResult parentResult) {
        super(resultId, modelType, parentResult);
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
