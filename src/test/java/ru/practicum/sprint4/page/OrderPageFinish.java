package ru.practicum.sprint4.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPageFinish {

    private final WebDriver driver;

    //статус заказа
    private final By orderStatusText = By.className("Order_ModalHeader__3FDaJ");

    public OrderPageFinish(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOrderComplete() {
        return driver.findElement(orderStatusText).getText().contains("Заказ оформлен");
    }

}
