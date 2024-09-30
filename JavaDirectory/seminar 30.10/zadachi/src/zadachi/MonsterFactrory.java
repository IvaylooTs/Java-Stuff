package zadachi;

import java.util.Random;

public class MonsterFactrory {
    public static Monster createMonster(Random rand){
        int monsterType = rand.nextInt(3);
        switch (monsterType) {
            case 0:
                return new Zombie();
            case 1:
                return new Vampire();
            case 2:
                return new Dragon();
            default:
                return null;
        }
    }
}
