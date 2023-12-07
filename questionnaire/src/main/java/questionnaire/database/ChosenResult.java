package questionnaire.database;

import javax.persistence.criteria.CriteriaBuilder;

public class ChosenResult {

    private Integer orders;
    private QChooseResult parentChosenResult;

    public ChosenResult() {
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public QChooseResult getParentChosenResult() {
        return parentChosenResult;
    }

    public void setParentChosenResult(QChooseResult parentChosenResult) {
        this.parentChosenResult = parentChosenResult;
    }
}
