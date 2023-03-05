package task2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket client = new Socket("netology.homework", 8080);
             PrintWriter out = new PrintWriter(client.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
            Scanner scanner = new Scanner(System.in);

            System.out.println(in.readLine());
            String name = scanner.next();
            out.println(name);

            System.out.println(in.readLine());
            String answer = scanner.next();
            out.println(answer);

            System.out.println(in.readLine());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
