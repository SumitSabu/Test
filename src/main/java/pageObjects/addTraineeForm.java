package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addTraineeForm {

	public WebDriver driver;

	public addTraineeForm(WebDriver driver) {
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

	@FindBy(xpath = "//*[@id='ctl00_ctl00_CtlContentWell_ContentPlaceHolder_resultMessageDiv']/span")
	WebElement successMessage;
	
	@FindBy(id = "UsersPageLink")
	WebElement backToTraineeList;
	
	

	public WebElement getBackToTraineeList() {
		return backToTraineeList;
	}

	public WebElement getSuccessMessage() {
		return successMessage;
	}

	public WebElement TraineeFormUserName() {
		return TraineeUserName;
	}

	public WebElement TraineeFormFirstName() {
		return TraineeFirstName;
	}

	public WebElement TraineeFormLastName() {
		return TraineeLastName;
	}

	public WebElement TraineeFormEmail() {
		return TraineeEmail;
	}

	public WebElement TraineeFormPassword() {
		return TraineePassword;
	}

	public WebElement TraineeFormSaveButton() {
		return BtnTraineeSave;
	}

}
