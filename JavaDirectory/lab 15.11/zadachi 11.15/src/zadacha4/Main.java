package zadacha4;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        try (Scanner firstFile = new Scanner(new FileReader("subscribed.txt"));
             Scanner secondFile = new Scanner(new FileReader("unsubscribed.txt"));
             PrintWriter pw = new PrintWriter(new FileWriter("filtered.txt"));
        ) {
            while (firstFile.hasNext()) {
                list.add(firstFile.nextLine());
            }
            while (secondFile.hasNext()){
                list.remove(secondFile.nextLine());
            }
            pw.print(list);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
