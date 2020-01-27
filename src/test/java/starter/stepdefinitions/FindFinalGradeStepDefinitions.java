package starter.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import starter.enteringData.ChangeTimePeriod;
import starter.navigation.NavigateTo;

import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class FindFinalGradeStepDefinitions {
    @When("she navigates to e-study record")
    public void navigateToEStudyRecord() {
        NavigateTo.estudyRecord();
    }

    @And("she choose {string}")
    public void choosePeriod(String term) {
        ChangeTimePeriod.choosePeriod(term);
    }

    @Then("she found {string} from {string}")
    public void checkGrade(String grade, String subject) {
        int currentRow = 0, currentColumn = 0;
        String text;
        boolean containsText = false;
        WebElement rowContainingSubject = null;

        WebDriver driver = getDriver();

        //hladam spravny riadok
        List<WebElement> rows = driver.findElements(By.cssSelector("[id='tmtab_1'] tr"));
        for (WebElement row: rows) {
            System.out.println("------------------------------------------------------------------------------------------------------");
            text = row.getText();
            System.out.println("Row number " + (currentRow + 1) + " contains text: " + text);

            List<WebElement> columns = row.findElements(By.tagName("td"));

            for (WebElement column : columns) {
                if(currentColumn == 2){
                    System.out.println("Column " + currentColumn + " : " + text);
                    text = column.getText();
                    if(text.contains(subject)){
                        rowContainingSubject = row;
                    }
                    currentColumn++;
                }
                currentColumn++;
            }
            currentRow++;
            currentColumn = 0;
        }

        //uz mam najdeny spravny riadok, urobim v nom co potrebujem: znamka je v stlpci c. 6
        if(rowContainingSubject == null){
            System.out.println("Subject is not presented in selected period.");
            containsText = false;
        }else{
            currentColumn = 0;

            List<WebElement> columns = rowContainingSubject.findElements(By.tagName("td"));
            for (WebElement column : columns) {
                if(currentColumn == 7){
                    text = column.getText();
                    System.out.println("Column " + currentColumn + " : " + text);

                    if(text.contains("(" + grade + ")")){
                        System.out.println("Column " + currentColumn + " contains expected grade \"" + grade + "\"");
                        containsText = true;
                    }
                    else{
                        System.out.println("Column " + currentColumn + " DOESN'T contain expected grade \"" + grade + "\"");
                        System.out.println("Expected: " + grade + ", Is: " + text);
                        containsText = false;
                    }
                    currentColumn++;
                }
                currentColumn++;
            }

        }
        assertThat(containsText).isEqualTo(true);
    }
}