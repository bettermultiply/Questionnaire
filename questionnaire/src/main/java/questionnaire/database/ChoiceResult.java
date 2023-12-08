package questionnaire.database;

public class ChoiceResult {


    private String choiceResultId;

    private Choice modelChoice;
    private QChooseResult parentChosenResult;

    public ChoiceResult() {
    }

    public ChoiceResult(Choice modelChoice, QChooseResult parentChosenResult, String choiceResultId) {
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

    public String getChoiceResultId() {
        return choiceResultId;
    }

    public void setChoiceResultId(String choiceResultId) {
        this.choiceResultId = choiceResultId;
    }
}
