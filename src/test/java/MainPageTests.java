import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class MainPageTests extends TestBase {

    @Test
    @DisplayName("Check label \"Let’s build from here\" on main page")
    void headerTextTest() {
        step("Open main page", () ->
                open("https://github.com/"));

        step("Check label in header", () ->
                $(".home-campaign-hero").shouldHave(text("Let’s build from here")));
    }

    @Test
    void secondTest() {

    }

    @Test
    void thirdTest() {

    }
}
