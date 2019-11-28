package starter.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import starter.navigation.NavigateTo;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class logInStepDefinitions {
    @Steps
    NavigateTo navigateTo;

    @Given("she is on ais")
    public void sheIsOnAis() {
        navigateTo.theIsStubaAuthPage();
    }

    @When("she enters name {string}")
    public void sheEntersName(String user_name) {
        WebDriver driver = getDriver();
        driver.findElement(By.name("credential_0")).sendKeys(user_name);
    }

    @And("she enters password {string}")
    public void sheEntersPassword(String password) {
        WebDriver driver = getDriver();
        driver.findElement(By.name("credential_1")).sendKeys(password);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("login"))).click();
    }

    @Then("she should be logged in")
    public void sheShouldBeLoggedIn() {
        WebDriver driver = getDriver();
        String log = driver.findElement(By.id("log")).getText();

        assertThat(log).contains("Zuzana");
    }
}
