package starter.navigation;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@DefaultUrl("https://is.stuba.sk/auth/")
public class LogInIsStuba {
    @Step("Log to stuba as Zuzana")
    public void logInAsZuzana(String user_name, String password) {
        WebDriver driver = getDriver();
        driver.findElement(By.name("credential_0")).sendKeys(user_name);
        driver.findElement(By.name("credential_1")).sendKeys(password);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("login"))).click();

        String log = driver.findElement(By.id("log")).getText();
        System.out.println("Control log: " + log);
    }
}
