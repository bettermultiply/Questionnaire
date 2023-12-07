package questionnaire.database;

import java.util.Vector;

public class QChoose extends QuestionType{

    private Integer qChooseId;

    private String description;

    /**
     * multiple or single;
     */
    private Boolean chooseType;



    private Vector<Choice> choices;

    public QChoose() {
        super();
    }

    public QChoose(Integer id, String description, QuestionnaireTable parentTable, Integer order, Integer qChooseId, String description1, Boolean chooseType, Vector<Choice> choices) {
        super(id, description, parentTable, order);
        this.qChooseId = qChooseId;
        this.description = description1;
        this.chooseType = chooseType;
        this.choices = choices;
    }
}
