package simple_tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    
    public Server() throws Exception{
        ServerSocket serverSocket = new ServerSocket(2023); // abriendo un nuevo puerto
        System.out.println("El puerto 2023 se ha abierto");
        
        Socket socket = serverSocket.accept();
        System.out.println("El cliente " + socket.getInetAddress() + " se ha conectado correctamente");
        
        //Buffers de entrada y salida
        
        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        
        outSocket.println("Hola desde el servidor!");
        String mensajeCliente = inSocket.readLine();
        System.out.println("El cliente dice: " + mensajeCliente);
        
        serverSocket.close();
        System.out.println("La conexión ha finalizado.");
    }
    
    public static void main(String [] args){
        try {
            new Server();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
}
