package MyServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class ServerThread extends Thread {
    private Socket socket;
    private static final Random rand = new Random();

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner sc = new Scanner(socket.getInputStream())) {
            out.println("Hello from Server");
            String line = sc.nextLine();
            if (line.equalsIgnoreCase("student")) {
                out.println("grade = " + generateRandomGrade());
            } else if (line.equalsIgnoreCase("teacher")) {
                out.println("salary = " + generateRandomSalary());
            }
            else{
                out.println("Unknown position");
            }
            System.out.println(line);
        } catch (Exception e) {
            System.out.println("Exception = " + e);
        }
    }

    private static double generateRandomSalary(){
        return Math.round(rand.nextInt(5000 - 1000) + 1000.0);
    }


    private static int generateRandomGrade() {
        return rand.nextInt(6 - 2) + 2;
    }
}




