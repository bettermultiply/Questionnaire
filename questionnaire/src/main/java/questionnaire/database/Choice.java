package questionnaire.database;

import java.util.Set;

/**
 * Choice of Question
 */
public class Choice {


    private String choiceId;
    /**
     * mark which QType the choice belong to;
     */

    private Integer cOrder;

    private QChoose parentQ;

    private String choiceContent;

    private Set<ChoiceResult> results;


    public Choice() {
    }


    public Choice(String choiceId, Integer order, QChoose parentQ, String choiceContent, Set<ChoiceResult> results) {
        this.choiceId = choiceId;
        this.cOrder = order;
        this.parentQ = parentQ;
        this.choiceContent = choiceContent;
        this.results = results;

    }

    public QChoose getParentQ() {
        return parentQ;
    }

    public void setParentQ(QChoose parentQ) {
        this.parentQ = parentQ;
    }

    public String getChoiceContent() {
        return choiceContent;
    }

    public void setChoiceContent(String choiceContent) {
        this.choiceContent = choiceContent;
    }

    public String getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(String choiceId) {
        this.choiceId = choiceId;
    }

    public Integer getcOrder() {
        return cOrder;
    }

    public void setcOrder(Integer cOrder) {
        this.cOrder = cOrder;
    }

    public Set<ChoiceResult> getResults() {
        return results;
    }

    public void setResults(Set<ChoiceResult> results) {
        this.results = results;
    }
}
