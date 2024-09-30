package zadachi;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String[] names = {"Иван Петров", "Яна Димитрова", "Росица Кирилова"};
        Invitation inv = new Invitation();
        for (int i=0; i< names.length; i++){
            System.out.println(inv.invite(names[i], "Drift event","20.11", "20:00", "IEC", "Genata"));
        }
    }
}

