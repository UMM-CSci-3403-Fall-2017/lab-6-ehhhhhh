package echoserver;

import java.net.*;
import java.io.*;

public class EchoServer {
	public static void main(String[] args) {
		try {
			ServerSocket sock = new ServerSocket(1886);

			while (true) {
				System.out.println("Got a request!");
				Socket client = sock.accept();

				BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

				String line;
				while ((line = reader.readLine()) != null) {
					writer.println(line);
				}
			}
		} catch (IOException ioe) {
			System.err.println(ioe);
		}
	}
}
