package starter.navigation;

import net.thucydides.core.annotations.Step;

public class NavigateTo {

    IsStubaGoToAuthPage isStubaGoToAuthPage;

    @Step("Open the IsStuba home page")
    public void theIsStubaAuthPage() {
        isStubaGoToAuthPage.open();
    }
}
