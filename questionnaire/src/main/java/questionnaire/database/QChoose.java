package questionnaire.database;

import java.util.List;
import java.util.Set;
import java.util.Vector;

public class QChoose extends QuestionType{

    /**
     * multiple or single;
     */
    private Boolean chooseType;

    private Set<Choice> choices;

    public QChoose() {
        super();
    }

    public QChoose(Boolean chooseType, Set<Choice> choices) {
        this.chooseType = chooseType;
        this.choices = choices;
    }

    public QChoose(String questionId, String description, Boolean questionType, QuestionnaireTable parentTable, Set<QuestionTypeResult> results, Boolean chooseType, Set<Choice> choices) {
        super(questionId, description, questionType, parentTable, results);
        this.chooseType = chooseType;
        this.choices = choices;
    }

    public Boolean getChooseType() {
        return chooseType;
    }

    public void setChooseType(Boolean chooseType) {
        this.chooseType = chooseType;
    }

    public Set<Choice> getChoices() {
        return choices;
    }

    public void setChoices(Set<Choice> choices) {
        this.choices = choices;
    }
}
