package ru.company.tests.steps;

import ru.company.tests.pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Иванка on 27.10.2017.
 */
public class MainPageSteps {

    @Step("выбран пункт меню {0}")
    public void selectMenuItem(String menuItem) {
        new MainPage().selectMenuItem(menuItem);
    }

    @Step("выбран пункт меню {0}")
    public void selectMenuInsurance(String menuItem) {
        new MainPage().selectInsurenceItem(menuItem);
    }


}
