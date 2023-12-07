package questionnaire.database;


import java.util.Set;

public class QuestionnaireResult {

    private QuestionnaireTable parentTable;
    // many-to-one: multiple result relates to one table.
    // and many-to-many:

    private Set<QuestionType> results;

    public QuestionnaireResult() {
    }

    public QuestionnaireResult(QuestionnaireTable parentTable, Set<QuestionType> multipleChooses) {
        this.parentTable = parentTable;
        this.results = multipleChooses;
    }

    public Set<QuestionType> getChooses() {
        return results;
    }

    public void setChooses(Set<QuestionType> results) {
        this.results = results;
    }


    public QuestionnaireTable getParentTable() {
        return parentTable;
    }

    public void setParentTable(QuestionnaireTable parentTable) {
        this.parentTable = parentTable;
    }
}
