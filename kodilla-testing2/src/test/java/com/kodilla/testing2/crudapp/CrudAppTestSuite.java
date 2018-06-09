package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CrudAppTestSuite {

    private static final String BASE_URL = "https://pflaz.github.io";
    private WebDriver driver;
    private Random generator;

    @Before
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @After
    public void cleanUpAfterTest() {
        driver.close();
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        try {
            Assert.assertTrue(checkTaskExistsInTrello(taskName));
        } finally {
            deleteTaskFromCrudApp(taskName);
        }
    }

    private void deleteTaskFromCrudApp(String taskName) throws InterruptedException {
        driver.get(BASE_URL);
        Thread.sleep(2000);
        String xPathRowsWithTask = "//form[@class=\"datatable__row\" and contains(.//p, '" + taskName + "')]";
        List<WebElement> rowsWithTask = driver.findElements(By.xpath(xPathRowsWithTask));
        rowsWithTask.stream()
                .forEach(
                        row -> {
                            row.findElement(By.xpath(".//button[contains(text(), 'Delete')]")).click();
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                // do nothing
                            }
                        }
                );

    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action,\"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action,\"createTask\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action,\"createTask\")]/fieldset[3]/button";
        String taskName = "Task " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);
        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);
        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(2000);
        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        while(!driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                        .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard = theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                    wait.until(ExpectedConditions.alertIsPresent());
                    Alert alert = driver.switchTo().alert();
                    alert.accept();
                });
        Thread.sleep(5000);
    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);

        driverTrello.findElement(By.id("user")).sendKeys("LOGIN");
        driverTrello.findElement(By.id("password")).sendKeys("PASS");
        driverTrello.findElement(By.id("login")).submit();


        Thread.sleep(5000);
        driverTrello.findElement(By.xpath("//a[contains(@href, \"/boards\")]")).click();
        Thread.sleep(7000);

        driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()
                .filter(aHref -> aHref.findElements(By.xpath(".//span[@title=\"Kodilla application\"]")).size() > 0)
                .forEach(aHref -> aHref.click());
        Thread.sleep(10000);

        result = driverTrello.findElements(By.xpath("//span")).stream()
                .filter(theSpan -> theSpan.getText().contains(taskName))
                .collect(Collectors.toList())
                .size() > 0;

        driverTrello.close();
        return result;
    }

    private void deleteTestTaskFromTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);

        driverTrello.findElement(By.id("user")).sendKeys("LOGIN");
        driverTrello.findElement(By.id("password")).sendKeys("PASS");
        driverTrello.findElement(By.id("login")).submit();

        Thread.sleep(5000);

        driverTrello.findElement(By.xpath("//a[contains(@href, \"/boards\")]")).click();
        Thread.sleep(10000);

        driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()
                .filter(aHref -> aHref.findElements(By.xpath(".//span[@title=\"Kodilla application\"]")).size() > 0)
                .forEach(aHref -> aHref.click());
        Thread.sleep(10000);

        String xPathSpanWithTaskName = "//span[contains(text(), \"" + taskName + "\")]";
        WebElement spanWithTaskName = driverTrello.findElement(By.xpath(xPathSpanWithTaskName));
        WebElement spanToFocus = spanWithTaskName.findElement(By.xpath(".."));
        new Actions(driverTrello).moveToElement(spanToFocus).perform();
        Thread.sleep(2000);
        WebElement buttonToClick = spanToFocus.findElement(By.xpath("../..//span[contains(@class, 'icon-expand')]"));
        buttonToClick.click();
        Thread.sleep(2000);
        WebElement archiveButton = driverTrello.findElement(By.xpath("//a[contains(@class, 'js-archive-card')]"));
        archiveButton.click();
        Thread.sleep(2000);
        WebElement deleteButton = driverTrello.findElement(By.xpath("//a[contains(@class, 'js-delete-card')]"));
        deleteButton.click();
        Thread.sleep(2000);
        WebElement confirmButton = driverTrello.findElement(By.xpath("//input[contains(@class, 'js-confirm')]"));
        confirmButton.click();
        Thread.sleep(2000);

    }
}
