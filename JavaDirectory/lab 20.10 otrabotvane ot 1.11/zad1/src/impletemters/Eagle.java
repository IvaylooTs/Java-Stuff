package impletemters;

public class Eagle implements Talkable, Movable {

    @Override
    public String talk() {
        return "Piu";
    }
    @Override
    public String move(){
        return "Flying";
    }
}
