package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPageObject {
	@FindBy(id="nav-link-accountList-nav-line-1")
    public static WebElement signIn;
	
	@FindBy(id="ap_email")
	public static WebElement emailBox;
	
	@FindBy(id="continue")
	public static WebElement continueButton;
	
	@FindBy(id="ap_password")
	public static WebElement passwordBox;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	public static WebElement signInButton;

}
