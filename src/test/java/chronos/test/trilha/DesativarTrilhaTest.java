package chronos.test.trilha;

import chronos.data.factory.datafaker.LoginData;
import chronos.data.factory.datafaker.TrilhaData;
import chronos.page.LoginPage;
import chronos.page.TrilhaPage;
import chronos.test.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DesativarTrilhaTest extends BaseTest {

    TrilhaPage trilhaPage = new TrilhaPage();
    LoginPage loginPage = new LoginPage();
    LoginData loginData = new LoginData();


    @BeforeEach
    public void setup() {
        loginPage.fazerLogin(loginData.loginDadosValidos());
        trilhaPage.cadastrarTrilhaComSucesso(TrilhaData.trilhaValida());
    }

    @Test
    @Feature("Trilha")
    @Story("Desativar trilha valida com sucesso")
    @Description("Testa se o usuário consegue desativar uma trilha com dados validos")
    @Severity(SeverityLevel.CRITICAL)
    public void testDeveCriarUmaTrilhaComSucesso() {
        trilhaPage.desativarTrilhaComSucesso(TrilhaData.trilhaValida());
    }
}
