package starter.clicks;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class SendMessage {
    @Step("Open messages tab")
    public void send() {
        WebDriver driver = getDriver();
        driver.findElement(By.name("send")).click();
    }
}
