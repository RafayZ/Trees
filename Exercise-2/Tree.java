package ex2;

//basic Tree implementation for all the trees
public class Tree {
    private String location;
    private String name;
    private String age;
    private double height;


    //constructor instantiating different variables
    public Tree(String location, String name, String age, double height){
        this.location = location;
        this.name = name;
        this.age = age;
        this.height = height;
    }


    //Getter methods for all the variables
    public String getLocation(){
        return location;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }
}
