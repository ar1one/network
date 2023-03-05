package task2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080);
             Socket client = serverSocket.accept();
             PrintWriter out = new PrintWriter(client.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
            System.out.println("соединен клиент");

            out.println("Write your name:");
            String name = in.readLine();
            System.out.println("прочитано имя");
            out.println("Are you child? (yes/no)");
            String answer = in.readLine();
            if (answer.equals("yes")) {
                out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
            } else {
                out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!!", name));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
