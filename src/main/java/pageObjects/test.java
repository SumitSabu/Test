package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class test {

	public WebDriver driver;

	public test(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "UsernameTextBox")
	WebElement TraineeUserName;

	@FindBy(id = "FirstNameTextbox")
	WebElement TraineeFirstName;

	@FindBy(id = "LastNameTextbox")
	WebElement TraineeLastName;
	
	@FindBy(id = "EmailTextbox")
	WebElement TraineeEmail;
	
	@FindBy(id = "PasswordTextBox")
	WebElement TraineePassword;
	
	@FindBy(id = "SaveTraineeButton")
	WebElement BtnTraineeSave;

	public WebElement getTraineeUserName() {
		return TraineeUserName;
	}

	public WebElement getTraineeFirstName() {
		return TraineeFirstName;
	}

	public WebElement getTraineeLastName() {
		return TraineeLastName;
	}

	public WebElement getTraineeEmail() {
		return TraineeEmail;
	}

	public WebElement getTraineePassword() {
		return TraineePassword;
	}

	public WebElement getBtnTraineeSave() {
		return BtnTraineeSave;
	}
	
	
	
	
}

