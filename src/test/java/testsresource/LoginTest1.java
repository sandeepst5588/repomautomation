package testsresource;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest1 extends Base {
	WebDriver driver;
	Logger log;

	@Test(dataProvider = "getLoginData")
	public void login(String email, String password, String expectedStatus) {

		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropDown().click();
		landingPage.loginOption().click();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddressField().sendKeys(email);
		log.debug("Email addressed got entered");
		loginPage.passwordField().sendKeys(password);
		log.debug("Password got entered");
		loginPage.loginButton().click();
		log.debug("Clicked on Login Button");

		AccountPage accountPage = new AccountPage(driver);
		String actualResult = null;

		// Assert.assertTrue(accountPage.editAccountInformation().isDisplayed());
		try {
			if (accountPage.editAccountInformation().isDisplayed())
				log.debug("User got logged in");
			actualResult = "Success";

		} catch (Exception e) {
			log.debug("User didn't log in");
			actualResult = "Failure";
		}
		Assert.assertEquals(actualResult, expectedStatus);
	}

	@BeforeMethod
	public void openApplication() throws IOException {

		log = LogManager.getLogger(LoginTest1.class.getClass());
		driver = intializeDriver();
		log.debug("Browser got launched");
		driver.get(prs.getProperty("URL"));
		log.debug("Navigated to application URL");
	}

	@AfterMethod
	public void closer() {
		driver.close();
		log.debug("Browser got closed");
	}

	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = { { "sandeepst5588@gmail.com", "Sandy123@123", "Success" },
				{ "sandyst5588@gmail.com", "Sandy123@", "Failure" } };

		return data;
	}

}
