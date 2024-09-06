package twoWayClientServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class twoWayServer {
    static int PORT = 9999;

    public static void main(String[] args) throws IOException {

        System.out.println("=======Simple Socket Server======");
        ServerSocket server_socket = new ServerSocket(PORT);

        try {
            while(true) {
                //Listen to incoming connection
                Socket socket = server_socket.accept();
                System.out.println("A client connected......");

                try {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    Scanner scan = new Scanner(System.in);


                    out.println("Welcome to chat application");

                    while(true){
                        //read from client
                        String msg = in.readLine();
                        System.out.println("Client says : " + msg);

                        //write to client
                        System.out.println("Me : " + msg);
                        String input = scan.nextLine();
                        out.println(input);
                    }
                } finally {
                    socket.close();
                }
            }
        } finally {
            server_socket.close();
        }
    }
}
