package ru.company.tests.pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.company.tests.steps.BaseSteps;

import javax.swing.*;
import java.util.Set;

/**
 * Created by Иванка on 26.10.2017.
 */
public class BasePage {
    public void fillField(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void checkField(WebElement element, String text) {
        String expectedText = element.getText();
        if (expectedText.equals("")) {
            expectedText = element.getAttribute("value");
        }
        Assert.assertEquals(text, expectedText);
    }

    public void waitElementVisibility(WebElement element) {
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElementToBeClickable(WebElement element) {
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 5, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void switchToNewWindowOnClick(WebElement element, long timeOutInSec) {
        final Set<String> oldWindowsSet = BaseSteps.getDriver().getWindowHandles();
        scrollToElement(element);
        waitElementToBeClickable(element);
        element.click();
        String newWindowHandle = (new WebDriverWait(BaseSteps.getDriver(), timeOutInSec))
                .until(new ExpectedCondition<String>() {
                           public String apply(WebDriver driver) {
                               Set<String> newWindowsSet = driver.getWindowHandles();
                               newWindowsSet.removeAll(oldWindowsSet);
                               return newWindowsSet.size() > 0 ?
                                       newWindowsSet.iterator().next() : null;
                           }
                       }
                );
        BaseSteps.getDriver().switchTo().window(newWindowHandle);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)BaseSteps.getDriver();
        js.executeScript("arguments[0].scrollIntoView()", element);
//        Actions actions = new Actions(BaseSteps.getDriver());
//        actions.moveToElement(element).click().perform();
    }
}
