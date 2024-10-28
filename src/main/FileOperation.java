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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

import common.Config;

public class FileOperation {
	
	// commit log write and read
	
	public void writeCommitLog(LinkedList<Node> list) {
		String file = Config.getFullPath(Config.COMMIT_LOG_FILE);
		createIfNotExist(file);
		try {
			FileOutputStream fout = new FileOutputStream(file);
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
		String file = Config.getFullPath(Config.COMMIT_LOG_FILE);
		createIfNotExist(file);
		if (fileIsEmpty(Config.COMMIT_LOG_FILE)) return list;
		try {
			FileInputStream fin = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fin);
			list = (LinkedList<Node>) in.readObject();
            in.close();
            fin.close();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	private boolean fileIsEmpty(String file) {
		File f = new File(Config.getFullPath(file));
		if (f.length() == 0) return true;	
		return false;
	}

	private void createIfNotExist(String file) {
		File f = new File(file);
		if (f.exists()) return;
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	public long getFileSize(String path) {
		long size = 0L;
		Path p = Paths.get(Config.getFullPath(path));		
		try {
			size = Files.size(p);
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return size;
	}
	

}
