package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import common.Config;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(Config.PORT);
		Socket s = ss.accept();
		// System.out.println("connected!");

		InputStreamReader in = new InputStreamReader(s.getInputStream());
		BufferedReader bf = new BufferedReader(in);

		String input = bf.readLine();
		
		KeyValueStore store = new KeyValueStore();
		Command command = resolveCommand(input);

		switch (command.action) {
		case "set" -> store.put(command.key, command.value);
		case "get" -> store.read(command.key);
		case "del" -> store.delete(command.key);
		};


	}

	private static Command resolveCommand(String input) {
		// TODO Auto-generated method stub
		return new Command();
	}

}