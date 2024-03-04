package chronos.test.trilha;
import chronos.data.factory.datafaker.LoginData;
import chronos.data.factory.datafaker.TrilhaData;
import chronos.page.LoginPage;
import chronos.page.TrilhaPage;
import chronos.test.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EditarTrilhaTest extends BaseTest {

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
    @Story("Editar trilha valida com sucesso")
    @Description("Testa se o usuário consegue editar uma trilha com dados validos")
    @Severity(SeverityLevel.CRITICAL)
    public void testDeveEditarUmaTrilhaComSucesso() {
        trilhaPage.editarTrilhaComSucesso(TrilhaData.trilhaValidaEdicao());
    }

    @Test
    @Feature("Trilha")
    @Story("Editar trilha valida com sucesso")
    @Description("Testa se o usuário consegue editar uma trilha com dados validos")
    @Severity(SeverityLevel.CRITICAL)
    public void testTentarEditarUmaTrilhaSemNome() {
        trilhaPage.editarTrilhaSemNome(TrilhaData.trilhaComNomeVazio());
    }

    @Test
    @Feature("Trilha")
    @Story("Editar trilha valida com sucesso")
    @Description("Testa se o usuário consegue editar uma trilha com dados validos")
    @Severity(SeverityLevel.CRITICAL)
    public void testTentarEditarUmaTrilhaComDescricao256() {
        trilhaPage.editarTrilhaComDescricao256(TrilhaData.trilhaComDescricao256Caracteres());
    }


    @Test
    @Feature("Trilha")
    @Story("Editar trilha valida com sucesso")
    @Description("Testa se o usuário consegue editar uma trilha com dados validos")
    @Severity(SeverityLevel.CRITICAL)
    public void testTentarEditarUmaTrilhaComNome50Caracteres() {
        trilhaPage.editarTrilhaComNome50(TrilhaData.trilhaComNomeMaior50Caracteres());
    }



}
