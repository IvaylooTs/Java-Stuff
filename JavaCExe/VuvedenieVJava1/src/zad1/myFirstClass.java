package zad1;

import java.util.Scanner;

public class myFirstClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int years = sc.nextInt();
        String birth = sc.next();

        System.out.println(name);
        System.out.println(years);
        System.out.println(birth);

    }
}