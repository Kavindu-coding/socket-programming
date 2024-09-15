package multi_client_server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServer {
   private  ServerSocket serverSocket;

    public MultiThreadedServer(ServerSocket serversocket) {
        this.serverSocket = serversocket;
    }

    public void startServer(){
        try{
          while(!serverSocket.isClosed()){

              Socket socket = serverSocket.accept();
              System.out.println("A new cliet has connected");
              ClientHandler clientHandler = new ClientHandler(socket);

              Thread thread = new Thread(clientHandler);
              thread.start();
          }
        } catch (IOException e){

        }
    }
    public void closeServerSocket(){
        try {
            if(serverSocket != null){
                serverSocket.close();
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        MultiThreadedServer server = new MultiThreadedServer(serverSocket);
        server.startServer();
    }

}

