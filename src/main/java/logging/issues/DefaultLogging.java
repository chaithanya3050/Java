package logging.issues;

import java.util.logging.Logger;

public class DefaultLogging {

	private static Logger logger = Logger.getLogger(DefaultLogging.class.getName());

	public static void main(String[] args) {
		
		//The Below line prints at ERROR Level in logs even though we are using it at info level
		
		logger.info("Test Message at INFO Level");
		
		//OUTPUT in Red in Console which mentions that it is at error level
		//Mar 13, 2018 11:11:00 AM krishna.java.util.logging.DefaultLogging main
		//INFO: Test Message at INFO Level
		
	}

}
