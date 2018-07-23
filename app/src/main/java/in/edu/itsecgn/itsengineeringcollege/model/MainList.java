package in.edu.itsecgn.itsengineeringcollege.model;

public class MainList {



    int id;
    private String name;
    private int image;

    public MainList(int id, String name) {
        this.id = id;
        this.name = name;
    }




    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
