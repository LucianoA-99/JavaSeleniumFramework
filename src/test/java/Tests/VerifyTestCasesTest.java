package Tests;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Test;
import Tests.TestComponents.BaseTest;
import pageObjects.TestCasePage;

public class VerifyTestCasesTest extends BaseTest{
	
	@Test (groups = {"NoPreviousAccountCreationRequired"})
	public void VerifyTests () throws IOException { 
		String testCasePage = "https://automationexercise.com/test_cases";
		
		TestCasePage testCase = landingPage.GoToTestCases();
    	assertTrue(testCase.Url().equalsIgnoreCase(testCasePage));
	}
}