import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
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
                    out.println("Welcome to chat application");
                } finally {
                    socket.close();
                }
            }
        } finally {
            server_socket.close();
        }
    }

}

