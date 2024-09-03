package Testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import PageObjectModel.HomePageObjects;
import PageObjectModel.loginpageobjects;
import Resources.BaseClass;
import Resources.commonMethods;
import Resources.storeData;

public class VerifyLogin extends BaseClass{

		

		@Test(priority =1)
		public void verifyLoginWithValidData() throws IOException, InterruptedException {
			
			
			HomePageObjects hp =new HomePageObjects(driver);		

			commonMethods.handleExplictWait(10,hp.ClickOnMyAccount(),driver);
		   
			hp.ClickOnMyAccount().click();
			hp.clickOnLogin().click();
			
			loginpageobjects lp=new loginpageobjects(driver);
				
			lp.enterEmail().sendKeys(emailAddress);
			lp.enterPassword().sendKeys(storeData.Password);
			lp.clickOnSubmit().click();
		
		    
			String actual = driver.getCurrentUrl();
			String expected= storeData.loginExpectedURL;
		
	        commonMethods.handleAssertion(actual, expected); 
			
			
			hp.ClickOnMyAccount().click();
		
			lp.clickOnLogout().click();
			
			String actualWarningText = lp.getlogoutConfirmationText().getText();
			String expectedWarningText=storeData.logOutExpectedConfirmationtext;
			
		    commonMethods.handleAssertion(actualWarningText,  expectedWarningText); 
			
			
		}
		
		
		@Test(priority=2)		
		public void verifyLoginWithInValidData() throws IOException, InterruptedException {
		

			HomePageObjects hp =new HomePageObjects(driver);
			
			commonMethods.handleExplictWait(10,hp.ClickOnMyAccount(),driver);
			
			hp.ClickOnMyAccount().click();
			hp.clickOnLogin().click();
			
			loginpageobjects lp=new loginpageobjects(driver);
				
			lp.enterEmail().sendKeys(emailAddress);
			lp.enterPassword().sendKeys(storeData.incorrectpassword);
			lp.clickOnSubmit().click();
		

			commonMethods.handleExplictWait(15,hp.ClickOnMyAccount(),driver);
		   
			
			String actual = lp.warningText().getText();
			String expected= storeData.loginFailedExpectedText;
			commonMethods.handleAssertion(actual, expected);
			
		
	}}