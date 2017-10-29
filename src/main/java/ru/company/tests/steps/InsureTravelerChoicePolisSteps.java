package ru.company.tests.steps;

import ru.company.tests.pages.InsureTravelerChoicePolis;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

/**
 * Created by Иванка on 28.10.2017.
 */
public class InsureTravelerChoicePolisSteps {

    @Step("выполнено нажание на кнопку {0}")
    public void selectInsureSum(String buttonName) {
        new InsureTravelerChoicePolis().selectInsureSum(buttonName);
    }

    @Step("выполнено нажание на кнопку {0}")
    public void cliclForm(String buttonName) {
        InsureTravelerChoicePolis insureTravelerChoicePolis = new InsureTravelerChoicePolis();
        insureTravelerChoicePolis.scrollToElement(insureTravelerChoicePolis.formBtn);
        insureTravelerChoicePolis.formBtn.click();
//        insureTravelerChoicePolis.waitElementVisibility(insureTravelerChoicePolis.formBtn);
//        new InsureTravelerChoicePolis().formBtn.click();
    }

}
