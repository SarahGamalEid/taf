package com.test.automation.framework.keyword.google;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.test.automation.framework.keywordmodel.executor.KeywordExecutor;

public class GoogleKeywordTest {
		
	@Test
	public void googleSearchKeywordTest(){
		WebDriver driver = new FirefoxDriver();
		File file = new File("src/test/resources/GoogleKeywordTest.xls");
		KeywordExecutor keyExecutor = new KeywordExecutor(driver, file,(String[]) null);
		keyExecutor.execute();
		driver.quit();
	}

}
