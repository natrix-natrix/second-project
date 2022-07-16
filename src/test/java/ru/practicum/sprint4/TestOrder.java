package ru.practicum.sprint4;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.practicum.sprint4.page.*;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;

public class TestOrder extends BaseTest {

    @Before
    public void clearCookie() {
        driver.manage().deleteAllCookies();
    }

    @Test
    public void topOrderButtonTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, 3);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAcceptCookie();
        mainPage.clickTopOrderButton();

        orderSteps();
    }

    @Test
    public void bottomOrderButtonTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, 3);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAcceptCookie();
        mainPage.clickBottomOrderButton();

        orderSteps();
    }

    private void orderSteps() {
        OrderPageFirst orderPageFirst = new OrderPageFirst(driver);
        orderPageFirst.setName("Александр")
                .setSurname("Пушкин")
                .setAddress("Царское село")
                .setStationMetro()
                .setTelephone("89084799888")
                .clickNextButton();

        OrderPageSecond orderPageSecond = new OrderPageSecond(driver);
        orderPageSecond.setDate(LocalDate.now())
                .setRentPeriod()
                .setColor()
                .setComment("Будьте бдительны и храбры перед лицом страшного хухунделя")
                .clickNextButton();

        OrderPageThird orderPageThird = new OrderPageThird(driver);
        orderPageThird.clickYesButton();

        OrderPageFinish orderPageFinish = new OrderPageFinish(driver);
        assertTrue(orderPageFinish.isOrderComplete());
    }


}
