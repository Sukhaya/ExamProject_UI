package hooks;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;

public class WebHooks {
    @BeforeAll()
    public static void setDriverFromProp() {
        Configuration.startMaximized = true;
    }

    @AfterEach()
    public void closeDriver() {
        WebDriverRunner.closeWebDriver();
    }

}
