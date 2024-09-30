package zad1;

public abstract class Animal {
    private String name;

    public Animal(String name){
        super();
        this.name = name;
    }
    public String getName() {

        return name;
    }
    public void setName(String name) {
        if(!name.equals(null) && !name.equals(""))
        this.name = name;
    }

    public abstract String talk();
    public abstract String move();
}
