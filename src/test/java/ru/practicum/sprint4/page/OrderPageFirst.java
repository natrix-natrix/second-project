package ru.practicum.sprint4.page;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPageFirst {

    private final WebDriver driver;

    //поле ввода имени
    private final By nameInput = By.xpath(".//input[@placeholder='* Имя']");

    //поле ввода фамилии
    private final By surnameInput = By.xpath(".//input[@placeholder='* Фамилия']");

    //поле ввода адреса
    private final By addressInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //поле ввода станции метро
    private final By stationMetroInput =By.xpath(".//input[@placeholder='* Станция метро']");

    //поле ввода телефона
    private final By telephoneInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //кнопка далее
    private final By nextButton = By.className("Button_Middle__1CSJM");

    public OrderPageFirst(WebDriver driver) {
        this.driver = driver;
    }

    public OrderPageFirst setName(String yourName) {
        driver.findElement(nameInput).sendKeys(yourName);
        return this;
    }

    public  OrderPageFirst setSurname(String yourSurname) {
        driver.findElement(surnameInput).sendKeys(yourSurname);
        return this;
    }
    public  OrderPageFirst setAddress(String yourAddress) {
        driver.findElement(addressInput).sendKeys(yourAddress);
        return this;
    }
    public  OrderPageFirst setStationMetro() {
        driver.findElement(stationMetroInput).sendKeys(Keys.DOWN,Keys.ENTER);
        return this;
    }
    public  OrderPageFirst setTelephone(String yourTelephone) {
        driver.findElement(telephoneInput).sendKeys(yourTelephone);
        return this;
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }


}
