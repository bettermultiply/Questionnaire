package questionnaire.database;

import java.util.Set;

public class QuestionnaireTable {

    private Integer tableId;

    private String tableName;

    /**
     * to show whether the table has been checked by the manager
     */
    private Boolean isChecked;

    /**
     * which commonUser the table belongs to;
     */
    private CommonUser User;

    private Set<QuestionnaireResult> results;

    /**
     * TODO we've set the order field maybe the Set structure is better?
     */
    private Set<QuestionType> questions;

}
