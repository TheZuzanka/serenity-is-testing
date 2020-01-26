package starter.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class FindFinalGradeStepDefinitions {
    @When("she navigates to e-study record")
    public void sheNavigatesToEStudyRecord() {
        WebDriver driver = getDriver();

        driver.findElement(By.linkText("Student's portal")).click();
        driver.findElement(By.linkText("E-study record")).click();
        System.out.println("adresa = " + driver.getCurrentUrl());
    }

    @And("she choose {string}")
    public void sheChoose(String term) {
        WebDriver driver = getDriver();

        Select period = new Select(driver.findElement(By.name("obdobi")));
        period.selectByVisibleText(term + " - FIIT");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("omezit_popupy"))).click();

        String prvyRiadok = driver.findElement(By.linkText("Algebra and Discrete Mathematics")).getText();
        System.out.println("Prvy riadok = " + prvyRiadok);
    }

    @Then("she found {string} from {string}")
    public void sheFoundFrom(String arg0, String arg1) {
    }
}