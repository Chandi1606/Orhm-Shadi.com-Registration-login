package com.gqt.testngtestcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrhmLoginTest {
	
	WebDriver driver;
	String unTfKey;
	String passtfKey;
	String loginBtnKey;
	String profileBtnKey;
	String logoutLinkKey;
	
	@BeforeTest
	@Parameters({"unTf","passtf","loginBtn","profileBtn","logoutLink"})
	public void getXpathsFromXml(String unTfKey,String passTfKey,
			String loginBtnKey,String profileBtnKey,String logoutLinkKey) {
		
		this.unTfKey=unTfKey;
		this.passtfKey=passTfKey;
		this.loginBtnKey=loginBtnKey;
		this.profileBtnKey=profileBtnKey;
		this.logoutLinkKey=logoutLinkKey;

	}
	
	
	@BeforeClass
	public void setupBrowser() {
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2000));
	}
	
	@BeforeMethod
	@Parameters({"url"})
	public void navigateToLoginPage(String urlData) throws Exception {
		driver.get(urlData);
		Thread.sleep(2000);
	}
	
	@Test(dataProvider = "LoginProvider",dataProviderClass = OrhmLoginDatas.class)
	public void OrhmDemoLoginTest(String unData,String passData) throws Exception {
	
		//login page
		driver.findElement(By.xpath(unTfKey)).sendKeys(unData);
		driver.findElement(By.xpath(passtfKey)).sendKeys(passData);
		Thread.sleep(2000);
		driver.findElement(By.xpath(loginBtnKey)).click();
		Thread.sleep(2000);
		
		//homepage
		driver.findElement(By.xpath(profileBtnKey)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(logoutLinkKey)).click();
		Thread.sleep(2000);
		
    }
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}
