package PageObject.PageSteps;

import io.qameta.allure.Step;

import static PageObject.PageElements.CreateTaskPageElements.createIssueSubmitButton;
import static PageObject.PageElements.CreateTaskPageElements.issueDescriptionInput;
import static PageObject.PageElements.CreateTaskPageElements.issueDescriptionTogglerToText;
import static PageObject.PageElements.CreateTaskPageElements.issueSummaryInput;
import static PageObject.PageElements.CreateTaskPageElements.issueTypeDropdown;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;

public class CreateTaskPageSteps {

    @Step("Установим для задачи тип: {0}")
    public static void setType(String type) {
        issueTypeDropdown.shouldBe(visible).setValue(type).pressEnter();
    }

    @Step("Установим для задачи тему: {0}")
    public static void setSummary(String theme) {
        issueSummaryInput.shouldBe(visible).setValue(theme);
    }

    @Step("Установим для задачи описание: {0}")
    public static void setDescription(String description) {
        issueDescriptionTogglerToText.shouldBe(exist).click();
        issueDescriptionInput.shouldBe(exist).sendKeys(description);
    }

    @Step("Подтверждаем создание задачи")
    public static void clickAccept() {
        createIssueSubmitButton.shouldBe(visible).click();
    }
}
