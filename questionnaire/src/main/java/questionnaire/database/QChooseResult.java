package questionnaire.database;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Set;
import java.util.Vector;

public class QChooseResult extends QuestionTypeResult{


    private Set<ChoiceResult> results;

    public QChooseResult() {
    }

    public QChooseResult(String resultId, QuestionType modelType, QuestionnaireResult parentResult, Boolean questionType, Set<ChoiceResult> results) {
        super(resultId, modelType, parentResult, questionType);
        this.results = results;
    }

    public Set<ChoiceResult> getResults() {
        return results;
    }

    public void setResults(Set<ChoiceResult> results) {
        this.results = results;
    }
}
