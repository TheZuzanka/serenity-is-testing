package starter.matchers;

import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebDriver;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class IdentificateMailBox {
    public void imInMalBox(){
        WebDriver driver = getDriver();
        String log = driver.findElement(By.id("titulek")).getText();

        assertThat(log).contains("Mail box");
    }
}
