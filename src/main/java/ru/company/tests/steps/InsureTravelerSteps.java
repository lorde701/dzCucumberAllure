package ru.company.tests.steps;

import ru.company.tests.pages.InsureTraveler;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

/**
 * Created by Иванка on 28.10.2017.
 */
public class InsureTravelerSteps {


    @Step("заголовок страницы - {0}")
    public void checkWindowTitle(String expectedWindowTitle) {
        String actualWindowTitle = new InsureTraveler().insureTravelerLbl.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]", actualWindowTitle, expectedWindowTitle), actualWindowTitle.equals(expectedWindowTitle));
    }

    @Step("выполнено нажание на картинку")
    public void clickOnImg() {
        new InsureTraveler().clickAndSwitch();
    }
}
