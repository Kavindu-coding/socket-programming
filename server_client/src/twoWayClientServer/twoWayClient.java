package twoWayClientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class twoWayClient {
    static int PORT = 9999;

    public static void main(String[] args) throws IOException {

        System.out.println("=======Simple client======");

        InetAddress ip_address = InetAddress.getLocalHost();
        Socket socket = new Socket(ip_address, PORT);
        System.out.println("Server connected.....");

        BufferedReader in = null;
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scan = new Scanner(System.in);

            String msg = in.readLine();
            System.out.println("Server says : " + msg);

            // Chat loop
            while (true) {
                // Send message to server
                System.out.print("Me: ");
                String input = scan.nextLine();
                out.println(input);

                // Receive and print message from the server
                String serverMessage = in.readLine();
                System.out.println("Server: " + serverMessage);
            }
        } finally {
            socket.close();
//            in.close();
        }
    }
}
