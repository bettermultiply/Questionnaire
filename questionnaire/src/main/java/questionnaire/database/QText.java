package questionnaire.database;

import java.util.Set;

/**
 * Text Question
 */
public class QText extends QuestionType{

    public QText() {
    }

    public QText(String questionId, String description, Boolean questionType, QuestionnaireTable parentTable, Integer questionOrder, Set<QuestionTypeResult> results) {
        super(questionId, description, questionType, parentTable, questionOrder, results);
    }

//TODO: should we add answer field here?
}
