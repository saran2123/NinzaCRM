package webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void waitForPageToLoad(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitForVisibilityOfWebElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String nameOrID) {
		driver.switchTo().frame(nameOrID);
	}

	public void switchToFrame(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);

	}

	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String switchToAlertAndgetText(WebDriver driver) {
		String text = driver.switchTo().alert().getText();
		return text;
	}

	public void switchToAlertAndSendKeys(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	public void select(WebElement element, int index) {
		Select obj = new Select(element);
		obj.selectByIndex(index);
	}

	public void select(WebElement element, String value) {
		Select obj = new Select(element);
		obj.selectByValue(value);
	}

	public void select(String text, WebElement element) {
		Select obj = new Select(element);
		obj.selectByVisibleText(text);
	}

	public void mouseHoverOnWebElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void clickOnWebElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}

	public void doubleClickOnWebElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void rightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	public void enterInput(WebDriver driver, WebElement element, String text) {
		Actions action = new Actions(driver);
		action.click(element).sendKeys(text).perform();
	}

	public void switchToWindowOnTitle( WebDriver driver, String expectedTitle) {
		Set<String> set = driver.getWindowHandles();
		for (String id : set) {
			driver.switchTo().window(id);
			if (driver.getTitle().contains(expectedTitle))
				break;
		}
	}
	
	public void switchBackToParentId(WebDriver driver) {
		String pId = driver.getWindowHandle();
	     driver.switchTo().window(pId);
		
	}

	public void switchToWindowOnCurrentURL(WebDriver driver, String expectedURL) {
		Set<String> set = driver.getWindowHandles();
		for (String id : set) {
			driver.switchTo().window(id);
			if (driver.getCurrentUrl().contains(expectedURL))
				break;
		}
	}

	public void takeScreenshot(WebDriver driver, String fileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshots/" + fileName + ".png");
		FileHandler.copy(src, dest);
	}
	public void scrollByAmount(WebDriver driver,int x,int y) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	
	

}
