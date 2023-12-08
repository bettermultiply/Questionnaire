package questionnaire.database;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CommonUser {

    private String userId;

    private String userName;

    private String password;

    private Set<QuestionnaireTable> questionnaireTables;

    public CommonUser() {
    }

    public CommonUser(String id, String userName, String password, Set<QuestionnaireTable> tables) {
        this.userId = id;
        this.userName = userName;
        this.password = password;
        this.questionnaireTables = tables;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<QuestionnaireTable> getQuestionnaireTables() {
        return questionnaireTables;
    }

    public void setQuestionnaireTables(Set<QuestionnaireTable> questionnaireTables) {
        this.questionnaireTables = questionnaireTables;
    }
}
