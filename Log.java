package utility;

import org.apache.log4j.Logger;

public class Log {

	private static Logger log = Logger.getLogger("devpinoyLogger");

	// CONSTRUCTOR
	private Log() {
		// private constructor: no creation of instance is allowed
	}

	/**
	 * Returns the singleton logger object
	 * 
	 * @return
	 */
	public static Logger getLogger() {
		return log;
	}

	/**
	 * Performs DEBUG log
	 * @param message
	 */
	public static void D(String message) {
		log.debug(message);
	}
}
