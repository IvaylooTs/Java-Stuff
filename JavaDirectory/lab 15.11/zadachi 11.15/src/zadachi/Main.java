package zadachi;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        FileWriter fw = null;
        PrintWriter writer = null;
        try {
            fw = new FileWriter("numbers.txt", true);
            writer = new PrintWriter(fw);
            for (int i = 0; i < 10; i++) {
                writer.println(i);
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        Scanner reader = null;
        int sum = 0;
        FileReader fr = null;
        try {
            fr = new FileReader("numbers.txt");
            reader = new Scanner(fr);
            while (reader.hasNextLine()) {
                if (reader.hasNextInt()) {
                    int num = reader.nextInt();
                    System.out.println(num);
                    sum += num;
                } else {
                    reader.nextLine();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {

            System.out.println("Sum: " + sum);
            reader.close();
            fr.close();
        }

    }
}
