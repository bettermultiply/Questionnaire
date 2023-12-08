package questionnaire.database;

public class Manager {
    private String id;
    private String username;

    public Manager(String id, String userName){
        this.id = id;
        this.username = userName;
    }

    public Manager() {

    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String name) {
        this.username = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
