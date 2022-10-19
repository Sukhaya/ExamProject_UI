package PageObject.PageSteps;

import io.qameta.allure.Step;

import static PageObject.PageElements.AuthorizationPageElements.loginButton;
import static PageObject.PageElements.AuthorizationPageElements.loginField;
import static PageObject.PageElements.AuthorizationPageElements.passwordField;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationPageSteps {
    @Step("Открываем страницу по ссылке")
    public static void openUrl(String url) {
        open(url);
    }

    @Step("Авторизуемся в системе")
    public static void authorization(String login, String password) {
        loginField.shouldBe(visible).sendKeys(login);
        passwordField.shouldBe(visible).sendKeys(password);
        loginButton.shouldBe(enabled).click();
    }
}
