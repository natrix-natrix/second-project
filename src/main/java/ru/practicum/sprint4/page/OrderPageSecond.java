package ru.practicum.sprint4.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrderPageSecond {

    private final WebDriver driver;

    //поле ввода даты
    private final By dateInput = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //поле выбора периода
    private final By periodInput = By.className("Dropdown-placeholder");

    //элемент выпадающего списка выбора периода
    private final By periodMenuElement = By.className("Dropdown-option");

    //поле выбора цвета
    private final By colorInput = By.xpath(".//input[@id='black']");

    //поле ввода комментария
    private final By commentInput = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    //кнопка далее
    private final By nextButton = By.xpath(".//button[(text()='Заказать') and contains(@class,'Button_Middle__1CSJM')]");

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public OrderPageSecond(WebDriver driver) {
        this.driver = driver;
    }

    public OrderPageSecond setDate(LocalDate yourDate) {
        driver.findElement(dateInput)
                .sendKeys(yourDate.format(formatter), Keys.ENTER);
        return this;
    }

    public OrderPageSecond setRentPeriod() {
        driver.findElement(periodInput).click();//   .sendKeys(Keys.DOWN,Keys.ENTER);
        driver.findElement(periodMenuElement).click();
        return this;
    }

    public OrderPageSecond setColor() {
        driver.findElement(colorInput).click();
        return this;
    }

    public OrderPageSecond setComment(String yourComment) {
        driver.findElement(commentInput).sendKeys(yourComment);
        return this;
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }


}
