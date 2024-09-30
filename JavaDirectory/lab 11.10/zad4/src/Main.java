import java.util.*;
public class Main {
    public static void main(String[] args) {
        double count = 0;
        double sum= 0;
        double average = 0;

        while(true) {

            Scanner in=new Scanner(System.in);
            int grade = in.nextInt();
            if (grade<2 || grade>6){
                break;
            }
            count++;
            sum+=grade;
            average = sum/count;

        }
        System.out.printf("Average:%f", average);

    }
}