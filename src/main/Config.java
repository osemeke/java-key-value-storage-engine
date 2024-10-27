package main;

import java.io.File;

public class Config {

	public static String BASE_PATH = "C:\\Users\\Ossy\\Videos\\LSM Trees\\projectfiles";
	public static String DIRECTORY = "testfolder";
	public static String FILE_NAME = "testfile.txt";
	public static String COMMIT_LOG_FILE = "commit.log";
	
	public static String getFullPath(String path) {
		return new File(Config.BASE_PATH, path).toString();
	}

}