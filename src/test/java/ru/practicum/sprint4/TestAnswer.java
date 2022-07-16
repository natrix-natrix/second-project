package ru.practicum.sprint4;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.practicum.sprint4.page.MainPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestAnswer extends BaseTest {
    private static MainPage MAIN_PAGE;
    private final String expectedAnswerText;
    private final int questionNumber;

    public TestAnswer(int questionNumber, String expectedAnswerText) {
        this.expectedAnswerText = expectedAnswerText;
        this.questionNumber = questionNumber;
    }

    @BeforeClass
    public static void getMainPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, 3);
        MAIN_PAGE = new MainPage(driver);
        MAIN_PAGE.clickAcceptCookie();
        new WebDriverWait(driver, 1);

    }

    @Test
    public void testAnswersForQuestion() {
        String actualAnswerText = MAIN_PAGE.getAnswerTextByNumber(questionNumber);
        assertEquals(expectedAnswerText, actualAnswerText);
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }
}
