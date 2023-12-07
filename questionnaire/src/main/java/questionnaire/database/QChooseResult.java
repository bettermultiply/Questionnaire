package questionnaire.database;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Set;
import java.util.Vector;

public class QChooseResult{

    private Integer chooseResultId;

//    private QChoose parentQ;

    private Set<ChosenResult> chosenOrders;

    public QChooseResult() {
    }

    public Set<ChosenResult> getChosenOrders() {
        return chosenOrders;
    }

    public void setChosenOrders(Set<ChosenResult> chosenOrders) {
        this.chosenOrders = chosenOrders;
    }

    public Integer getChooseResultId() {
        return chooseResultId;
    }

    public void setChooseResultId(Integer chooseResultId) {
        this.chooseResultId = chooseResultId;
    }

//    public QChoose getParentQ() {
//        return parentQ;
//    }
//
//    public void setParentQ(QChoose parentQ) {
//        this.parentQ = parentQ;
//    }

}
