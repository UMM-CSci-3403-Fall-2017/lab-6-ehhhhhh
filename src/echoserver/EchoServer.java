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

				InputStreamReader reader = new InputStreamReader(client.getInputStream());
				OutputStreamWriter writer = new OutputStreamWriter(client.getOutputStream());

				int line;
				while (true) {
					line = reader.read();
					writer.write(line);
				}
			}
		} catch (IOException ioe) {
			System.err.println(ioe);
		}
	}
}
