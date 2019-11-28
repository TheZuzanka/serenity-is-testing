package starter.enteringData;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class AddEmail {
    @Step("Enter email")
    public void enterEmail(String email) {
        WebDriver driver = getDriver();
        driver.findElement(By.name("To")).sendKeys(email);
    }
}
