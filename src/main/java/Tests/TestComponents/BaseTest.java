package Tests.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;

public class BaseTest {
    public WebDriver driver;
    public LandingPage landingPage;

    public WebDriver initializeDriver () throws IOException{
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\GlobalData.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");

        switch (browserName.toLowerCase()) {
        case "firefox":
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            break;
        case "chrome":
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            break;
        case "edge":
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            break;
        default:
            throw new IllegalArgumentException("Browser not supported: " + browserName);
    }
        
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		//json to string
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		//String to hashmap - jackson databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
	}

    @BeforeMethod(alwaysRun=true)
    public void launchApplication() throws IOException{
        String url ="https://automationexercise.com";
        driver = initializeDriver();
        landingPage = new LandingPage(driver);
		landingPage.GoTo(url);
    }

    @AfterMethod(alwaysRun=true)
    public void tearDown(){
        driver.close();
    }

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+ "//reports//" + testCaseName +".png");
		FileUtils.copyFile(Source, file);
		return System.getProperty("user.dir")+ "//reports//" + testCaseName +".png";
	}
}