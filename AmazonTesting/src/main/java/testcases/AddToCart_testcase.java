package testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonfunctions.CommonFunctions;
import pageobject.AddToCartPageObject;
import pageobject.loginPageObject;


public class AddToCart_testcase extends CommonFunctions {
	
	static org.apache.log4j.Logger logger=org.apache.log4j.Logger.getLogger(CommonFunctions.class);

	public void logInAmazon() {
		
		logger.info("SignIn in to Amazon Application");
		loginPageObject.signIn.click();
		loginPageObject.emailBox.sendKeys(properties.getProperty("username"));
		loginPageObject.continueButton.click();
		loginPageObject.passwordBox.sendKeys(properties.getProperty("password"));
		loginPageObject.signInButton.click();

	}


	public void searchProduct() throws InterruptedException {
		
		logger.info("Searching the Specific Product");

		AddToCartPageObject.searchBox.sendKeys("Sweatshirt",Keys.ENTER);
		AddToCartPageObject.sweatShirt.click();		



	}

	public void selectSize() {
		
		logger.info("Selecting the desired size of the product");

		String oldWindow = driver.getWindowHandle();

		Set<String> AllWindows =driver.getWindowHandles();

		List<String> list=new ArrayList<String>(AllWindows);

		driver.switchTo().window(list.get(1));
		
		/* AddToCartPageObject.selectsizeClick.click(); */
		
		
		  Select select=new Select(AddToCartPageObject.selectsize);
		  select.selectByIndex(3);

	}


	public void addToCartFunction() {
		
		logger.info("Adding product to our cart");
		Select select1=new Select(AddToCartPageObject.quantity);
		select1.selectByIndex(1);

		AddToCartPageObject.addCartButton.click();
		
		

	}


	@Test
	public void addToCart() throws InterruptedException {

		PageFactory.initElements(driver, loginPageObject.class);
		PageFactory.initElements(driver, AddToCartPageObject.class);


		logInAmazon();
		searchProduct();
		selectSize();
		addToCartFunction();

	}

}
