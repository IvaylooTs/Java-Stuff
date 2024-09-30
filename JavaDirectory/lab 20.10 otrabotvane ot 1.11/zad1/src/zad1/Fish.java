package zad1;

public class Fish extends Animal{

    public Fish(String name){
        super(name);
    }
    @Override
    public String talk() {

        return "Baubuk";
    }

    @Override
    public String move() {

        return "Swimming";
    }
}
