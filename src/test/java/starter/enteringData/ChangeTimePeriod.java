package starter.enteringData;

import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ChangeTimePeriod {
    public static void choosePeriod(String term){
        WebDriver driver = getDriver();

        Select period = new Select(driver.findElement(By.name("obdobi")));
        period.selectByVisibleText(term + " - FIIT");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("omezit_popupy"))).click();

        String prvyRiadok = driver.findElement(By.linkText("Algebra and Discrete Mathematics")).getText();
        System.out.println("Prvy riadok = " + prvyRiadok);
    }
}
