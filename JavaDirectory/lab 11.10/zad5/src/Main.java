import java.util.*;

public class Main {
    public static void main(String[] args) {
        double sum=0;
        double count=5.0;
        double average;
        int grade;

        double[] arr=new double[5];
        for (int i=0; i<5; i++){
            System.out.print("Chislo: ");
            Scanner in=new Scanner(System.in);
            grade = in.nextInt();
            if (grade<2 || grade>6){
                System.out.println("Greshka");
                break;
            }
            else {
                arr[i] = grade;
            }
        }
        System.out.println(Arrays.toString(arr));

        for (int i=0; i<5; i++){
            sum+=arr[i];
        }
        average = sum/count;

        System.out.printf("Average: %f", average);
    }
}