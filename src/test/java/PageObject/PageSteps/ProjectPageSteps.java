package PageObject.PageSteps;

import io.qameta.allure.Step;

import static PageObject.PageElements.ProjectPageElements.menuButton;
import static PageObject.PageElements.ProjectPageElements.projectSidebar;
import static PageObject.PageElements.ProjectPageElements.projectTitle;
import static PageObject.PageElements.ProjectPageElements.softwareVersion;
import static PageObject.PageElements.ProjectPageElements.taskLink;
import static PageObject.PageElements.ProjectPageElements.taskStatus;
import static PageObject.PageElements.ProjectPageElements.tasks;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class ProjectPageSteps {

    @Step("Открываем страницу задач")
    public static void openTasksPage() {
        openMenu("Задачи");
    }

    @Step("Открываем страницу списка задач")
    public static void openIssuesPage() {
        openMenu("Список задач");
    }

    @Step("Переходим в задачу: {0}")
    public static void openTask(String taskName) {
        tasks.filter(text(taskName)).shouldHave(sizeGreaterThan(0)).first().click();
    }

    @Step("Открываем страницу текущей задачи")
    public static void openTaskPage() {
        taskLink.shouldBe(visible).click();
    }

    @Step("Проверяем статус задачи и выводим привязку к версии")
    public static void checkStatusAndVersion() {
        String svText = softwareVersion.shouldBe(visible).getText();
        String taskStatusText = taskStatus.shouldBe(visible).getText();
        System.out.println("Software version: " + svText + "\nTask status: " + taskStatusText);
    }

    @Step("Получаем название текущего открытого проекта")
    public static String getProjectTitle() {
        return projectTitle.shouldBe(exist).innerText();
    }

    @Step("Проверяем появилась ли боковая панель проекта")
    public static boolean isProjectSidebarAppears() {
        return projectSidebar.is(appear);
    }

    private static void openMenu(String menuTitle) {
        menuButton(menuTitle).shouldBe(visible).click();
    }
}
