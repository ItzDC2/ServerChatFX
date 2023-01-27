package iesdomingoperezminik.es;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import threads.EscribirThread;
import threads.LeerThread;

public class Cliente {

	private static String host="192.168.1.165";
	private static int puerto=50555;
	
	public static void main(String[] args) {
		OutputStream os;
		InputStream is;
		
		try (Socket socket = new Socket(host, puerto)) {
			System.out.println("Conectado.");
			
			os = socket.getOutputStream();
			is = socket.getInputStream();
			
			new EscribirThread(os).start();
			new LeerThread(is).start();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
}
