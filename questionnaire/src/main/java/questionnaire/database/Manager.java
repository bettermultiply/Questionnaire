package questionnaire.database;

/**
 * System manager
 */
public class Manager {
    private String id;

    private String firstName;

    private String lastName;

    private String phoneNo;

    private String email;

    private String userName;

    private String password;

    public Manager(String id, String userName, String password){
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public Manager(String id, String firstName, String lastName, String phoneNo, String email, String userName, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.email = email;
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

    @Override
    public String toString() {
        return "Manager{" +
                "id='" + id + '\'' +
                ", username='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';

    }
}
