package client;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import common.Config;

public class Client {

	public static void main(String[] args) throws IOException {
		Socket s = new Socket(Config.SERVER, Config.PORT);
		
		PrintWriter pr = new PrintWriter(s.getOutputStream());
		pr.println("set 30 'test data'");
		pr.flush();
	}

}