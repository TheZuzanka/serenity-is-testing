package starter.enteringData;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class WriteMessage {
    @Step("Write message")
    public void addToFiels(String text) {
        WebDriver driver = getDriver();
        driver.findElement(By.name("Data")).sendKeys(text);
    }
}
