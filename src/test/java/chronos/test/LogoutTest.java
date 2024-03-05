package chronos.test;

import chronos.data.dto.LoginDTO;
import chronos.data.factory.datafaker.LoginData;
import chronos.page.BasePage;
import chronos.page.LoginPage;
import chronos.page.LogoutPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class LogoutTest extends BaseTest{
    LoginPage loginPage = new LoginPage();
    LogoutPage logoutPage = new LogoutPage();
    LoginData loginData = new LoginData();
    private static final By GREETINGS_MENSAGEM = By.cssSelector("#root > section > div.MuiDrawer-root.MuiDrawer-docked.css-1tu59u4 > div > div > div > p");

    private static final By LOGIN_PAGE = By.cssSelector("div#root h1");
    @Test
    @Feature("Logout")
    @Story("Logout com sucesso")
    @Description("Testa se o usuário consegue efetuar o login com dados validos e se de fato esta logado na pagina, efetuando logo após o logout")
    @Severity(SeverityLevel.CRITICAL)
    public void validarLogoutComLoginValido(){
        LoginDTO loginValido = loginData.loginDadosValidos();
        loginPage.fazerLogin(loginValido.getUsername(), loginValido.getSenha());
        String mensagem = BasePage.lerTexto(GREETINGS_MENSAGEM);
        Assertions.assertEquals("Olá,", mensagem);
        logoutPage.fazerLogout();
        String h1Login = BasePage.lerTexto(LOGIN_PAGE);
        Assertions.assertEquals("Login", h1Login);
    };
}
