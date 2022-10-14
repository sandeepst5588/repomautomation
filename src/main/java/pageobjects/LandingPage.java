package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver driver;

	public LandingPage(WebDriver d) {
		this.driver = d;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='My Account']")
	private WebElement myAccountDropDown;

	public WebElement myAccountDropDown() {
		return myAccountDropDown;
	}

	@FindBy(xpath = "(//a[text()='Login'])[1]")
	private WebElement loginOption;

	public WebElement loginOption() {
		return loginOption;
	}

}
