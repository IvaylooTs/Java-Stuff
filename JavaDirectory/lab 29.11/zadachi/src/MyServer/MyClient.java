package MyServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
        try(Socket socket = new Socket("127.0.0.1", 8081);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(socket.getInputStream());
            Scanner input = new Scanner(System.in);
        ){
                System.out.println("Enter position");
                writer.println(input.nextLine());
                System.out.println(sc.nextLine());
                System.out.println(sc.nextLine());
                for (int i=3; i<=5; i++){
                    writer.println(input.nextLine());
                    System.out.println("Msg " + i);
                }

        }catch (Exception e){
            System.out.println("Exception = " + e);
        }
    }
}
