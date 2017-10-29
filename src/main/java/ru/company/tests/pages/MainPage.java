package ru.company.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.company.tests.steps.BaseSteps;

/**
 * Created by Иванка on 26.10.2017.
 */
public class MainPage extends BasePage {

    @FindBy(xpath = "//div[@class='alt-menu-mid']")
    WebElement menuItem;

    @FindBy(xpath = "//li[@class='alt-menu-collapser alt-menu-collapser_branch alt-menu-collapser_opened alt-menu-collapser_delayed-hover alt-menu-mid__item']")
    WebElement menuInsurance;

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMenuItem(String itemName) {
        menuItem.findElement(By.xpath("./descendant::*[contains(text(), '"+ itemName +"')]")).click();
    }

    //a[contains(@class,'kit-link')][contains(text(), 'Страхование путешественников')]

    public void selectInsurenceItem(String insurenceItemName) {
        menuInsurance.findElement(By.xpath("./descendant::*[text()='" + insurenceItemName +"']")).click();
    }

}
