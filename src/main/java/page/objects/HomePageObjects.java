package page.objects;

import core.Base;
import utilities.Util;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects extends Base {

	public HomePageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='TEST ENVIRONMENT']")
	private WebElement textToValidate;
	
	@FindBy(xpath ="//div[@class='btn-group']//button[@class='btn btn-link dropdown-toggle']")
	private WebElement curruncyBtn;
	
	@FindBy(xpath ="//button[text()='€ Euro']")
	private WebElement euroBtn;
	@FindBy(xpath ="//strong[text()='€']")
	private WebElement euroSign;
	
	@FindBy(xpath = "//span[@id='cart-total']")
	private WebElement itemsInCartBtn;
	
	@FindBy(xpath = "//p[text()='Your shopping cart is empty!']")
	private WebElement shoppingCartText;
	
	public void homePageValidate() throws IOException {
		String text = textToValidate.getText();
		if(text.equalsIgnoreCase("TEST ENVIRONMENT")) {
			logger.info("'" + textToValidate + "'" + "text verified");
		}else {
			logger.info("'" + textToValidate + "'" + "text not verified");
		}
		Util.highlightelementRedBorder(textToValidate);
		Util.takeScreenShot("Homepage");
	}
	
	public void clickCurrancyBtn() {
		curruncyBtn.click();
	}
	
	public void clickEuro() {
		euroBtn.click();
	}
	
	public void euroSign() throws IOException {
		euroSign.getText();
		Util.highlightelementRedBorder(euroSign);
		Util.takeScreenShot("euroSign");
	}
	
	public void clickItemsInCartBtnn() {
		itemsInCartBtn.click();
	}
	//Scenario: User empty Shopping cart message displays 
	public void verifyShoppingCartEmptyMsg() throws IOException {
		String expectedMssg = "Your shopping cart is empty!";
		String actualMessage = shoppingCartText.getText();
		try {
			Assert.assertEquals(expectedMssg, actualMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Util.highlightelementRedBorder(shoppingCartText);
		Util.takeScreenShot("shopping Cart empty Text");
	}
}	
