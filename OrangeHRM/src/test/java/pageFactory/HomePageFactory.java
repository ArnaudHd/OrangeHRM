package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DriverManager;
import utils.SeleniumHelper;

public class HomePageFactory {

	SeleniumHelper helper = new SeleniumHelper();

	public HomePageFactory(WebDriver driver) {

		driver = DriverManager.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='logInPanelHeading']")
	public WebElement logInPanelTitle;

	@FindBy(xpath = "//input[@id='txtUsername']")
	public WebElement userNameTextBox;

	@FindBy(xpath = "//input[@id='txtPassword']")
	public WebElement passwordTextBox;

	@FindBy(xpath = "//input[@id='btnLogin']")
	public WebElement logInBtn;

	public void enterUserName(String userName) {
		helper.waitForElement(userNameTextBox).sendKeys(userName);
	}

	public void enterPassword(String password) {
		helper.waitForElement(passwordTextBox).sendKeys(password);
	}

	public void clickLogInBtn() {
		helper.waitForElement(logInBtn).click();
	}

}
