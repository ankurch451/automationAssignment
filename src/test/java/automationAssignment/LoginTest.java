package automationAssignment;

import org.junit.jupiter.api.Test;

import com.strabag.base.BaseTest;
import com.strabag.pageObjects.LoginPage;
import com.strabag.utils.ConfigHelper;

public class LoginTest extends BaseTest {

	LoginPage loginPage;
	ConfigHelper configReader = new ConfigHelper();
	private String errorMessage = "Invalid login\nand/or password";
	private String successfullLoginMessage = "Login Successful";

	/*
	 * The test verifies if user is able to login successfully with valid
	 * credentials
	 */
	@Test
	public void verifyLoginWithValidCredentials() {
		loginPage = LoginPage.getLoginPage(driver);
		driver.get(configReader.getApplicationUrl());
		loginPage.inputUserLogin(configReader.getUserLogin());
		loginPage.inputUserPassword(configReader.getPassword());
		loginPage.clickLoginButton();
		loginPage.verifySuccessfulLogin(successfullLoginMessage);
	}

	/*
	 * The test verifies if user is unable to login with invalid credentials and error message is displayed
	 */
	@Test
	public void verifyLoginWithInValidCredentials() {
		loginPage = LoginPage.getLoginPage(driver);
		driver.get(configReader.getApplicationUrl());
		loginPage.inputUserLogin(configReader.getUserLogin());
		loginPage.inputUserPassword(configReader.getInvalidPassword());
		loginPage.clickLoginButton();
		loginPage.verifyErrorMessage(errorMessage);
	}

}
