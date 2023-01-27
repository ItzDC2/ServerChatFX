package threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class LeerThread extends Thread {

	private InputStream is;
	
	public LeerThread(InputStream is) {
		if(is == null)
			throw new NullPointerException();
		this.is = is;
	}
	
	@Override
	public void run() {
		String linea;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(is,Charset.forName("UTF8")))) {
			linea = reader.readLine();
			while(linea != null && !linea.isEmpty()) {
				System.out.println("-> " + linea);
				linea = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
