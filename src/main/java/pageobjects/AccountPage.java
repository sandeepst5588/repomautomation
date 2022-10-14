package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	WebDriver driver;

	public AccountPage(WebDriver driver1) {
		this.driver = driver1;

		PageFactory.initElements(driver1, this);
	}

	@FindBy(linkText = "Edit your account information")
	private WebElement editAccountInformation;

	public WebElement editAccountInformation() {
		return editAccountInformation;
	}

}
