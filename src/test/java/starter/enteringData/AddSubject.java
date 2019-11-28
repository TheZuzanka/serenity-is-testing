package starter.enteringData;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class AddSubject {
    @Step("Enter subject")
    public void enterSubject(String subject) {
        WebDriver driver = getDriver();
        driver.findElement(By.name("Subject")).sendKeys(subject);
    }
}
