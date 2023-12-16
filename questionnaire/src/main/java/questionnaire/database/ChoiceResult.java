package questionnaire.database;

/**
 * Result of Every Choice
 */
public class ChoiceResult {


    private String choiceResultId;

    private Integer cOrder;

    private Choice modelChoice;
    private QChooseResult parentChosenResult;

    public ChoiceResult() {
    }

    public ChoiceResult(String choiceResultId, Integer order, Choice modelChoice, QChooseResult parentChosenResult) {
        this.choiceResultId = choiceResultId;
        this.cOrder = order;
        this.modelChoice = modelChoice;
        this.parentChosenResult = parentChosenResult;
    }

    public Choice getModelChoice() {
        return modelChoice;
    }

    public void setModelChoice(Choice modelChoice) {
        this.modelChoice = modelChoice;
    }

    public Integer getcOrder() {
        return cOrder;
    }

    public void setcOrder(Integer cOrder) {
        this.cOrder = cOrder;
    }

    public QChooseResult getParentChosenResult() {
        return parentChosenResult;
    }

    public void setParentChosenResult(QChooseResult parentChosenResult) {
        this.parentChosenResult = parentChosenResult;
    }

    public String getChoiceResultId() {
        return choiceResultId;
    }

    public void setChoiceResultId(String choiceResultId) {
        this.choiceResultId = choiceResultId;
    }
}
