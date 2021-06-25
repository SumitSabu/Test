package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

	public WebDriver driver;

	public loginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "UsernameTextBox")
	WebElement email;

	@FindBy(id = "PasswordTextBox")
	WebElement password;

	@FindBy(id = "RecaptchaLoginButton")
	WebElement loginButton;

	public WebElement Username_email_field() {
		return email;
	}

	public WebElement Password_field() {
		return password;
	}

	public WebElement login_button() {
		return loginButton;
	}
}
