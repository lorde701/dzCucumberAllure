package ru.company.tests.steps;

import com.sun.jmx.snmp.SnmpStringFixed;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by Иванка on 27.10.2017.
 */
public class ScenariosSteps {

    MainPageSteps mainPageSteps = new MainPageSteps();
    InsureTravelerSteps insureTravelerSteps = new InsureTravelerSteps();
    InsureTravelerChoicePolisSteps insureTravelerChoicePolisSteps = new InsureTravelerChoicePolisSteps();
    InsureTravelerRegistrationSteps insureTravelerRegistrationSteps = new InsureTravelerRegistrationSteps();

    @When("^выбран пункт меню1 \"(.+)\"$")
    public void selectMenuItem(String menuItem) {
        mainPageSteps.selectMenuItem(menuItem);
    }

    @When("^выбран пункт меню \"(.+)\"$")
    public void selectMenuIns(String menuItem) {
        mainPageSteps.selectMenuInsurance(menuItem);
    }

    @Then("^заголовок страницы - \"(.+)\"$")
    public void checkTitle(String title) {
        insureTravelerSteps.checkWindowTitle(title);
    }

    @When("^выполнено нажатие на картинку$")
    public void clickImg() {
        insureTravelerSteps.clickOnImg();
    }

    @When("^выполнено нажание на кнопку \"(.+)\"$")
    public void clickButton(String buttonName) {
        insureTravelerChoicePolisSteps.selectInsureSum(buttonName);
    }

    @When("^выполнено нажатие на кнопку \"(.+)\"$")
    public void clickButtonForm(String str) {
        insureTravelerChoicePolisSteps.cliclForm(str);
    }

    @When("^заполнены поля:$")
    public void fillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> insureTravelerRegistrationSteps.fillField(field, value));
    }

    @Then("^значения полей равны:$")
    public void checkFillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> insureTravelerRegistrationSteps.checkFillField(field, value));
    }

//    @When("^произошло нажатие на кнопку \"(.+)\"$")
//    public void clickContinueBtn(String nameBtn) {
//        cx
//    }
    @When("^кнопка \"(.+)\" нажата$")
    public void ckickContinueBtn (String btnName) {
        insureTravelerRegistrationSteps.clickContinue(btnName);
    }


    @Then("^в поле \"(.+)\" присутствует сообщение об ошибке \"(.+)\"$")
    public void checkErrorMes(String field, String errorMes) {
        insureTravelerRegistrationSteps.getErrorMess(field, errorMes);
    }
}
