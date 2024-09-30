package zad1;

public class Dog extends Animal {


    public Dog(String name) {

        super(name);
    }

    @Override
    public String talk() {

        return "Bau";
    }

    @Override
    public String move() {

        return "Walking";
    }
}
