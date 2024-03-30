package tcp_multithread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable{
    
    private Socket socket;
    private ServerMain serverMain;
    public ServerThread(Socket socket, ServerMain serverMain){
        this.socket = socket;
        this.serverMain = serverMain;
    }
    
    @Override
    public void run(){
        try {  
        int numeroCliente = serverMain.getnumeroCliente();
            
        System.out.println("El cliente " + numeroCliente + " se ha conectado correctamente.");
            //Buffers de entrada y salida
        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        
        outSocket.println("Hola desde el servidor!");
        String mensajeCliente = inSocket.readLine();
        System.out.println("El cliente dice: " + mensajeCliente);
        
        socket.close();
        System.out.println("El cliente " + numeroCliente + " se ha desconectado.");
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
