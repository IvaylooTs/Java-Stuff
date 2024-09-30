package zad1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static double Divide(double a, double b){
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a/b;
    }

    public static String inputName() throws IncorrectNameException {
        Scanner in = new Scanner(System.in);
        System.out.println("Name: ");
        String name = in.nextLine();
        if (name.isEmpty()) {
            throw new IncorrectNameException("Name is not entered correctly");
        }
        return name;
    }

    public static int printStringLen(String str) {

        return str.length();
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);


        try {
            inputName();
            System.out.print("A: ");
            int a = in.nextInt();
            System.out.print("B: ");
            int b = in.nextInt();

            System.out.println(Divide(a, b));
            System.out.println(printStringLen("A string."));

        } catch (ArithmeticException err2) {
            System.out.println(err2.getMessage());
        } catch (InputMismatchException err1) {
            System.out.println("Input is string. Please type num");
        } catch (IncorrectNameException e) {
            System.out.println("Name is not entered correctly");
        } finally {
            System.out.println("Goodbye");
            in.close();
        }
    }
}