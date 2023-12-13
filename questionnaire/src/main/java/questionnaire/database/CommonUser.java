package questionnaire.database;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CommonUser {

    private String userId;

    private String firstName;

    private String lastName;

    private String phoneNo;

    private String email;

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

    public CommonUser(String userId, String firstName, String lastName, String phoneNo, String email, String userName, String password, Set<QuestionnaireTable> questionnaireTables) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.questionnaireTables = questionnaireTables;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
