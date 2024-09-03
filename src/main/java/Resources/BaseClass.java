package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	public static WebDriver driver;
	public Properties prop;

	public static String emailAddress = UniqemailAddress();

	public void BrowserLaunch() throws IOException {

		// Read the data
		FileInputStream Fs = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\data.properties");

		// object of properties class ---Access the properties file
		prop = new Properties();

		prop.load(Fs);

		String browsername = prop.getProperty("Browser");

		if (browsername.equalsIgnoreCase("Chrome")) {

			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("FirefoxDriver")) {

			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("EdgeDriver")) {

			driver = new EdgeDriver();
		} else {
			System.out.println("please choose correct browser");
		}

	}
	
		//To capture the screenshot
		public static String screenShot(WebDriver driver, String filename)  {
			String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			// 202408311143

			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir") + "\\ScreenShot\\" + filename + "_" + dateAndTime + ".png";
		    try {
				FileUtils.copyFile(source, new File(destination));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return destination;
		}

	// Generate random email address
	public static String UniqemailAddress() {

		return System.currentTimeMillis() + "@gmail.com";
	}
	
	@BeforeSuite
	public void extenReprort() {
		
		extentManager.setup();
	}
	
	@AfterSuite
public void endReprortCode() {
		
		extentManager.endReport();
	}


	@BeforeMethod
	public void launchBrowserAndOpenURl() throws IOException {

		BrowserLaunch();
		driver.get(prop.getProperty("url"));

	}

	@AfterMethod
	public void closeBrowser() throws IOException {
		// driver.quit();
	}

}
