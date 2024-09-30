package Zadacha2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        User user1 = new User("abv@gmail.com", "088888888");
        User user2 = new User("gmt@gmail.com", "088345355");
        User user3 = new User("12b@gmail.com", "084325842");
        User user4 = new User("a09@gmail.com", "082432522");
        User[] userArray = {user1, user2, user3, user4};

        try (FileWriter fw = new FileWriter("Users2.txt", true);
             PrintWriter writer=new PrintWriter(fw)){
            for (int i = 0; i<4; i++){
                writer.println(userArray[i].toString());
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}


