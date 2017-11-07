import java.net.*;
import java.io.*;

package echoserver;

public class EchoClient {
	public static void main(String[] args) {
		
		hostname = args[0];

		try {
			Socket socket = new Socket("localhost", 1886);

			InputStream input = socket.getInputStream();
			OutputStream output = socket.getOutputStream();

			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}

			socket.close();
		} catch (IOException ioe) {
			System.out.println("We caught an IOException");
			System.err.println(ioe);
		}
	}
}
