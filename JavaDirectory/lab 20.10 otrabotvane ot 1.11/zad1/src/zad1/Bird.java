package zad1;

public class Bird extends Animal{

    public Bird(String name){
        super(name);
    }

    @Override
    public String talk() {
        return "Churulik";
    }

    @Override
    public String move() {
        return "flying";
    }
}
