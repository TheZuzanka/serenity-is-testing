package starter.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import starter.navigation.NavigateTo;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class GoToIsStubaStepDefinitions {
    @Steps
    NavigateTo navigateTo;

    @Given("Sergey opened browser")
    public void i_open_browser() {
        navigateTo.theIsStubaAuthPage();
        WebDriver driver = getDriver();
        String currentUrl = driver.getCurrentUrl();
        System.out.println("current url after set = " + currentUrl);
    }

    @When("he open {string}")
    public void i_opened_is_stuba(String arg0) {
        //navigateTo.theIsStubaHomePage();
    }

    @Then("he should be on {string}")
    public void i_m_on(String arg0) {
        WebDriver driver = getDriver();
        String currentUrl = driver.getCurrentUrl();
        System.out.println("current url = " + currentUrl);

        assertThat(currentUrl).contains("https://is.stuba.sk/");
    }
}
