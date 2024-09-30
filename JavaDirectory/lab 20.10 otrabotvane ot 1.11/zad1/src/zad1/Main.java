package zad1;

import impletemters.Duck;
import impletemters.Eagle;

public class Main {
    public static void main(String[] args) {

        Cat myFirstCat = new Cat("Max");
        Dog myFirstDog = new Dog("Java");
        Fish myFirstFish = new Fish("Toshko");
        Bird myFirstBird = new Bird("Pepi");
        Tiger myFirstTiger = new Tiger("George");
        Duck myFirstDuck = new Duck();
        Eagle myFirstEagle = new Eagle();


        Animal[] animalsArr = {myFirstBird, myFirstCat, myFirstDog, myFirstFish, myFirstTiger};

        for (int i=0; i<animalsArr.length; i++){
            System.out.println(animalsArr[i].getName() + " is " + animalsArr[i].move() + " " + animalsArr[i].talk());
        }

        System.out.println("Duck can:" + myFirstDuck.talk());
        System.out.println("Eagle can:" + myFirstDuck.talk() + " and " + myFirstEagle.move());
    }
}