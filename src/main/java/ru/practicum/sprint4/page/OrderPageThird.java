package ru.practicum.sprint4.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPageThird {

    private final WebDriver driver;


    //кнопка согласия
    private final By yesButton = By.xpath(".//button[text()='Да']");
    ;

    public OrderPageThird(WebDriver driver) {
        this.driver = driver;
    }

    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }
}
