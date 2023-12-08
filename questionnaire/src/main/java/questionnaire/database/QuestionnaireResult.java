package questionnaire.database;


import javax.persistence.criteria.CriteriaBuilder;
import java.util.Set;

public class QuestionnaireResult {

    private String resultId;

    private QuestionnaireTable parentTable;
    // many-to-one: multiple result relates to one table.
    // and many-to-many:

    private Set<QuestionTypeResult> results;

    public QuestionnaireResult() {
    }

    public QuestionnaireResult(String resultId, QuestionnaireTable parentTable, Set<QuestionTypeResult> results) {
        this.resultId = resultId;
        this.parentTable = parentTable;
        this.results = results;
    }

    public Set<QuestionTypeResult> getResults() {
        return results;
    }

    public void setResults(Set<QuestionTypeResult> results) {
        this.results = results;
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    public QuestionnaireTable getParentTable() {
        return parentTable;
    }

    public void setParentTable(QuestionnaireTable parentTable) {
        this.parentTable = parentTable;
    }
}
