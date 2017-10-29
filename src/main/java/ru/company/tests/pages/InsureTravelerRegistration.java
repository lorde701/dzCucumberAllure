package ru.company.tests.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.company.tests.steps.BaseSteps;

/**
 * Created by Иванка on 27.10.2017.
 */
public class InsureTravelerRegistration extends BasePage{

    @FindBy(name = "insured0_surname")
    private WebElement insuredSurnameInput;

    @FindBy(name = "insured0_name")
    private WebElement insuredNameInput;

    @FindBy(name = "insured0_birthDate")
    private WebElement insuredBirthDateInput;

    @FindBy(name = "surname")
    private WebElement surenameInput;

    @FindBy(name = "name")
    private WebElement nameInput;

    @FindBy(name = "middlename")
    private WebElement middlenameInput;

    @FindBy(name = "birthDate")
    private WebElement birthDateInput;

    @FindBy(name = "passport_series")
    private WebElement passportSeriesInput;

    @FindBy(name = "passport_number")
    private WebElement passportNumberInput;

    @FindBy(name = "issueDate")
    private WebElement issueDateInput;

    @FindBy(name = "issuePlace")
    private WebElement issuePlaceInput;

    @FindBy(xpath = "//h4[text()='Телефон']/following-sibling::div/child::span")
    private WebElement errorMassegeNumberPhone;

    @FindBy(xpath = "//div[@class='b-button-block-center']")
    private WebElement sectionWithBtns;

    @FindBy(xpath = "//h3[text()='Контактные данные']/following-sibling::div")
    private WebElement sectionContactDate;

    public InsureTravelerRegistration() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void fillField(String field, String value) {
        switch (field) {
            case "Фамилия застрахованного":
                fillField(insuredSurnameInput, value);
                break;
            case "Имя застрахованного":
                fillField(insuredNameInput, value);
                break;
            case "Дата рождения застрахованного":
                fillField(insuredBirthDateInput, value);
                break;
            case "Фамилия страхователя":
                fillField(surenameInput, value);
                break;
            case "Имя страхователя":
                fillField(nameInput, value);
                break;
            case "Отчество страхователя":
                fillField(middlenameInput, value);
                break;
            case "Дата рождения страхователя":
                fillField(birthDateInput, value);
                break;
                default: throw new AssertionError("Поле '" + field + "' не объявлено на странице");
        }
    }

    public String getFillField(String field) {
        switch (field) {
            case "Фамилия застахованного":
               return insuredSurnameInput.getAttribute("value");
            case "Имя застахованного":
                return insuredNameInput.getAttribute("value");
            case "Дата рождения застрахованного":
                return insuredBirthDateInput.getAttribute("value");
            case "Фамилия страхователя":
                return surenameInput.getAttribute("value");
            case "Имя страхователя":
                return nameInput.getAttribute("value");
            case "Отчество страхователя":
                return middlenameInput.getAttribute("value");
            case "Дата рождения страхователя":
                return birthDateInput.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }

    public void clickContinueBtn(String btnName) {
        WebElement btn = sectionWithBtns.findElement(By.xpath("./*[text()='" + btnName +"']"));
        scrollToElement(btn);
        btn.click();
    }

    public void getErrorMessage(String field, String errorMes) {
//        WebElement tempWebElem = BaseSteps.getDriver().findElement(By.xpath("//SPAN[@ng-click='save()'][text()='Продолжить']"));
//        scrollToElement(tempWebElem);                      !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//        tempWebElem.click();

//        String xpath = "//h4[text()='" + field + "']/following-sibling::div/child::span";
//        String actualValue = BaseSteps.getDriver().findElement(By.xpath(xpath)).getText();

        String actualValue = sectionContactDate.findElement(By.xpath("./descendant::h4[text()='" + field + "']/following-sibling::div/child::span")).getText();

        Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMes), actualValue.contains(errorMes));
    }
}

