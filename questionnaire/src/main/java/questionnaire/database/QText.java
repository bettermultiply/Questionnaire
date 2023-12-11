package questionnaire.database;

import java.util.Set;

public class QText extends QuestionType{

    public QText() {
    }

    public QText(String questionId, String description, Boolean questionType, QuestionnaireTable parentTable, Set<QuestionTypeResult> results) {
        super(questionId, description, questionType, parentTable, results);
    }


//TODO: should we add answer field here?
}
