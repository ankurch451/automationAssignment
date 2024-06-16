package com.strabag.pageObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.strabag.utils.WaitHelper;

public class LoginPage {
	private final WebDriver driver;

	private LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public static LoginPage getLoginPage(WebDriver driver) {
		return new LoginPage(driver);
	}

	private static By login_inputField = By.xpath("//input[@id='login-field']");
	private static By password_inputField = By.xpath("//input[@id='password-field']");
	private static By login_button = By.xpath("//input[@id='login-form-submit']");
	private static By errorMessage_text = By.xpath("//p[@id='login-error-msg']");
	private static By loginSuccessful_text = By.xpath("//h1[text()='Login Successful']");

	public void inputUserLogin(String userLogin) {
		driver.findElement(login_inputField).sendKeys(userLogin);
	}

	public void inputUserPassword(String password) {
		driver.findElement(password_inputField).sendKeys(password);
	}

	public String getLoginFailureErrorMessage() {
		WaitHelper.waitForElementVisible(driver, errorMessage_text);
		return driver.findElement(errorMessage_text).getText();
	}

	public String getSuccessLoginMessage() {
		WaitHelper.waitForElementVisible(driver, loginSuccessful_text);
		return driver.findElement(loginSuccessful_text).getText();
	}

	public void clickLoginButton() {
		driver.findElement(login_button).click();
	}

	public void verifySuccessfulLogin(String message) {
		assertTrue(driver.findElement(loginSuccessful_text).isDisplayed(),
				"Login Successful message is not displayed");
		assertEquals(message, getSuccessLoginMessage());
	}

	public void verifyErrorMessage(String message) {
		assertTrue(driver.findElement(errorMessage_text).isDisplayed(), "Error message is not displayed");
		assertEquals(message, getLoginFailureErrorMessage());
	}

}
