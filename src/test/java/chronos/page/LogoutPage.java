package chronos.page;

import org.openqa.selenium.By;

public class LogoutPage extends BasePage{

    private static final By BTN_LOGOUT = By.cssSelector("div#root div:nth-child(2) > li > div > p");

    public void fazerLogout() {
        clicar(BTN_LOGOUT);
    }
}
