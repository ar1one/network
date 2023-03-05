package task1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080);
             Socket client = server.accept();
             PrintWriter out = new PrintWriter(client.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))) {

            System.out.println("New connection accepted!");
            final String name = in.readLine();

            out.println(String.format("Hi, %s, your port is %d", name, client.getPort()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}