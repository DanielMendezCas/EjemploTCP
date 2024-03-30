package simple_tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	public Client() throws Exception{
		
		Socket socket = new Socket("localhost",2023);
		System.out.println("Conexión exitosa al servidor");
		
		BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
		
		Scanner sc = new Scanner(System.in);
		
		String mensajeSocket = inSocket.readLine();
		System.out.println("El servidor dice: " + mensajeSocket);
		
		System.out.print("Dile algo al servidor: ");
		mensajeSocket = sc.nextLine();
		
		outSocket.println(mensajeSocket);
		
		socket.close();
		System.out.println("La conexión ha finalizado.");
	}
	
	public static void main(String[] args) {
		try {
			new Client();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
