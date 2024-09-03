package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginpageobjects {

		
		public WebDriver driver; //This is null
		
		 // encapsulation
		private By email = By.xpath("//input[@name='email']");
		private By password = By.xpath("//input[@name='password']");
		private By submit = By.xpath("//input[@value='Login']");
		private By logout = By.xpath("(//a[text()='Logout'])[1]");
		private By logoutConfirmationText = By.xpath("//h1[text()='Account Logout']");
		
		
		
		private By warningMessage =By.xpath(" //div[text()=' Warning: No match for E-Mail Address and/or Password.']");
		
		
		// constructord 
		public loginpageobjects(WebDriver driver) {
			this.driver = driver;
		}


		public WebElement enterEmail() {
			return  driver.findElement(email);
		}
		
		public WebElement enterPassword() {
			return  driver.findElement(password);
		}
		
		
		public WebElement clickOnSubmit(){
			return  driver.findElement(submit);
		}
		
		
		public WebElement warningText(){
			return  driver.findElement(warningMessage);
		}
		
		
		public WebElement clickOnLogout() {

			return driver.findElement(logout);
		}
		
		public WebElement getlogoutConfirmationText() {

			return driver.findElement(logoutConfirmationText);
		}
		


	}



