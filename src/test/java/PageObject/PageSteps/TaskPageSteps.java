package PageObject.PageSteps;

import io.qameta.allure.Step;

import static PageObject.PageElements.TaskPageElements.closeNotificationButton;
import static PageObject.PageElements.TaskPageElements.inProgressButton;
import static PageObject.PageElements.TaskPageElements.notificationPopup;
import static PageObject.PageElements.TaskPageElements.resolvedButton;
import static PageObject.PageElements.TaskPageElements.statusField;
import static PageObject.PageElements.TaskPageElements.toDoButton;
import static PageObject.PageElements.TaskPageElements.workFlowButton;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class TaskPageSteps {
    @Step("Меняем статус задачи - Нужно сделать")
    public static void changeStatusTodo() {
        toDoButton.shouldBe(visible).click();
        notificationPopup.should(appear);
        closeNotificationButton.shouldBe(visible).click();
    }

    @Step("Меняем статус задачи - В работе")
    public static void changeStatusInProgress() {
        inProgressButton.shouldBe(visible).click();
        notificationPopup.should(appear);
        closeNotificationButton.shouldBe(visible).click();
    }

    @Step("Меняем статус задачи - Выполнено")
    public static void changeStatusResolved() {
        workFlowButton.shouldBe(visible).click();
        resolvedButton.shouldBe(visible).click();
        notificationPopup.should(appear);
        closeNotificationButton.shouldBe(visible).click();
    }

    @Step("Проверяем смену статуса")
    public static void checkTaskStatus(String taskStatus) {
        statusField.shouldHave(text(taskStatus));
    }
}