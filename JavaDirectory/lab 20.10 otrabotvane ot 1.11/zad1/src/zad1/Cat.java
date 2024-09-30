package zad1;

public class Cat extends Animal{

    public Cat(String name) {

        super(name);
    }

    @Override
    public String talk() {

        return "meow";
    }

    @Override
    public String move() {

        return "Walking now";
    }
}
