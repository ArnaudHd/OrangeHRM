package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DriverManager;
import utils.SeleniumHelper;

public class DashBoardPageFactory {

	SeleniumHelper helper = new SeleniumHelper();

	public DashBoardPageFactory(WebDriver driver) {

		driver = DriverManager.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
	public WebElement DashBoardTitle;

	@FindBy(xpath = "//b[contains(text(),'PIM')]") 
	public WebElement PimTab;

	@FindBy(xpath = "//select[@id='empsearch_employee_status']")
	public WebElement empStatusDropDown;

	public String getDashBoardTitleText() {
		return helper.waitForElement(DashBoardTitle).getText();
	}

	public void clickPim() {
		helper.waitForElement(PimTab).click(); 
	}

	public void selectEmploymentStatus(int index) {

		helper.selectFromDropDown(empStatusDropDown, index);

	}

}
