package PageObject.PageSteps;

import io.qameta.allure.Step;

import static PageObject.PageElements.MainPageElements.createTaskButton;
import static PageObject.PageElements.MainPageElements.messageSuccess;
import static PageObject.PageElements.MainPageElements.projectsMenu;
import static PageObject.PageElements.MainPageElements.testTESTProject;
import static PageObject.PageElements.MainPageElements.userProfileIcon;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;

public class MainPageSteps {
    @Step("Открываем список проектов")
    public static void openMenuOfProjects() {
        projectsMenu.shouldBe(visible).click();
    }

    @Step("Переходим в проект TestProject")
    public static void openTestProject() {
        testTESTProject.should(appear).click();
    }

    @Step("Переходим к созданию задачи")
    public static void openCreateTask() {
        createTaskButton.shouldBe(visible).click();
    }

    @Step("Получаем текст сообщения об успешном создании таски")
    public static String getSuccessMessageText() {
        return messageSuccess.shouldBe(appear).getText();
    }

    @Step("Проверяем есть ли иконка юзера")
    public static boolean isUserProfileIconVisible() {
        return userProfileIcon.is(visible);
    }

    @Step("Получаем имя текущего юзера")
    public static String getCurrentUsername() {
        return userProfileIcon.shouldHave(attribute("data-username")).attr("data-username");
    }
}
