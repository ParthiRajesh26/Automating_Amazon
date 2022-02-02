package testcases;

import java.time.Duration;
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
import org.testng.annotations.Test;

import commonfunctions.CommonFunctions;
import pageobject.AddwishListPageOBject;

public class AddWishList_testcase extends CommonFunctions {
	
	static org.apache.log4j.Logger logger=org.apache.log4j.Logger.getLogger(CommonFunctions.class);
	
	 public void selectDropdown() {
		 
		 logger.info("Select the specific section in the search dropdown");
		
		Select select = new Select(AddwishListPageOBject.selectDropdown);
		select.selectByVisibleText("Electronics");	
	}
	
	
	public void searchTheProduct() {
		
		logger.info("Input product search term and getting the results");
		
		AddwishListPageOBject.searchbox.sendKeys("apple iphone 12 pro max",Keys.ENTER );
		AddwishListPageOBject.product.click();
		
		String oldWindow= driver.getWindowHandle();
		
		Set<String> allWindows=  driver.getWindowHandles();
		
		List<String> list = new ArrayList<String>(allWindows);
		
		driver.switchTo().window(list.get(1));
		}
	
	
	
	public void AddingAirpods() {
		
		logger.info("selecting the Airpods with the product");
		
		AddwishListPageOBject.airpods.click();
		
	}
	
	public void AddingWishList() throws InterruptedException {
		
		
		logger.info("Adding product to Wishlist");
		
		Thread.sleep(3000);
		
//		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
//
//		WebElement profile=	wait.until(ExpectedConditions.elementToBeClickable(AddwishListPageOBject.wishList));
//
//		profile.click();
		
		AddwishListPageOBject.wishList.click();
		AddwishListPageOBject.viewWishList.click();	
	}
	
	
	@Test
	public void postQuestionMethod() throws InterruptedException {
		
		PageFactory.initElements(driver, AddwishListPageOBject.class);
		
		selectDropdown();
		searchTheProduct();
		AddingAirpods();
		AddingWishList();
		
	}

}
