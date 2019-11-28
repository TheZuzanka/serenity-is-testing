package starter.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import starter.clicks.SendMessage;
import starter.enteringData.AddEmail;
import starter.enteringData.AddSubject;
import starter.enteringData.WriteMessage;
import starter.matchers.CheckIfSent;
import starter.navigation.GoToMessages;
import starter.navigation.LogInIsStuba;
import starter.navigation.NavigateTo;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class SendingMessageToSamuelStepDefinitions {
    @Steps
    NavigateTo navigateTo;

    @Steps
    LogInIsStuba logInIsStuba;

    @Steps
    GoToMessages goToMessages;

    @Steps
    AddEmail addEmail;

    @Steps
    AddSubject addSubject;

    @Steps
    WriteMessage writeMessage;

    @Steps
    SendMessage sendMessage;

    @Steps
    CheckIfSent checkIfSent;

    @Given("Zuzana is signed in with credentials {string} and {string} and enters messages tab")
    public void zuzanaIsSignedInWithCredentialsAndAndEntersMessagesTab(String user_name, String password) {
        navigateTo.theIsStubaAuthPage();
        logInIsStuba.logInAsZuzana(user_name,password);
        goToMessages.openMessagesTab();
    }

    @When("she click on new message")
    public void sheClickOnNewMessage() {
        WebDriver driver = getDriver();
        driver.findElement(By.linkText("New message")).click();
    }

    @And("she gives email {string} subject {string}")
    public void sheGivesEmailSubject(String email, String subject) {
        addEmail.enterEmail(email);
        addSubject.enterSubject(subject);
    }

    @And("she types message {string}")
    public void sheTypesMessage(String message) {
        writeMessage.addToFiels(message);
    }

    @And("she save message to sent")
    public void sheSaveMessageToSent() {
        WebDriver driver = getDriver();
        driver.findElement(By.name("ulozit_odesl_zpravu")).click();
    }

    @And("she clicks send message")
    public void sheClicksSendMessage() {
        sendMessage.send();
    }

    @Then("last reciever is {string}")
    public void lastRecieverIs(String mail) {
        checkIfSent.imInMalBox(mail);
    }
}
