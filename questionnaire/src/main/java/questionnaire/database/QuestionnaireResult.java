package questionnaire.database;


import java.util.Set;

public class QuestionnaireResult {
    private Table parentTable;
    // many-to-one: multiple result relates to one table.
    // and many-to-many:

    private Set<QMultipleChoose> multipleChooses;
    private Set<QSingleChoose> singleChooses;
    private Set<QText> texts;

    public QuestionnaireResult() {
    }

    public QuestionnaireResult(Table parentTable, Set<QMultipleChoose> multipleChooses, Set<QSingleChoose> singleChooses, Set<QText> texts) {
        this.parentTable = parentTable;
        this.multipleChooses = multipleChooses;
        this.singleChooses = singleChooses;
        this.texts = texts;
    }

    public Set<QMultipleChoose> getMultipleChooses() {
        return multipleChooses;
    }

    public void setMultipleChooses(Set<QMultipleChoose> multipleChooses) {
        this.multipleChooses = multipleChooses;
    }

    public Set<QSingleChoose> getSingleChooses() {
        return singleChooses;
    }

    public void setSingleChooses(Set<QSingleChoose> singleChooses) {
        this.singleChooses = singleChooses;
    }

    public Set<QText> getTexts() {
        return texts;
    }

    public void setTexts(Set<QText> texts) {
        this.texts = texts;
    }

    public Table getParentTable() {
        return parentTable;
    }

    public void setParentTable(Table parentTable) {
        this.parentTable = parentTable;
    }
}
