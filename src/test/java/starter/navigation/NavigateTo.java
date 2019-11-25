package starter.navigation;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;

public class NavigateTo {

    IsStubaGoToHomePage isStubaGoToHomePage;

    @Step("Open the IsStuba home page")
    public void theIsStubaHomePage() {
        isStubaGoToHomePage.open();
    }
}
