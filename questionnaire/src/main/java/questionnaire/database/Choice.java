package questionnaire.database;

import java.util.Set;

public class Choice {


    private Integer choiceId;
    /**
     * mark which QType the choice belong to;
     */
    private QChoose parentQ;

    private String choiceContent;

    private Set<ChoiceResult> results;


    public Choice() {
    }

    public Choice(QChoose parentQ, String choiceContent, Integer choiceId) {
        this.parentQ = parentQ;
        this.choiceContent = choiceContent;
        this.choiceId = choiceId;
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

    public Integer getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(Integer choiceId) {
        this.choiceId = choiceId;
    }

    public Set<ChoiceResult> getResults() {
        return results;
    }

    public void setResults(Set<ChoiceResult> results) {
        this.results = results;
    }
}
