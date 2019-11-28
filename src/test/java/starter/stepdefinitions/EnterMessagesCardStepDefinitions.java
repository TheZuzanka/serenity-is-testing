package starter.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import starter.matchers.IdentificateMailBox;
import starter.navigation.GoToMessages;
import starter.navigation.LogInIsStuba;
import starter.navigation.NavigateTo;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class EnterMessagesCardStepDefinitions {
    @Steps
    LogInIsStuba logInAsZuzana;

    @Steps
    GoToMessages goToMessages;

    @Steps
    IdentificateMailBox identificateMailBox;

    @Steps
    NavigateTo navigateTo;

    @Given("Zuzana is signed in with credentials {string} and {string}")
    public void zuzanaIsSignedInWithCredentialsAnd(String user_name, String password) {
        navigateTo.theIsStubaAuthPage();
        logInAsZuzana.logInAsZuzana(user_name, password);
    }

    @When("she click on messages")
    public void sheClickOnMessages() {
        goToMessages.openMessagesTab();
    }

    @Then("she should see mail box")
    public void sheShouldSeeMailBox() {
        identificateMailBox.imInMalBox();
    }
}
