package questionnaire.database;

public class ChoiceResult {


    private Integer choiceResultId;

    private Choice modelChoice;
    private QChooseResult parentChosenResult;

    public ChoiceResult() {
    }

    public ChoiceResult(Choice modelChoice, QChooseResult parentChosenResult, Integer choiceResultId) {
        this.modelChoice = modelChoice;
        this.parentChosenResult = parentChosenResult;
        this.choiceResultId = choiceResultId;
    }

    public Choice getModelChoice() {
        return modelChoice;
    }

    public void setModelChoice(Choice modelChoice) {
        this.modelChoice = modelChoice;
    }

    public QChooseResult getParentChosenResult() {
        return parentChosenResult;
    }

    public void setParentChosenResult(QChooseResult parentChosenResult) {
        this.parentChosenResult = parentChosenResult;
    }

    public Integer getChoiceResultId() {
        return choiceResultId;
    }

    public void setChoiceResultId(Integer choiceResultId) {
        this.choiceResultId = choiceResultId;
    }
}
