package common;

import java.io.File;

public class Config {

	public static String SERVER = "localhost";
	public static int PORT = 3000;

	public static String BASE_PATH = "C:\\Users\\Ossy\\Videos\\LSM Trees\\projectfiles";
	public static String DIRECTORY = "testfolder";

	public static String COMMIT_LOG_FILE = "commit2.log";
	public static long MAXIMUM_RANDOM_ACCESS_MEMORY = 5;
	public static long MAXIMUM_LSM_LEVELS = 3;
	public static long MAXIMUM_LSM_SEGMENTS = 1; // =1 is leveling (eager), and >1 is tiering (lazy)
	
	public static String getFullPath(String path) {
		return new File(Config.BASE_PATH, path).toString();
	}

}