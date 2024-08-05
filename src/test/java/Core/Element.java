package Core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Element {
    private By by;

    public Element(By by) {
        this.by = by;
    }

    public By getBy() {
        return by;
    }

    public void setBy(By by) {
        this.by = by;
    }
    public WebElement waitForElementToBeVisible() {
        return DriverManager.wait.until(ExpectedConditions.visibilityOfElementLocated(this.by));
    }

    public boolean isElementDisplayed() {
        try {
            return DriverManager.wait.until(ExpectedConditions.visibilityOfElementLocated(this.by)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement waitForElementToBeClickable() {
        return DriverManager.wait.until(ExpectedConditions.elementToBeClickable(this.by));
    }

    public void waitForElementGotoUrl(String url) {
        DriverManager.wait.until(ExpectedConditions.urlToBe(url));
    }

    public void enterText(String text) {
        WebElement webElement = this.waitForElementToBeVisible();
        webElement.clear();
        webElement.sendKeys(text);
    }

    public void clickOnElement() {
        this.scrollToElement();
        this.waitForElementToBeClickable().click();
    }

    public void submitOnElement() {
        this.scrollToElement();
        this.waitForElementToBeClickable().submit();
    }

    public void selectDropdownByValue(String value) {
        WebElement webElement = this.waitForElementToBeVisible();
        Select selectElement = new Select(webElement);
        selectElement.selectByValue(value);
    }

    public String getTextElement() {
        return this.waitForElementToBeVisible().getText();
    }

    public void selectDateFromDatePicker(String date) {
        WebElement webElement = this.waitForElementToBeVisible();
        webElement.sendKeys(Keys.CONTROL + "a");
        webElement.sendKeys(date);
    }

    public String getCurrentUrl() {
        String initialUrl = DriverManager.webDriver.getCurrentUrl();
        DriverManager.wait.until(driver -> {
            String currentUrl = driver.getCurrentUrl();
            return currentUrl != null && !currentUrl.equals(initialUrl);
        });
        return DriverManager.webDriver.getCurrentUrl();
    }

    public List<WebElement> convertByToListIWebElements() {
        List<WebElement> webElements = DriverManager.webDriver.findElements(this.by);
        return new ArrayList<>(webElements);
    }

    public void scrollToElement() {
        WebElement webElement = DriverManager.webDriver.findElement(this.by);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.webDriver;
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }
}
