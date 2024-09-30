package impletemters;

import impletemters.Talkable;

public class Duck implements Talkable {

    @Override
    public String talk() {
        return "Quack";
    }
}
