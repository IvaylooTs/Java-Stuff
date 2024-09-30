package zadachi;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int attackSum = 0;
        Random random = new Random();
        Monster[] monsters = new Monster[5];

        for (int i=0; i<5; i++){
            monsters[i] = MonsterFactrory.createMonster(random);
            attackSum += monsters[i].attack();
        }

        if (attackSum<50){
            System.out.println("Player wins!");
        }
        else {
            System.out.println("Player lose!");
        }
    }
}