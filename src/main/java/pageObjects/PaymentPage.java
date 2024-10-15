package pageObjects;

import java.io.File;
import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import TestAbstractComponents.AbstractComponents;

public class PaymentPage extends AbstractComponents {
	private WebDriver driver;

	private By paymentDoneTxt = By.xpath("//div[@class='col-sm-9 col-sm-offset-1']//p");
	
	@FindBy(css = ".submit-button")
	private WebElement submitBtn;
	
	@FindBy(css = ".fa-trash-o")
	private WebElement deleteBtn;

	@FindBy(css = "input[name='name_on_card']")
	private WebElement cardName;

	@FindBy(css = ".btn.btn-default.check_out")
	private WebElement downloadBtn;

	@FindBy(css = ".card-number")
	private WebElement cardNumber;

	@FindBy(css = ".card-cvc")
	private WebElement cardCvc;

	@FindBy(css = ".card-expiry-month")
	private WebElement cardExpiryM;

	@FindBy(css = ".card-expiry-year")
	private WebElement cardExpiryY;

	public DeleteAccountPage deleteAccount() {
		deleteBtn.click();
		DeleteAccountPage deleteAPage = new DeleteAccountPage(driver);
		return deleteAPage;
	}

	public String verifyPayment() {
		return getElementTxt(paymentDoneTxt);
	}

	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void downloadInvoice() {
		downloadBtn.click();
	}
	public boolean VerifyInvoice() {
		String fileName = "invoice.txt";
	     File dir = new File(System.getProperty("user.home") + "\\Downloads");
	     File[] dirContents = dir.listFiles();
	     return Arrays.stream(dirContents).map(File::getName).anyMatch(name -> name.equals(fileName));
	}

	public void fillCardInfo() {
		cardName.sendKeys("Luciano Alonso");
		cardNumber.sendKeys("1234 5678 9101 1123");
		cardCvc.sendKeys("777");
		cardExpiryM.sendKeys("07");
		cardExpiryY.sendKeys("2025");
		submitBtn.click();
	}

}