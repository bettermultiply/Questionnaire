package questionnaire.database;

/**
 * Result of Text Question
 */
public class QTextResult extends QuestionTypeResult{

    private String answer;

    public QTextResult() {
    }

    public QTextResult(String resultId, Boolean questionType, QuestionType modelType, Integer questionOrder, QuestionnaireResult parentResult, String answer) {
        super(resultId, questionType, modelType, questionOrder, parentResult);
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
