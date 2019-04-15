package utility;

/*----------------------------------------------------------------*
 * This class contains run-time configurations for the test run.  *
 * Configuration item includes, email configurations such as      *
 * who is the sender, list of recipient of the email, and its     *
 * message header, and email message body.                        *
 *                                                                *
 * It also contains Database connectivity configurations that are * 
 * used on rum-time for connecting database and test.             *
 *----------------------------------------------------------------*/
public class TestConfig {
	// GMAIL is our mailing tool since using outlook is too complicated
	public static String server = "smtp.gmail.com";
	public static String from = "arifeatina@gmail.com"; // Sender email address
	public static String password = "13999401453"; // Sender email password
	
	public static String[] to = {/* list of people who will be getting email */
			"arafatamat0808@icloud.com", "arafatamat130@gmail.com"
	};  
																							
	public static String subject = "Automation Test Report";
	public static String messageBody = "TestMessage";
	public static String htmlAttachmentPath = System.getProperty("user.dir")  // report attachment
			+ "\\src\\test\\resources\\reports\\result.html";
	
	public static String htmlAttachmentName = "Report.html";
}
