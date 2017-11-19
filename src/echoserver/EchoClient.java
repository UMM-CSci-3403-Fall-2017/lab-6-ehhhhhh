package echoserver;

import java.net.*;
import java.io.*;


public class EchoClient {
	public static void main(String[] args) {
		
		//The tests cause an indexOutOfBoundsException here for some reason
		//String hostname = args[0];

		try {
			Socket socket = new Socket("localhost", 1886);

			//Grab inputStream and outputStream
			InputStream input = socket.getInputStream();
			OutputStream output = socket.getOutputStream();


			//Create writer and reader for the streams
			InputStreamReader reader = new InputStreamReader(input);
			OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());

			int line;
			while (true) {
				//Prints every byte read frm the inputStream, prints nothing if there is nothing to print
				
					line = reader.read();
					System.out.print(line);
			}

		} catch (IOException ioe) {
			System.out.println("We caught an IOException");
			System.err.println(ioe);
		}
	}
}
