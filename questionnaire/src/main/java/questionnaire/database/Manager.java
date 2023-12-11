package questionnaire.database;

public class Manager {
    private String id;

    private String userName;

    private String password;

    public Manager(String id, String userName, String password){
        this.id = id;
        this.userName = userName;
        this.password = password;
    }


    public Manager() {

    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Manager{" +
                "id='" + id + '\'' +
                ", username='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';

    }
}
