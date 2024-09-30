package zad3;

import java.util.Scanner;

public class FiveStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] AllStrings = new String[5];
        for (int i=0; i<5; i++){
            AllStrings[i] = sc.next();
        }

        for (String str : AllStrings) {
            System.out.println(str);
        }

    }
}
