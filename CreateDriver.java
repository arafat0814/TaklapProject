package utility;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateDriver {
	private static WebDriver driver;
	private static Logger logger;

	/***
	 * This method starts user defined browser
	 * 
	 * @param browserName
	 * @return WebDriver object
	 */
	public static WebDriver startLocalBrowser(String browserName) {
		try {
			if (browserName.equals("ie")) {
				return startIEBrowser();
			} else if (browserName.equals("chrome")) {
				return startChromeBrowser();
			} else if (browserName.equals("firefox")) {
				return startFirefoxBrowser();
			} else {
				throw new Exception(
						"You choose '" + browserName + "', Currently supporting browsers are 'IE, Chrome and Firefox'");
			}
		} catch (Exception ex) {
			System.out.println("something went wrong at startLocalBrowser()");
			ex.printStackTrace();
		}
		return null;
	}

	/*
	 * This method starts chrome browser
	 */
	private static WebDriver startChromeBrowser() {
		try {
			System.out.println("CHROME FILE:: " + FileUtils.getDriversPath("chromedriver"));
			System.setProperty("webdriver.chrome.driver", FileUtils.getDriversPath("chromedriver"));
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return driver;
	}

	/*
	 * This method starts firefox browser
	 */
	private static WebDriver startFirefoxBrowser() {
		try {
			System.setProperty("webdriver.gecko.driver", FileUtils.getDriversPath("geckcodriver"));
			driver = new FirefoxDriver();
			// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (Exception ex) {
			logger.error("Oops! Error with startFirefoxBrowser", ex);
			ex.printStackTrace();
		}
		return driver;
	}

	/*
	 * This method starts IE browser
	 */
	private static WebDriver startIEBrowser() {
		try {
			System.setProperty("webdriver.ie.driver", FileUtils.getDriversPath("IEDriverServer"));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (Exception ex) {

			ex.printStackTrace();
		}
		return driver;
	}

}
