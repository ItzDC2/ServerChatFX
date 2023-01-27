package threads;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Scanner;

public class EscribirThread extends Thread {
	
	private Scanner in;
	private String linea;
	private OutputStream os;
	
	public EscribirThread(OutputStream os) {
		if(os == null)
			throw new NullPointerException();
		this.in = new Scanner(System.in);
		this.os = os;
	}
	
	@Override
	public void run() { 
		try (PrintWriter salida = new PrintWriter(os, true, Charset.forName("UTF-8"))) {
			while(!(linea = in.nextLine()).equals(":bye")) {
				salida.println(linea);
				System.out.println("Tu: " + linea);
			}
			
			System.out.println("Has salido del chat.");
			in.close();
		}
	}
	
}
