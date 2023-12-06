package questionnaire.database;

public class Manager {
    private Integer id;
    private String username;

    public Manager(Integer id, String userName){
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
