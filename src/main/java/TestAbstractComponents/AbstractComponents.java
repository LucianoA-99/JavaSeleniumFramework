package TestAbstractComponents;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	private WebDriver driver;

	@FindBy(css = "[routerlink*='myorders']")
	private WebElement orderHistory;

	@FindBy(css = ".btn.btn-custom[routerlink='/dashboard/cart']")
	private WebElement cartClick;

	@FindBy(css = ".ng-animating")
	private WebElement spinner;

	public void uploadFile(By findBy) {
		WebElement uploadElement = driver.findElement(findBy);
		uploadElement.sendKeys(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\exampleFile");
	}

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
	}

	public String getElementTxt(By findBy) {
		return driver.findElement(findBy).getText();
	}
	
	public void waitForElementToBeClickable(WebElement findBy) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(1));
		w.until(ExpectedConditions.elementToBeClickable(findBy));
	}

	public void waitForElementToAppear(By findBy) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(3));
		w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(3));
		w.until(ExpectedConditions.visibilityOf(findBy));
	}

	public void waitForElementToDisappear(WebElement spinner) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.invisibilityOf(spinner));
	}
}
