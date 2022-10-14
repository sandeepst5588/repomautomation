package testsresource;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class FourTest extends Base {
	public WebDriver driver;

	@Test
	public void test4() throws IOException {
		
		System.out.println("Abc has updated the test 4  code");
		
		
		System.out.println("test4");
		driver = intializeDriver();

		driver.get("http://tutorialsninja.com/demo/");

		Assert.assertTrue(false);

	}

	@AfterMethod
	public void browerclose() {

		driver.close();
	}

}
