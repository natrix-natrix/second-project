package ru.practicum.sprint4.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;
    private static final String QUESTION_CLASS_NAME = "accordion__heading-";
    private static final String ANSWER_CLASS_NAME = "accordion__panel-";

    //кнопка заказать вверху страницы
    private final By topOrderButton = By.className("Button_Button__ra12g");

    //кнопка заказать внизу страницы
    private final By bottomOrderButton = By.className("Button_Middle__1CSJM");

    //кнопка принятия куков
    private final By acceptCookieButton = By.className("App_CookieButton__3cvqF");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAnswerTextByNumber(int questionNumber) {
        driver.findElement(By.id(QUESTION_CLASS_NAME + questionNumber)).click();
        return driver.findElement(By.id(ANSWER_CLASS_NAME + questionNumber)).getText();
    }

    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
    }

    public void clickBottomOrderButton() {
        driver.findElement(bottomOrderButton).click();
    }

    public void clickAcceptCookie() {
        driver.findElement(acceptCookieButton).click();
    }
}
