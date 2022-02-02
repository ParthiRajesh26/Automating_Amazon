package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonfunctions.CommonFunctions;

public class AddwishListPageOBject extends CommonFunctions {
	
	@FindBy(xpath="//*[@id=\"searchDropdownBox\"]")  
	public static WebElement selectDropdown;
	
	@FindBy(id ="twotabsearchtextbox")
	public static WebElement searchbox;
	
	@FindBy(linkText ="Apple iPhone 12 Pro Max (256GB) - Gold")
	public static WebElement product;
	
	@FindBy(xpath = "(//input[@type='checkbox'])[3]")
	public static WebElement airpods;
	
	@FindBy(id ="add-to-wishlist-button-submit")
	public static WebElement wishList;
	
	@FindBy(className = "w-button-text")
	public static WebElement viewWishList;  
	
	
	
	
	
	
	
	
	

}
