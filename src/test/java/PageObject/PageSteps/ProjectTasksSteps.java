package PageObject.PageSteps;

import io.qameta.allure.Step;

import static PageObject.PageElements.ProjectTasksPageElements.tasksCounter;
import static com.codeborne.selenide.Condition.visible;

public class ProjectTasksSteps {

    @Step("Получаем количество заведенных задач")
    public static void getCountOfExistsTask() {
        String taskCounter = tasksCounter.shouldBe(visible).getText();
        System.out.println("Количество заведенных задач: " + taskCounter);
    }
}
