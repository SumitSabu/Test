package T_Res_New;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.*;
import resources.*;

public class PDCreateTraineeScenario extends base {

	public WebDriver driver;
	loginPage lp;
	homePage hp;
	programPage pp;
	addTraineeForm atf;
	String username;
	String[] abc;

	public PDCreateTraineeScenario(WebDriver driver) {
		this.driver = driver;
	}

	public PDCreateTraineeScenario() {

	}

	@BeforeClass(alwaysRun = true)
	public void launchBrowser() throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
	}

	//@Test(alwaysRun = true)
	public void PDCreateTrainee() throws InterruptedException {

		//ExtentTest test = extent.createTest("PD Create Trainee");

		lp = new loginPage(driver);

		Random R = new Random();
		int num = R.nextInt(90000) + 10000;

		lp.Username_email_field().sendKeys("pd.ubc");
		lp.Password_field().sendKeys("RoxPiKv3w2t");
		lp.login_button().click();

		hp = new homePage(driver);
		hp.getProgram().click();

		pp = new programPage(driver);
		pp.CreateTrainee().click();

		atf = new addTraineeForm(driver);
		username = "vikas" + num;
		atf.TraineeFormUserName().sendKeys(username);
		atf.TraineeFormFirstName().sendKeys("Test" + num);
		atf.TraineeFormLastName().sendKeys("Test");
		atf.TraineeFormEmail().sendKeys("testing" + num + "@ideavate.com");
		atf.TraineeFormPassword().sendKeys("G3ng7ZyPCaG");
		atf.TraineeFormSaveButton().click();

		System.out.println(username);

		(new WebDriverWait(driver, 60)).until(ExpectedConditions
				.invisibilityOfElementLocated(By
						.xpath("//*[@id='AjaxBusyImg']")));
		Thread.sleep(5000);
		
		String actual = atf.getSuccessMessage().getText();
		String expected = (username + " successfully created!");

		Assert.assertEquals(actual, expected);

		// vikas11045 successfully created!
		// username successfully created!
		// *[@id="ctl00_ctl00_CtlContentWell_ContentPlaceHolder_resultMessageDiv"]/span

	}
	
	
	
	
	@Test(alwaysRun = true)
	public void excelTest() throws InterruptedException, IOException {
		
		String filePath = System.getProperty("user.dir")+"\\T_Res_TestData.xlsx";
		
		createConnection(filePath, "T_Res_TestData.xlsx", "CreateTrainee");
		for (int s = 0; s < getRowCount()+1; s++) {
			
			abc = new String[5];
			
			System.out.println("reach here 1");
			abc = fetchData(s);
			 
			System.out.println(abc);
			
			/*abc = fetchData(s);
			System.out.println(abc[0]);
			System.out.println();*/
		} 
		
		
		
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}

}
