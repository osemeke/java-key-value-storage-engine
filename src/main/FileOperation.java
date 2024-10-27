package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.LinkedList;

import main.Config;

public class FileOperation {
	
	// commit log write and read
	
	public void writeCommitLog(LinkedList<Node> list) {
		try {
			FileOutputStream fout = new FileOutputStream(Config.getFullPath(Config.COMMIT_LOG_FILE));
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(list);
            out.close();
            fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public LinkedList<Node> loadCommitLog() {
		LinkedList<Node> list = new LinkedList<Node>();
		try {
			FileInputStream fin = new FileInputStream(Config.getFullPath(Config.COMMIT_LOG_FILE));
			ObjectInputStream in = new ObjectInputStream(fin);
			list = (LinkedList<Node>) in.readObject();
            in.close();
            fin.close();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// directory and file creation
	
	public void createFolder(String path) {		
		File d = new File(Config.getFullPath(path));
		if (!d.exists()){
		    d.mkdirs();
		}	
	}

	public void createFile(String path) {
		File f = new File(Config.getFullPath(path));
		// f.getParentFile().mkdirs(); 
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
