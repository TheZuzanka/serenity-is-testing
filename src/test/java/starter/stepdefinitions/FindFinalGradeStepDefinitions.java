package starter.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebDriver;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class FindFinalGradeStepDefinitions {
    @When("she navigates to e-study record")
    public void sheNavigatesToEStudyRecord() {
        WebDriver driver = getDriver();

        driver.findElement(By.linkText("Student's portal")).click();
        System.out.println("adresa = " + driver.getCurrentUrl());
    }

    @And("she choose {string}")
    public void sheChoose(String term) {
    }

    @Then("she found {string} from {string}")
    public void sheFoundFrom(String arg0, String arg1) {
    }
}

//*[@id="sekce-24"]/div[3]/div/div[2]/ul/li[1]/a/b