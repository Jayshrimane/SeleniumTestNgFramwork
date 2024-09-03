package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects {
	public WebDriver driver;
	
	
	  //Encapsulation
	private By MyAccount=By.xpath("//span[@class='caret']");
	private By register=By.xpath("//a[text()='Register']");
	private By login = By.xpath("//a[text()='Login']");
			
	
	public HomePageObjects(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement clickOnLogin() {
		return driver.findElement(login);
	}

	public WebElement ClickOnMyAccount() {
		return driver.findElement(MyAccount);	}


	public WebElement ClickOnRegister() {
		return driver.findElement(register);
		
	}

}
