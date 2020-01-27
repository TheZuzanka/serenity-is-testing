package starter.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import starter.enteringData.ChangeTimePeriod;
import starter.matchers.CheckIfGradeMatches;
import starter.navigation.NavigateTo;

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
        CheckIfGradeMatches condition = new CheckIfGradeMatches();
        condition.check(grade, subject);
    }
}