import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float result = getBMI(sc);
        ReportResults(12, result, getStatus(result));
    }
    public static float getBMI(Scanner sc){
        System.out.println("Enter height in cm: ");
        float height = (float) (sc.nextFloat() *0.394);
        System.out.println("Enter weight in kgs: ");
        float weight = (float) (sc.nextFloat() * 2.21);
        return bmiFor(height, weight);
    }
    public static void ReportResults(int SerialNum, float BMI, String status){
        System.out.format("Person with SerialNum: %d, has BMI=%.2f, and status:%s .",SerialNum, BMI, status);
    }
    public static String getStatus(float index){
        if (index<=18.5) {
            return "Underweight";
        }
        else if(index <=25) {
            return "Normal";
        }
        else if (index <=30) {
            return "Overweight";
        }
        else {
            return "Obese";
        }
    }
    public static float bmiFor(float height, float weight){
        return (weight*703)/(height*height);
    }
}