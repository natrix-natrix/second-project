package ru.practicum.sprint4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.practicum.sprint4.page.*;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class TestOrder {
    private WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void topOrderButtonTest() {
        ChromeOptions options = new ChromeOptions(); //Драйвер для браузера
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, 3);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAcceptCookie();
        mainPage.clickTopOrderButton();

        orderSteps();
    }

    @Test
    public void bottomOrderButtonTest() {
        ChromeOptions options = new ChromeOptions(); //Драйвер для браузера
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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

    @After
    public void teardown() {
        driver.quit();
    }

}
