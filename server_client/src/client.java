import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class client {
    static int PORT = 9999;

    public static void main(String[] args) throws IOException {

        System.out.println("=======Simple client======");

        InetAddress ip_address = InetAddress.getLocalHost();

        Socket socket = new Socket(ip_address, PORT);

        System.out.println("Server connected.....");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String msg = in.readLine();

        System.out.println("Server says : " + msg);

        socket.close();
        in.close();

    }
}
