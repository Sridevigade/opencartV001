package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage 
{
	WebDriver driver;
	
	//constructor
	public LogoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")
	WebElement lnkLogout;
	
	@FindBy(xpath="//a[normalize-space()='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Account Logout']")
	WebElement msgAccountLogout;
	
	@FindBy(xpath="//h3[normalize-space()='Featured']")
	WebElement msgHomepageConfirmation;
	
	//Actions
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	public boolean isMyAccountLogoutPageExists()
	{
		try
		{
			return (msgAccountLogout.isDisplayed());
		}
		catch(Exception e)
		{
			return(false);
		}
	}
	
	public String getHomepageConfirmationMsg()
	{
		try
		{
			return (msgHomepageConfirmation.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
}
