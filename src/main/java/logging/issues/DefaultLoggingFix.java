package logging.issues;

import java.io.OutputStream;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class DefaultLoggingFix {

	private static Logger logger = Logger.getLogger(DefaultLoggingFix.class.getName());

	static {
		for (Handler handler : java.util.logging.Logger.getLogger("").getHandlers()) {
			java.util.logging.Logger.getLogger("").removeHandler(handler);
		}

		java.util.logging.Logger.getLogger("").addHandler(new ConsoleHandler() {

			@Override
			protected synchronized void setOutputStream(OutputStream out) throws SecurityException {
				super.setOutputStream(System.out);
			}

		});
	}
	
	public static void main(String[] args) {
		//The Below line prints at INFO Level in logs after adding the static block
		
		logger.info("Test Message at INFO Level");
		
		//OUTPUT in Black in Console which mentions that it is at info level
		//Mar 13, 2018 11:22:04 AM krishna.java.util.logging.DefaultLoggingFix main
		//INFO: Test Message at INFO Level
	}

}
