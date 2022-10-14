package testsresource;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class TwoTest extends Base {

	public WebDriver driver;

	@Test
	public void test2() throws IOException {
		System.out.println("test2");
		driver = intializeDriver();

		driver.get("http://tutorialsninja.com/demo/");

		driver.close();
	}

}
