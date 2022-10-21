import Hooks.WebHooks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static PageObject.PageSteps.CreateTaskPageSteps.clickAccept;
import static PageObject.PageSteps.CreateTaskPageSteps.setDescription;
import static PageObject.PageSteps.CreateTaskPageSteps.setSummary;
import static PageObject.PageSteps.CreateTaskPageSteps.setType;
import static PageObject.PageSteps.MainPageSteps.getCurrentUsername;
import static PageObject.PageSteps.MainPageSteps.getSuccessMessageText;
import static PageObject.PageSteps.MainPageSteps.isUserProfileIconVisible;
import static PageObject.PageSteps.MainPageSteps.openCreateTask;
import static PageObject.PageSteps.MainPageSteps.openMenuOfProjects;
import static PageObject.PageSteps.MainPageSteps.openTestProject;
import static PageObject.PageSteps.ProjectPageSteps.checkStatus;
import static PageObject.PageSteps.ProjectPageSteps.checkVersion;
import static PageObject.PageSteps.ProjectPageSteps.getProjectTitle;
import static PageObject.PageSteps.ProjectPageSteps.isProjectSidebarAppears;
import static PageObject.PageSteps.ProjectPageSteps.openIssuesPage;
import static PageObject.PageSteps.ProjectPageSteps.openTask;
import static PageObject.PageSteps.ProjectPageSteps.openTaskPage;
import static PageObject.PageSteps.ProjectPageSteps.openTasksPage;
import static PageObject.PageSteps.ProjectTasksSteps.getCountOfExistsTask;
import static PageObject.PageSteps.TaskPageSteps.changeStatusInProgress;
import static PageObject.PageSteps.TaskPageSteps.changeStatusResolved;
import static PageObject.PageSteps.TaskPageSteps.changeStatusTodo;
import static PageObject.PageSteps.TaskPageSteps.checkTaskStatus;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static Utils.Configuration.getConfigurationValue;

public class TestJira extends WebHooks {

    @Test
    @DisplayName("Проверка авторизации")
    public void Test_Login() {
        assertTrue(isUserProfileIconVisible());
        assertEquals(getConfigurationValue("login"), getCurrentUsername());
    }


    @Test
    @DisplayName("Переходим в проект TestProject")
    public void Test_ChoosingProject() {
        openMenuOfProjects();
        openTestProject();
        assertTrue(isProjectSidebarAppears());
        assertEquals(getConfigurationValue("PROJECT"), getProjectTitle());
    }


    @Test
    @DisplayName("Проверка количества задач в проекте")
    public void Test_CountTasks() {
        openMenuOfProjects();
        openTestProject();
        openTasksPage();
        getCountOfExistsTask();
    }


    @Test
    @DisplayName("Проверка статуса и привязки")
    public void Test_StatusAndVersion() {
        openMenuOfProjects();
        openTestProject();
        openIssuesPage();
        openTask("TestSelenium_bug");
        assertTrue(checkStatus().length() > 0, "Статус задачи не задан");
        assertTrue(checkVersion().length() > 0, "Версия для исправления не записана");
    }

    @Test
    @DisplayName("Проверка заведения баг-репорта")
    public void Test_CreateTask() {
        openCreateTask();
        setType("ошибка");
        setSummary("Нет поиска по задачам");
        setDescription("Шаги \n # открыть jira \n открыть проект");
        clickAccept();
        assertTrue(getSuccessMessageText().contains("Нет поиска по задачам"));
    }

    @Test
    @DisplayName("Проверка смена статусов задачи")
    public void Test_MoveTaskToResolved() {
        openCreateTask();
        setType("ошибка");
        setSummary("Нет поиска по задачам");
        setDescription("Шаги \n # открыть jira \n открыть проект");
        clickAccept();
        openMenuOfProjects();
        openTestProject();
        openIssuesPage();
        openTask("Нет поиска по задачам");
        openTaskPage();
        changeStatusTodo();
        checkTaskStatus("СДЕЛАТЬ");
        changeStatusInProgress();
        checkTaskStatus("В РАБОТЕ");
        changeStatusResolved();
        checkTaskStatus("ГОТОВО");
    }
}
