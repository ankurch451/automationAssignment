package com.strabag.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	
	/**
	 * This method waits for a specified duration until element is visible on page 
	 * @param driver
	 * @param locator
	 * @return
	 */
	public static WebElement waitForElementVisible(WebDriver driver, By locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(3))
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
