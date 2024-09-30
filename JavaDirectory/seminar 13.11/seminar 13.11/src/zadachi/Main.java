package zadachi;

import java.time.LocalDate;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Person[] people = new Person[2];
        final String filePath = "person.bin";

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath));
            Scanner sc = new Scanner(System.in);
            for (Person person : people) {
                person = new Person();
                System.out.println("Enter name: ");
                person.setName(sc.nextLine());
                System.out.println("Enter date of birth (yyyy-mm-dd): ");
                person.setDateOfBirth(LocalDate.parse(sc.nextLine()));
                person.writeExternal(out);
            }
        } catch (Exception e) {
            System.out.println("error" + e);
        }

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath));

            for (Person person:people) {
                person = new Person();
                person.readExternal(in);
                System.out.println(person);
            }

        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }
}