package testRun;

import org.testng.annotations.Test;
import pageFactory.DashBoardPageFactory;
import pageFactory.HomePageFactory;
import utils.DriverManager;
import utils.SeleniumHelper;

public class PracticeTest {

	@Test
	public void firstTest() {

		DriverManager manager = new DriverManager();

		manager.openBrowser("chrome");

		SeleniumHelper helper = new SeleniumHelper();
		HomePageFactory homePage = new HomePageFactory(DriverManager.getDriver());
		//DashBoardPageFactory dashBoard = new DashBoardPageFactory(DriverManager.getDriver());
		// SoftAssert softAssertion = new SoftAssert();

		helper.goToURL("https://opensource-demo.orangehrmlive.com/");

		homePage.enterUserName("Admin");
		homePage.enterPassword("admin123");
		homePage.clickLogInBtn();
		
		helper.takeScreenShot();

		/*
		 * String window1 = helper.getCurrentWindowHandle();
		 * System.out.println(window1);
		 * 
		 * // helper.openNewWindow(dashBoard.PimTab); helper.openUrlToNewWindow(
		 * "https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList");
		 * 
		 * //helper.switchWindow(); helper.switchToNextWindow();
		 * 
		 * String window2 = helper.getCurrentWindowHandle();
		 * System.out.println(window2);
		 */

		helper.sleep(2);

		/*
		 * dashBoard.clickPim(); dashBoard.selectEmploymentStatus(3);
		 * 
		 * 
		 * String actual = dashBoard.getDashBoardTitleText(); String expected =
		 * "Dashboard";
		 * 
		 * softAssertion.assertEquals(actual, expected); softAssertion.assertAll();
		 * 
		 * Assert.assertEquals(actual, expected);
		 * 
		 * WebElement header = helper.getElement("//div[@id = 'logInPanelHeading']");
		 * 
		 * String title = header.getText();
		 * 
		 * System.out.println(title);
		 * 
		 * String title2 = helper.waitForElement(header).getText(); String title3 =
		 * helper.FluentWaitForElement(header).getText();
		 * 
		 * System.out.println(title2); System.out.println(title3);
		 * System.out.println(helper.IfWebElementExist(header));
		 */

		helper.sleep(2);

		manager.quitBrowser();
	}
	
	@Test	
	public void secondTest() {
		
		SeleniumHelper helper = new SeleniumHelper();
		
		System.out.println(helper.date());
	}
}
