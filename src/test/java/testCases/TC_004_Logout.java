package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import testBase.BaseClass;

public class TC_004_Logout extends BaseClass
{
	@Test
	public void test_Logout() throws IOException 
	{
		logger.info(" Starting TC_004_Logout ");
		
		try
		{
			driver.get(rb.getString("appURL"));
			logger.info("Home Page Displayed ");
			
			driver.manage().window().maximize();
			
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account ");
			hp.clickLogin();
			logger.info("Clicked on Login ");
			
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(rb.getString("email"));
			logger.info("Provided Email ");
			lp.setPassword(rb.getString("password"));
			logger.info("Provided Password ");
			lp.clickLogin();
			logger.info("Clicked on Login");
			
			hp.clickMyAccount();
			logger.info("Clicked on My Account ");
			
			LogoutPage lop=new LogoutPage(driver);
			lop.clickLogout();
			logger.info("Clicked on Logout");
			
			boolean targetpage=lop.isMyAccountLogoutPageExists();
			
			if(targetpage)
			{
				logger.info("Logout Success ");
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Logout Failed ");
				captureScreen(driver, "test_Logout"); //Capturing screenshot
				Assert.assertTrue(false);
			}
			
			lop.clickContinue();
			logger.info("Clicked on Continue");
			
			String confmsg=lop.getHomepageConfirmationMsg();
			
			if(confmsg.equals("Featured"))
			{
				logger.info("Continue Success ");
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Continue Failed ");
				captureScreen(driver,"test_Logout");//capturing screenshot
				Assert.assertTrue(false);
			}
			
		}
		catch(Exception e)
		{
			logger.fatal("Logout Failed ");
			captureScreen(driver, "test_Logout");
			Assert.fail();
		}
		logger.info(" Finished TC_004_Logout ");
	}
}
