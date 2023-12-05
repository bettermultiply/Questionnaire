package questionnaire.database;

public class Manager {
    private Integer id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Manager() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
