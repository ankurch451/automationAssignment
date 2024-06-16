package com.strabag.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import com.strabag.core.DriverFactory;

public class BaseTest {
	protected WebDriver driver;

	@BeforeEach
	public void setup() {
		this.driver = DriverFactory.getDriver();
	}

	@AfterEach
	public void cleanup() {
		this.driver.quit();
	}

}
