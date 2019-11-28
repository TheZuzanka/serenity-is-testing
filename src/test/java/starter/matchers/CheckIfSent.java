package starter.matchers;

import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.FindElement;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckIfSent {
    public void imInMalBox(String mail){
        WebDriver driver = getDriver();
        driver.findElement(By.linkText("Sent")).click();

        String lastRecieved = driver.findElement(By.linkText(mail)).getText();

        assertThat(lastRecieved).contains(mail);
    }
}
