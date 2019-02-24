package com.qa.app.keyword.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver init_driver(String browserName) {

		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			if(prop.getProperty("headless").equals("yes")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			}else
			{
				driver = new ChromeDriver();
			}
		}
		return driver;
	}
	
	public Properties init_properties() {
		prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream("/Users/jigarsony/Automation/WorkSpace/KeywordDrivenFramework/src/"
					+ "main/java/com/qa/app/keyword/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}

}
