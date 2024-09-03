package Testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjectModel.HomePageObjects;

import PageObjectModel.registrationPageObjects;
import Resources.BaseClass;
import Resources.commonMethods;
import Resources.storeData;

public class VerifyRegistation extends BaseClass {

	@Test(priority=1)
	public void verifyRegisterationWithValidData() throws IOException, InterruptedException {

		BrowserLaunch();

		driver.get("https://naveenautomationlabs.com/opencart/");

		HomePageObjects hp = new HomePageObjects(driver);

		hp.ClickOnMyAccount().click();
		hp.ClickOnRegister().click();


		commonMethods.handleExplictWait(10,hp.ClickOnMyAccount(),driver);
	   

		registrationPageObjects R = new registrationPageObjects(driver);

		R.EnterFirstname().sendKeys(storeData.FirstName);
		R.EnterLastname().sendKeys(storeData.lastName);
		R.EnterEmail().sendKeys(emailAddress);
		R.EnterTelephone().sendKeys(storeData.Telephone);
		R.EnterPassword().sendKeys(storeData.Password);
		R.EnterPasswordConfirm().sendKeys(storeData.ConfirmPassword);
		R.agreeprivacypolicybox().click();
		R.Continueclick().click();

		String actual = R.getregistrationConfirmText().getText();
		String expected = storeData.regExpectedText;

	}

	@Test(priority=2)
	public void VerifyregistationBlankdata() {
				
  HomePageObjects hp=new HomePageObjects(driver);		
		hp.ClickOnMyAccount().click();
		hp.ClickOnRegister().click();
			
	 
		commonMethods.handleExplictWait(10,hp.ClickOnMyAccount(),driver);
	   
	     registrationPageObjects Rp = new registrationPageObjects(driver);

	     Rp.Continueclick().click();
	     
		     String Firstnameactual=Rp.EnterFirstnameErrortext().getText();
	     String firstnameexpected=( storeData.firstnameerrorText);  
	         commonMethods.handleAssertion( Firstnameactual,firstnameexpected);
		
		     String lastnameactual =Rp.EnterLastnameErrortext().getText();
		     String lastexpectedname= (storeData.lastnameErrorText);
		     commonMethods.handleAssertion( lastnameactual,lastexpectedname);
	
		     String actualemail =Rp.EnterEmailErrorText().getText();
		     String expectedemail= (storeData.EmailnameErrorText);
		     commonMethods.handleAssertion( actualemail,expectedemail);
		   
		
		     String actualtelephone =Rp.EnterTelephoneErrorText().getText();
		     String expectedtelephone=(storeData.TelephoneErrorText);
		     commonMethods.handleAssertion( actualtelephone,expectedtelephone);
		  
		
		     String actualpassword =Rp.EnterPasswordErrorText().getText();
		     String expectedpassword =(storeData.PasswordErrorText);
		     commonMethods.handleAssertion( actualpassword,expectedpassword);
	     
	}
		     
}