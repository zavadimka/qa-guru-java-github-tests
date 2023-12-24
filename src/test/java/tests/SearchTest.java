package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class SearchTest extends TestBase {

    @Test
    @DisplayName("Check label \"Successful search\"")
    void successfulSearchTest() {
        step("Open mane page", () ->
                open("https://github.com/"));

        step("Click search button", () ->
                $(".header-search-button").click());

        step("Set search value", () ->
                $("#query-builder-test").setValue("qa.guru").pressEnter());

        step("Non-zero result check", () ->
                $("#search-results-count").shouldNotHave(text("0 results")));

        step("Check the search result value", () ->
                $("[data-testid='results-list']").shouldHave(text("qa-guru/niffler")));
    }

    @Test
    @DisplayName("Check label \"Unsuccessful search\"")
    void unsuccessfulSearchTest() {
        step("Open mane page", () ->
                open("https://github.com/"));

        step("Click search button", () ->
                $(".header-search-button").click());

        step("Set search value", () ->
                $("#query-builder-test").setValue("sdghs9etu").pressEnter());

        step("Zero result check", () ->
                $("#search-results-count").shouldHave(text("0 results")));
    }
}
