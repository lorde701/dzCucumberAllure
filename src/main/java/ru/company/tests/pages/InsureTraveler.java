package ru.company.tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.company.tests.steps.BaseSteps;

/**
 * Created by Иванка on 27.10.2017.
 */
public class InsureTraveler extends BasePage {

    @FindBy(xpath = "//H1[text()='Страхование путешественников']")
    public WebElement insureTravelerLbl;

    @FindBy(xpath = "//IMG[@src='/portalserver/content/atom/contentRepository/content/person/travel/banner-zashita-traveler.jpg?id=f6c836e1-5c5c-4367-b0d0-bbfb96be9c53']")
    public WebElement formOnlineImg;

    public InsureTraveler() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void clickAndSwitch() {
        waitElementToBeClickable(formOnlineImg);
        switchToNewWindowOnClick(formOnlineImg, 10);
    }


}
