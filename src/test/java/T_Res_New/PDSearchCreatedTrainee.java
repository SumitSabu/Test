package T_Res_New;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.*;
import resources.base;

public class PDSearchCreatedTrainee extends base {

	public static WebDriver driver;
	SoftAssert sa = new SoftAssert();
	loginPage lp;
	homePage hp;
	programPage pp;
	addTraineeForm atf;
	PDCreateTraineeScenario PDCTS;

	@BeforeClass(alwaysRun = true)
	public void launchBrowser() throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
	}

	@Test(alwaysRun = true, groups = "PD")
	public void PDSearchTrainee() throws InterruptedException {

		PDCTS = new PDCreateTraineeScenario(driver);
		PDCTS.PDCreateTrainee();

		/*(new WebDriverWait(driver, 60)).until(ExpectedConditions
				.invisibilityOfElementLocated(By
						.xpath("//*[@id='AjaxBusyImg']")));*/

		atf = new addTraineeForm(driver);
		atf.getBackToTraineeList().click();

		pp = new programPage(driver);
		pp.getStatusDropdown().click();
		Thread.sleep(5000);
		pp.getStatusAll().click();
		Thread.sleep(5000);
		pp.getSearchUsernameField().sendKeys(PDCTS.username);
		pp.getSearchUsernameField().sendKeys(Keys.ENTER);

	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}

}
