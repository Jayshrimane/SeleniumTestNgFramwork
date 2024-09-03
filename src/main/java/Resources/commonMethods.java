package Resources;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class commonMethods {
		
		
		public static void handleAssertion(String actualText,String expectedText) {
			
			SoftAssert sa= new SoftAssert();
			sa.assertEquals(actualText, expectedText);
			sa.assertAll();
		}
		
		
		
		
	public static void handleExplictWait(int time,WebElement element,WebDriver driver){
			
			
	     WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(time));
				
		wait.until(ExpectedConditions.visibilityOf(element));
				
		
		
		
		
	}
	
	}

