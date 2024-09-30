package zad1;

public class Tiger extends Cat{
    public Tiger(String name) {
        super(name);
    }

    @Override
    public String talk() {

        return "rawr";
    }

    @Override
    public String move() {

        return "running";
    }



}
