package MyServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class MyServer {
    public static void main(String[] args) {
            try (ServerSocket server = new ServerSocket(8081)) {
                while (true) {
                    System.out.println("Server is waiting for clients.");
                    Socket socket = server.accept();
                    ServerThread client = new ServerThread(socket);
                    client.start();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

