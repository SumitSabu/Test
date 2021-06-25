package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class programPage {

	public WebDriver driver;

	public programPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "CreateButtonTab")
	WebElement BtnCreateTrainee;

	@FindBy(xpath = "//*[@id='ctl00_ctl00_CtlContentWell_ContentPlaceHolder_TraineeTable_ctl00_ctl02_ctl02_StatusComboBox_Arrow']")
	WebElement StatusDropdown;

	@FindBy( xpath = "//*[@id='ctl00_ctl00_CtlContentWell_ContentPlaceHolder_TraineeTable_ctl00_ctl02_ctl02_StatusComboBox_DropDown']/div/ul/li[1]" )
	WebElement StatusAll;
	
	@FindBy(xpath = "//*[@id='ctl00_ctl00_CtlContentWell_ContentPlaceHolder_TraineeTable_ctl00_ctl02_ctl02_FilterTextBox_TemplateColumn1']")
	WebElement searchUsernameField;

	public WebElement getSearchUsernameField() {
		return searchUsernameField;
	}

	public WebElement getStatusAll() {
		return StatusAll;
	}

	public WebElement getStatusDropdown() {
		return StatusDropdown;
	}

	public WebElement CreateTrainee() {
		return BtnCreateTrainee;
	}

}
