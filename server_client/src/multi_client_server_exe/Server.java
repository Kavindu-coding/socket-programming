package multi_client_server_exe;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static int PORT = 9999;

    public static void main(String[] args) throws IOException {

        System.out.println("=======Simple Socket Server======");

        ServerSocket server_socket = new ServerSocket(PORT);
        int current_clients = 0;

        try {
            while(true) {
                //Listen to incoming connection
                Socket client = server_socket.accept();
                System.out.println("A client connected......");

                Server_Thread ct = new Server_Thread(client, current_clients+1);
                ct.start();
                current_clients++;
            }
        } finally {
            server_socket.close();
        }
    }

}

