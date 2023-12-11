package questionnaire.database;

import java.util.Set;

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

<<<<<<< HEAD
    public Choice(String choiceId, Integer order, QChoose parentQ, String choiceContent, Set<ChoiceResult> results) {
        this.choiceId = choiceId;
        this.cOrder = order;
        this.parentQ = parentQ;
        this.choiceContent = choiceContent;
        this.results = results;
=======
    public Choice(String choiceId, QChoose parentQ, String choiceContent) {
        this.choiceId = choiceId;
        this.parentQ = parentQ;
        this.choiceContent = choiceContent;
>>>>>>> d1bd3ef087b94cdf193946a391948fce7a016779
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
