package starter.navigation;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class NavigateTo {

    IsStubaGoToAuthPage isStubaGoToAuthPage;

    @Step("Open the IsStuba home page")
    public void theIsStubaAuthPage() {
        isStubaGoToAuthPage.open();
    }

    public static void estudyRecord(){
        WebDriver driver = getDriver();

        driver.findElement(By.linkText("Student's portal")).click();
        driver.findElement(By.linkText("E-study record")).click();
        System.out.println("adresa = " + driver.getCurrentUrl());
    }
}
