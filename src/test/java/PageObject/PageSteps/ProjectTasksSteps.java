package PageObject.PageSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static PageObject.PageElements.ProjectTasksPageElements.tasksCounter;
import static com.codeborne.selenide.Condition.visible;

public class ProjectTasksSteps {

    @Step("Получаем количество заведенных задач")
    public static String getCountOfExistsTask() {
        String counter = tasksCounter.shouldBe(visible).getText();
        return tasksCounter.shouldHave(Condition.exactText(counter)).getText().substring("1 из ".length());
    }
}
