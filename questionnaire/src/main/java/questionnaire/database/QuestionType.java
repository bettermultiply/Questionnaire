package questionnaire.database;

public class QuestionType {

    private Integer id;

    private String description;

    private QuestionnaireTable parentTable;

    /**
     * the order of the question
     */
    private Integer order;

    public QuestionType() {
    }

    public QuestionType(Integer id, String description, QuestionnaireTable parentTable, Integer order) {
        this.id = id;
        this.description = description;
        this.parentTable = parentTable;
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public QuestionnaireTable getParentTable() {
        return parentTable;
    }

    public void setParentTable(QuestionnaireTable parentTable) {
        this.parentTable = parentTable;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
