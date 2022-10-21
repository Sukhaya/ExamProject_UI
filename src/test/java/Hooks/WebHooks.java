package Hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static PageObject.PageSteps.AuthorizationPageSteps.authorization;
import static PageObject.PageSteps.AuthorizationPageSteps.openUrl;
import static Utils.Configuration.getConfigurationValue;

public class WebHooks extends AllureResponseRename {
    @BeforeAll()
    public static void setDriverFromProp() {
        Configuration.startMaximized = true;
    }

    @BeforeEach
    public void open() {
        openUrl(getConfigurationValue("jiraUrl"));
        authorization(getConfigurationValue("login"), getConfigurationValue("password"));
    }

    @AfterEach()
    public void closeDriver() {
        WebDriverRunner.closeWebDriver();
    }

}
