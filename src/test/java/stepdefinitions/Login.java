package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class Login extends Base {

	WebDriver driver;
	LandingPage landingPage;
	LoginPage loginPage;

	AccountPage accountPage;

	@Given("^Open any Browser$")
	public void open_any_browser() throws IOException {

		driver = intializeDriver();
	}

	@And("^Navigate to Login page$")
	public void navigate_to_login_page() {
		driver.get(prs.getProperty("URL"));
		landingPage = new LandingPage(driver);
		landingPage.myAccountDropDown().click();

		landingPage.loginOption().click();
	}

	@When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
	public void user_enters_username_as_something_and_password_as_something_into_the_fields(String strArg1,
			String strArg2) {

		loginPage = new LoginPage(driver);
		loginPage.emailAddressField().sendKeys(strArg1);
		loginPage.passwordField().sendKeys(strArg2);

	}

	@And("^User clicks on Login button$")
	public void user_clicks_on_login_button() throws InterruptedException {

		Thread.sleep(2000);
		loginPage.loginButton().click();
	}

	@Then("^Verify user is able to successfully login$")
	public void verify_user_is_able_to_successfully_login() {

		AccountPage accountPage = new AccountPage(driver);

		Assert.assertTrue(accountPage.editAccountInformation().isDisplayed());

	}

	@After
	public void closeBrowser() {
		driver.close();
	}

}
