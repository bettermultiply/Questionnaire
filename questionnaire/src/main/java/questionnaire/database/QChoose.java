package questionnaire.database;

import java.util.List;
import java.util.Set;
import java.util.Vector;

public class QChoose extends QuestionType{

    /**
     * multiple or single;
     */
    private Boolean chooseType;

    private List<Choice> choices;

    public QChoose() {
        super();
    }

    public QChoose(Boolean chooseType, List<Choice> choices) {
        this.chooseType = chooseType;
        this.choices = choices;
    }

    public QChoose(Integer questionId, String description, QuestionnaireTable parentTable, Set<QuestionTypeResult> results, Boolean chooseType, List<Choice> choices) {
        super(questionId, description, parentTable, results);
        this.chooseType = chooseType;
        this.choices = choices;
    }

    public Boolean getChooseType() {
        return chooseType;
    }

    public void setChooseType(Boolean chooseType) {
        this.chooseType = chooseType;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
}
