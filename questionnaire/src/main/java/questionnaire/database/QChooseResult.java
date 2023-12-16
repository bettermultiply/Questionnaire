package questionnaire.database;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Set;
import java.util.Vector;

/**
 * Result of Choose Question
 */
public class QChooseResult extends QuestionTypeResult{


    private Set<ChoiceResult> results;

    public QChooseResult() {
    }

    public QChooseResult(String resultId, Boolean questionType, QuestionType modelType, Integer questionOrder, QuestionnaireResult parentResult, Set<ChoiceResult> results) {
        super(resultId, questionType, modelType, questionOrder, parentResult);
        this.results = results;
    }

    public Set<ChoiceResult> getResults() {
        return results;
    }

    public void setResults(Set<ChoiceResult> results) {
        this.results = results;
    }
}
