package tcp_multithread;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    
    public ServerMain() throws Exception{
        
        ServerSocket serverSocket = new ServerSocket(2022);
        System.out.println("El puerto 2022 se ha abierto correctamente.");
        
        while(true){
            Socket socket = serverSocket.accept();
            ServerThread serverThread = new ServerThread(socket, this);
            Thread thread = new Thread(serverThread);
            thread.start(); 
        }
        
    }
    
    private int numeroCliente = 1;
    
    public int getnumeroCliente(){
        return numeroCliente++;
    }
    
    public static void main(String[] args) {
        try {
            new ServerMain();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
