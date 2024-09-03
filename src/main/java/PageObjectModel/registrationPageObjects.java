package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class registrationPageObjects {

	public WebDriver driver;

	// Encapsulation
	private By Firstname = By.xpath("//input[@id='input-firstname']");
	private By Lastname = By.xpath("//input[@id='input-lastname']");
	private By Email = By.xpath("//input[@id='input-email']");
	private By Telephone = By.xpath("//input[@id='input-telephone']");
	private By Password = By.xpath("//input[@id='input-password']");
	private By PasswordConfirm = By.xpath("//input[@id='input-confirm']");
	private By agreeprivacypolicy = By.xpath("//input[@name='agree']");
	private By Continue = By.xpath("//input[@value='Continue']");
    private By registrationConfirmText=By.xpath("//h1[text()='Your Account Has Been Created!']");
	
    
 // Encapsulation
    private By firstnameErrorText = By.xpath("(//div[@class='text-danger'])[1]");

	private By lastnameErrorText = By.xpath("(//div[@class='text-danger'])[2]");

	private By emailErrorText = By.xpath("(//div[@class='text-danger'])[3]");

	private By telephoneErrorText = By.xpath("(//div[@class='text-danger'])[4]");

	private By passwordErrorText = By.xpath("(//div[@class='text-danger'])[5]");
	
	
    //constructor
	public registrationPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement EnterFirstname() {
		return driver.findElement(Firstname);

	}

	public WebElement EnterLastname() {
		return driver.findElement(Lastname);
	}

	public WebElement EnterEmail() {
		return driver.findElement(Email);
	}

	public WebElement EnterTelephone() {
		return driver.findElement(Telephone);
	}

	public WebElement EnterPassword() {
		return driver.findElement(Password);

	}

	public WebElement EnterPasswordConfirm() {
		return driver.findElement(PasswordConfirm);

	}

	public WebElement agreeprivacypolicybox() {
		return driver.findElement(agreeprivacypolicy);

	}

	public WebElement Continueclick() {
		return driver.findElement(Continue);

	}

	public WebElement getregistrationConfirmText() {
		return driver.findElement(registrationConfirmText);

	}
 
	public WebElement EnterFirstnameErrortext() {
		return driver.findElement(firstnameErrorText);
	}

	public WebElement EnterLastnameErrortext() {
		return driver.findElement(lastnameErrorText);
	}

	public WebElement EnterEmailErrorText() {
		return driver.findElement(emailErrorText);
	}

	public WebElement EnterTelephoneErrorText() {
		return driver.findElement(telephoneErrorText);
	}

	public WebElement EnterPasswordErrorText() {
	    return driver.findElement(passwordErrorText);

	}
    }
