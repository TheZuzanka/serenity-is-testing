package starter.matchers;

import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckIfGradeMatches {
    public void check(String grade, String subject){
        WebElement rowContainingSubject;
        String finalGrade;
        boolean containsText;

        //hladam spravny riadok
        rowContainingSubject = findSubjectRow(subject);

        //uz mam najdeny spravny riadok, urobim v nom co potrebujem: znamka je v stlpci c. 6
        finalGrade = findFinalGrade(rowContainingSubject);

        if(finalGrade == null){
            System.out.println("Error in finding subject..");
            containsText = false;
        }
        else if(finalGrade.contains("(" + grade + ")")){
            System.out.println("E-study record contains expected grade \"" + grade + "\"");
            containsText = true;
        }
        else{
            System.out.println("E-study record DOESN'T contain expected grade \"" + grade + "\"");
            System.out.println("Expected: " + grade + ", Is: " + finalGrade);
            containsText = false;
        }
        assertThat(containsText).isEqualTo(true);
    }

    private WebElement findSubjectRow(String subject){
        int currentRow = 0, currentColumn = 0;
        String text;
        WebElement rowContainingSubject = null;

        WebDriver driver = getDriver();

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

        return rowContainingSubject;
    }

    private String findFinalGrade(WebElement rowContainingSubject){
        int currentColumn = 0;
        String text;

        if(rowContainingSubject == null){
            System.out.println("Subject is not presented in selected period.");
        }else{
            List<WebElement> columns = rowContainingSubject.findElements(By.tagName("td"));
            for (WebElement column : columns) {
                if(currentColumn == 7){
                    text = column.getText();
                    System.out.println("Column " + currentColumn + " : " + text);

                    return text;
                }
                currentColumn++;
            }

        }

        return null;
    }
}
