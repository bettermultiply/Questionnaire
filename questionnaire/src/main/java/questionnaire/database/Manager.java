package questionnaire.database;

public class Manager {
    private String id;
<<<<<<< HEAD
    private String userName;

    private String password;

    public Manager(String id, String userName, String password){
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
=======
    private String username;
    private String password;
>>>>>>> d1bd3ef087b94cdf193946a391948fce7a016779

    public Manager() {

    }
    public Manager(String id, String username,String password){
        this.id = id;
        this.username = username;
        this.password=password;
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

<<<<<<< HEAD
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
=======
    @Override
    public String toString() {
        return "Manager{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
>>>>>>> d1bd3ef087b94cdf193946a391948fce7a016779
    }
}
