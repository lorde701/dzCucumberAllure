package ru.company.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.company.tests.steps.BaseSteps;

/**
 * Created by Иванка on 27.10.2017.
 */
public class InsureTravelerChoicePolis extends BasePage{
    @FindBy(xpath = "//h3[contains(text(),'Выберите сумму страховой защиты')]")
    public WebElement fieldSumInsure;

    @FindBy(xpath = "//SPAN[text()='Оформить']")
    public WebElement formBtn;

    @FindBy(xpath = "//H1[text()='Страхование путешественников']")
    public WebElement insureTravelerTitle;

    public InsureTravelerChoicePolis() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectInsureSum (String buttonName) {
        WebElement element = fieldSumInsure.findElement(By.xpath("./following-sibling::div/descendant::*[text()='" + buttonName + "']"));
        scrollToElement(element);
        element.click();
        //fieldSumInsure.findElement(By.xpath("./following-sibling::div/descendant::*[text()='" + buttonName + "']")).click();
    }
}
