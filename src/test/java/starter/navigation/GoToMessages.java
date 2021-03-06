package starter.navigation;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class GoToMessages {
    NavigateTo navigateTo;

    @Step("Open messages tab")
    public void openMessagesTab() {
        WebDriver driver = getDriver();
        String log = driver.findElement(By.id("log")).getText();
        System.out.println("log = " + log);

        driver.findElement(By.linkText("message")).click();
    }
}