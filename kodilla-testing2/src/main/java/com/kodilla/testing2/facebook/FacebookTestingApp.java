package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {

    public static final String XPATH_BIRTHDAY_DAY = "//select[@name=\"birthday_day\" and @id=\"day\"]";
    public static final String XPATH_BIRTHDAY_MONTH = "//select[@name=\"birthday_month\" and @id=\"month\"]";
    public static final String XPATH_BIRTHDAY_YEAR = "//select[@name=\"birthday_year\" and @id=\"year\"]";

    public static final String XPATH_FIRSTNAME = "//input[@name=\"firstname\"]";
    public static final String XPATH_LASTNAME = "//input[@name=\"lastname\"]";
    public static final String XPATH_EMAIL = "//input[@name=\"reg_email__\"]";
    public static final String XPATH_PASSWORD = "//input[@name=\"reg_passwd__\"]";
    public static final String XPATH_SEX = "//span[@data-name=\"gender_wrapper\"]//input[@name=\"sex\" and @value=\"2\"]";
    public static final String XPATH_REGISTRATION = "//button[@name=\"websubmit\"]";
    public static final String XPATH_EMAIL_CONFIRMATION = "//input[@name=\"reg_email_confirmation__\"]";

    public static void main(String[] args) {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com");

        WebElement selectCombo = driver.findElement(By.xpath(XPATH_BIRTHDAY_DAY));
        Select comboDay = new Select(selectCombo);
        comboDay.selectByValue("4");
        selectCombo = driver.findElement(By.xpath(XPATH_BIRTHDAY_MONTH));
        Select comboMonth = new Select(selectCombo);
        comboMonth.selectByValue("6");
        selectCombo = driver.findElement(By.xpath(XPATH_BIRTHDAY_YEAR));
        Select comboYear = new Select(selectCombo);
        comboYear.selectByValue("1986");

        WebElement firstnameField = driver.findElement(By.xpath(XPATH_FIRSTNAME));
        firstnameField.sendKeys("test firstname");
        WebElement lastnameField = driver.findElement(By.xpath(XPATH_LASTNAME));
        lastnameField.sendKeys("test lastname");
        WebElement emailField = driver.findElement(By.xpath(XPATH_EMAIL));
        emailField.sendKeys("test.email@test.email.com");
        WebElement passwordField = driver.findElement(By.xpath(XPATH_PASSWORD));
        passwordField.sendKeys("testpassword");
        WebElement sexRadio = driver.findElement(By.xpath(XPATH_SEX));
        sexRadio.click();

        WebElement emailConfirmationField = driver.findElement(By.xpath(XPATH_EMAIL_CONFIRMATION));
        emailConfirmationField.sendKeys("test.email@test.email.com");

        WebElement registrationButton = driver.findElement(By.xpath(XPATH_REGISTRATION));
        registrationButton.click();
    }
}
