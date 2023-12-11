package questionnaire.database;

public class QTextResult extends QuestionTypeResult{

    private String answer;

    public QTextResult() {
    }

    public QTextResult(String resultId, QuestionType modelType, QuestionnaireResult parentResult, Boolean questionType, String answer) {
        super(resultId, modelType, parentResult, questionType);
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
