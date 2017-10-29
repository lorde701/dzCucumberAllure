package ru.company.tests.steps;

import ru.company.tests.pages.InsureTravelerRegistration;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

/**
 * Created by Иванка on 28.10.2017.
 */
public class InsureTravelerRegistrationSteps {

    InsureTravelerRegistration insureTravelerRegistration = new InsureTravelerRegistration();

    @Step("поле {0} заполняется значением {1}")
    public void fillField(String field, String value) {
        insureTravelerRegistration.fillField(field, value);
    }

    @Step("поле {0} заполнено значением {1}")
    public void checkFillField(String field, String value) {
        String actual = insureTravelerRegistration.getFillField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value), actual.equals(value));
    }

    @Step("заполняются поля")
    public void fillField(HashMap<String, String> fields) {
        fields.forEach(this::fillField);
    }

    @Step("поля заполнены верно")
    public void checkFillField(HashMap<String, String> fields) {
        fields.forEach(this::checkFillField);
    }

    @Step("в поле {0} присутствует сообщение об ошибке {1}")
    public void getErrorMess(String field, String errorMes) {
        insureTravelerRegistration.getErrorMessage(field, errorMes);
    }

    @Step
    public void clickContinue(String btnName) {
        insureTravelerRegistration.clickContinueBtn(btnName);
    }
}


//    Когда произошло нажатие на кнопку "Продолжить"
//        Тогда появится сообщение об ошибке "Заполнены не все обязательные поля"