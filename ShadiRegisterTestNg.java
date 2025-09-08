package com.gqt.testngtestcases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class ShadiRegisterTestNg {

    WebDriver driver;

    String firstNameTfKey;
    String lastNameTfKey;
    String genderBtn1Key;
    String genderBtn2Key;
    String emailTfKey;
    String passTfKey;
    String submitBtnKey;
    String monthDrop;
    String dayDrop;
    String yearDrop;
    String religionDrop;
    String educationDrop;
    String countryDrop;

    @BeforeTest
    @Parameters({
        "firstNameTf", "lastNameTf", "genderBtn1", "genderBtn2",
        "emailTf", "passTf", "submitBtn",
        "monthDrop", "dayDrop", "yearDrop",
        "religionDrop", "educationDrop", "countryDrop"
    })
    public void getXpathsFromXml(String firstNameTfKey, String lastNameTfKey,
                                 String genderBtn1Key, String genderBtn2Key,
                                 String emailTfKey, String passTfKey, String submitBtnKey,
                                 String monthDrop, String dayDrop, String yearDrop,
                                 String religionDrop, String educationDrop, String countryDrop) {

        this.firstNameTfKey = firstNameTfKey;
        this.lastNameTfKey = lastNameTfKey;
        this.genderBtn1Key = genderBtn1Key;
        this.genderBtn2Key = genderBtn2Key;
        this.emailTfKey = emailTfKey;
        this.passTfKey = passTfKey;
        this.submitBtnKey = submitBtnKey;
        this.monthDrop = monthDrop;
        this.dayDrop = dayDrop;
        this.yearDrop = yearDrop;
        this.religionDrop = religionDrop;
        this.educationDrop = educationDrop;
        this.countryDrop = countryDrop;
    }

    @BeforeClass
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }

    @BeforeMethod
    @Parameters("url")
    public void navigateToRegisterPage(String url) throws Exception {
        driver.get(url);
        Thread.sleep(2000);
    }

    @Test(dataProvider = "RegisterData", dataProviderClass = ShadiRegisterDatas.class)
    public void registerWithClassData(String fnData, String lnData,
                                      String gender, String emailData, String passData) throws Exception {

        driver.findElement(By.xpath(firstNameTfKey)).sendKeys(fnData);
        Thread.sleep(500);
        driver.findElement(By.xpath(lastNameTfKey)).sendKeys(lnData);
        Thread.sleep(500);

        // Gender selection based on data
        if (gender.equalsIgnoreCase("Female")) {
            driver.findElement(By.xpath(genderBtn1Key)).click();
        } else {
            driver.findElement(By.xpath(genderBtn2Key)).click();
        }
        Thread.sleep(500);

        new Select(driver.findElement(By.xpath(monthDrop))).selectByVisibleText("May");
        new Select(driver.findElement(By.xpath(dayDrop))).selectByVisibleText("17");
        new Select(driver.findElement(By.xpath(yearDrop))).selectByVisibleText("1995");

        new Select(driver.findElement(By.xpath(religionDrop))).selectByVisibleText("Hinduism");
        new Select(driver.findElement(By.xpath(educationDrop))).selectByVisibleText("Masters");
        new Select(driver.findElement(By.xpath(countryDrop))).selectByVisibleText("India");

        driver.findElement(By.xpath(emailTfKey)).sendKeys(emailData);
        Thread.sleep(500);
        driver.findElement(By.xpath(passTfKey)).sendKeys(passData);
        Thread.sleep(500);
        driver.findElement(By.xpath(submitBtnKey)).click();
        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
