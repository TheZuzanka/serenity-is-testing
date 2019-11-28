package starter.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.navigation.NavigateTo;

public class SendingMessageToSamuelStepDefinitions {
    @Steps
    NavigateTo navigateTo;

    @Given("Zuzana is signed in with credentials {string} and {string} and enters messages tab")
    public void zuzanaIsSignedInWithCredentialsAndAndEntersMessagesTab(String user_name, String password) {
    }

    @When("she click on new message")
    public void sheClickOnNewMessage() {
    }

    @And("she gives email {string} subject {string}")
    public void sheGivesEmailSubject(String arg0, String arg1) {
    }

    @And("she types message {string}")
    public void sheTypesMessage(String arg0) {
    }

    @And("she save message to sent")
    public void sheSaveMessageToSent() {
    }

    @And("she clicks send message")
    public void sheClicksSendMessage() {
    }

    @Then("the message should be sent")
    public void theMessageShouldBeSent() {
    }
}
