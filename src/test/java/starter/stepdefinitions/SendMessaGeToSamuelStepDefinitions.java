package starter.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import starter.navigation.NavigateTo;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class SendMessaGeToSamuelStepDefinitions {
    @Steps
    NavigateTo navigateTo;

    @Given("Zuzana is signed in with credentials {string} and {string}")
    public void zuzanaIsSignedInWithCredentialsAnd(String user_name, String password) {
        navigateTo.theIsStubaAuthPage();
        WebDriver driver = getDriver();
        driver.findElement(By.name("credential_0")).sendKeys(user_name);
        driver.findElement(By.name("credential_1")).sendKeys(password);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("login"))).click();

        String log = driver.findElement(By.id("log")).getText();
        System.out.println("Control log: " + log);
    }

    @When("she click on messages")
    public void sheClickOnMessages() {
        WebDriver driver = getDriver();
        driver.findElement(By.linkText("messages")).click();
    }

    @Then("she should see mail box")
    public void sheShouldSeeMailBox() {
        WebDriver driver = getDriver();
        String log = driver.findElement(By.id("titulek")).getText();

        assertThat(log).contains("Mail box");
    }
}
