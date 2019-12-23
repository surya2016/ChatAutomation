package app.chatroom.utility;

import java.util.logging.Logger;

public class Log {

	private static Logger reportLog = Logger.getLogger("reportsLog");
	
	// This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite
	public static void startTestCase() {
		reportLog.info("########################################################################################");
		reportLog.info("##Test Case "+Constants.class_Name+" starts");
		reportLog.info("########################################################################################");
	}
	
	 //This is to print log for the ending of the test case
	public static void endTestCase() {
		reportLog.info("########################################################################################");
		reportLog.info("##Test Case "+Constants.class_Name+" ends");
		reportLog.info("########################################################################################");
	 }
	public static void info(String message) {
		reportLog.info(message);
	}
	
	public static void info(String class_Name, String message) {
		reportLog.info(class_Name+" : "+message);
	}
}
