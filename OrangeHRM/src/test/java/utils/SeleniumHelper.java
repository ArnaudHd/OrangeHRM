package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class SeleniumHelper extends DriverManager {

	WebDriver driver = DriverManager.getDriver();
	WebDriverWait wait;

	// Will return the title of the page
	public String getTitle() {
		return driver.getTitle();
	}

	// Will go to a given website
	public void goToURL(String url) {
		driver.get(url);
	}

	// navigate to a given website
	public void navigateToURL(String url) {
		driver.navigate().to(url);
	}

	// go to previous page
	public void navigateBack() {
		driver.navigate().back();
	}

	// go to foward page
	public void navigateFoward() {
		driver.navigate().forward();
	}

	// refresh page
	public void refreshPage() {
		driver.navigate().refresh();
	}

	public WebElement getElement(String locator) {
		return driver.findElement(By.xpath(locator));
	}

	// hard sleep with a given amount of time(sec)
	public void sleep(int sec) {

		try {
			Thread.sleep(1000 * sec);
		} catch (InterruptedException e) {
			System.out.println("Could not properly implement sleep");
			e.printStackTrace();
		}
	}

	public WebElement waitForElement(WebElement element) {

		wait = new WebDriverWait(driver, 20);
		WebElement webEl = wait.until(ExpectedConditions.visibilityOf(element));

		highlightElement(element);
		unhighlightElement(element);

		return webEl;
	}

	public WebElement fluentWaitForElement(WebElement element) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchFieldException.class);

		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public boolean ifWebElementExist(WebElement element) {

		boolean isPresent;

		try {
			wait = new WebDriverWait(driver, 20);

			isPresent = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();

			return isPresent;
		} catch (Exception e) {
			return false;
		}
	}

	public void highlightElement(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border = '3px solid red'", element);

		sleep(1);
	}

	public void unhighlightElement(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border = '0px solid red'", element);

		sleep(1);
	}

	public void selectFromDropDown(WebElement element, int index) {

		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectFromDropDown(WebElement element, String value) {

		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void acceptAlerts() {

		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void dismissAlerts() {

		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public void switchToIFrame(int index) {
		driver.switchTo().frame(index);
	}

	public void switchToIFrame(String value) {
		driver.switchTo().frame(value);
	}

	public void switchToParentframe() {
		driver.switchTo().parentFrame();
	}

	public String getCurrentWindowHandle() {
		return driver.getWindowHandle();
	}

	public String switchWindow() {

		String mainWindow = getCurrentWindowHandle();

		Set<String> allWindows = driver.getWindowHandles();

		for (String window : allWindows) {
			driver.switchTo().window(window);
		}

		String childWindow = driver.getWindowHandle();

		return childWindow;
	}

	public void switchToNextWindow() {
		String mainWindow = getCurrentWindowHandle();

		Set<String> allWindows = driver.getWindowHandles();

		for (String window : allWindows) {

			if (!window.equals(mainWindow)) {
				driver.switchTo().window(window);
			}
		}
	}

	public void openNewWindow(WebElement element) {
		element.sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
	}

	public void openUrlToNewWindow(String url) {

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("window.open('" + url + "')");
	}

	public String date() {

		DateFormat format = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();
		String myDate = format.format(date);

		return myDate;
	}

	public void takeScreenShot() {

		String name = "Screenshot " + date().concat(".png");
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			File localScreenshot = new File(new File("Build"), "Screenshots");

			if (!localScreenshot.exists() || !localScreenshot.isDirectory()) {

				localScreenshot.mkdirs();
			}

			File screenshot = new File(localScreenshot, name);

			Files.copy(sourceFile, screenshot);
		} catch (IOException e) {

			System.out.println("Failed to take a screenshot.");

		}

	}

	public void readExcelSheet(String path, String sheetName, int rownum, int cellnum) {

		try {
			File file = new File(path);
			FileInputStream in = new FileInputStream(file);
			XSSFWorkbook work = new XSSFWorkbook(in);
			XSSFSheet sheet = work.getSheet(sheetName);
			
			String data = sheet.getRow(rownum).getCell(cellnum).getStringCellValue();

		} catch (IOException e) {

			System.out.println("Failed to read file.");

		}
	}
}
