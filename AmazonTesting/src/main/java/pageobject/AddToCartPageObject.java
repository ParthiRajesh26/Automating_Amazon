package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPageObject {
	
	@FindBy(id="twotabsearchtextbox")
	public static WebElement searchBox;
	
	@FindBy(linkText ="Boys' Chest Printed Hooded Sweatshirt")
	public static WebElement sweatShirt;
	
	/*
	 * @FindBy(className = "a-button-input") public static WebElement
	 * selectsizeClick;
	 */
	
	@FindBy(id="native_dropdown_selected_size_name") 
	public static WebElement selectsize;
	
	@FindBy(id="quantity")
	public static WebElement quantity;
	
	
	@FindBy(id ="add-to-cart-button")
	public static WebElement addCartButton;

}
