package chronos.test.trilha;

import chronos.data.factory.datafaker.LoginData;
import chronos.data.factory.datafaker.TrilhaData;
import chronos.page.LoginPage;
import chronos.page.TrilhaPage;
import chronos.test.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

public class CriarTrilhaTest extends BaseTest {

    TrilhaPage trilhaPage = new TrilhaPage();
    LoginPage loginPage = new LoginPage();
    LoginData loginData = new LoginData();

    @Test
    @Feature("Trilha")
    @Story("Criar trilha valida com sucesso")
    @Description("Testa se o usuário consegue criar uma trilha com dados validos")
    @Severity(SeverityLevel.CRITICAL)
    public void testDeveCriarUmaTrilhaComSucesso() {
        loginPage.fazerLogin(loginData.loginDadosValidos());
        trilhaPage.cadastrarTrilhaComSucesso(TrilhaData.trilhaValida());
    }

    @Test
    @Feature("Trilha")
    @Story("Criar trilha valida com nome não preenchido")
    @Description("Testa se o usuário consegue criar uma trilha com dados validos")
    @Severity(SeverityLevel.CRITICAL)
    public void testDeveCriarUmaTrilhaSemNome() {
        loginPage.fazerLogin(loginData.loginDadosValidos());
        trilhaPage.cadastrarTrilhaSemNome(TrilhaData.trilhaComNomeVazio());
    }

    @Test
    @Feature("Trilha")
    @Story("Criar trilha valida com descrição maior que 256 caracteres")
    @Description("Testa se o usuário consegue criar uma trilha com descrição maior que 256 caracteres")
    @Severity(SeverityLevel.CRITICAL)
    public void testDeveCriarUmaTrilhaComDescricao256() {
        loginPage.fazerLogin(loginData.loginDadosValidos());
        trilhaPage.cadastrarTrilhaComDescricao256(TrilhaData.trilhaComDescricao256Caracteres());
    }

    @Test
    @Feature("Trilha")
    @Story("Criar trilha valida com descrição maior que 256 caracteres")
    @Description("Testa se o usuário consegue criar uma trilha com descrição maior que 256 caracteres")
    @Severity(SeverityLevel.CRITICAL)
    public void testDeveCriarUmaTrilhaComNome50() {
        loginPage.fazerLogin(loginData.loginDadosValidos());
        trilhaPage.cadastrarTrilhaComNome50(TrilhaData.trilhaComNomeMaior50Caracteres());
    }

}
