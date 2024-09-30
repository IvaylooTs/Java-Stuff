package zadacha3;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = null;
        FileReader fr = null;
        Scanner reader2 = null;
        FileReader fr2 = null;
        FileWriter fw = null;
        try {
            fr = new FileReader("Users.txt");
            fr2 = new FileReader("Users2.txt");
            fw = new FileWriter("Users3.txt", true);
            PrintWriter writer = new PrintWriter(fw);
            reader2 = new Scanner(fr2);
            reader = new Scanner(fr);
            while (reader.hasNextLine() ) {
                writer.println(reader.nextLine());
            }
            while(reader2.hasNextLine()){
                writer.println(reader2.nextLine());
            }
            writer.flush();
            fr.close();
            fr2.close();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
