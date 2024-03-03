package chronos.test.edicao;

import chronos.data.dto.EdicaoDTO;
import chronos.data.dto.LoginDTO;
import chronos.data.factory.datafaker.LoginData;
import chronos.data.factory.datafaker.EdicaoData;
import chronos.page.BasePage;
import chronos.page.EdicaoPage;
import chronos.page.LoginPage;
import chronos.test.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class DeletarEdicaoTest extends BaseTest {

    EdicaoPage edicaoPage = new EdicaoPage();
    EdicaoData edicaoData = new EdicaoData();

    LoginPage loginPage = new LoginPage();
    LoginData loginData = new LoginData();

    String nomeEdicaoCadastrada = "";

    private static final By MSG_ERROR_NOME = By.cssSelector("div#root form > div > span");
    private static final By MSG_ERROR_DATA = By.cssSelector("div#root div:nth-child(3) > span");
    private static final By MSG_ERROR_NOME_BIGGER_CHAR = By.cssSelector("div#root form > div > span");

    private static final By MSG_ERROR_DESCRICAO = By.cssSelector("#root > section > section > div > form > div > span");

    @BeforeEach
    public void setUp() {
        LoginDTO loginValido = loginData.loginDadosValidos();
        loginPage.fazerLogin(loginValido.getUsername(), loginValido.getSenha());
        EdicaoDTO edicaoACadastrar = edicaoData.edicaoDadosValidos();
        edicaoPage.cadastrarEdicao(edicaoACadastrar);
        nomeEdicaoCadastrada = edicaoACadastrar.getNome();
    }

    @Test
    @Feature("Edicao - UI")
    @Story("Deletar edicao")
    @Description("Testa se o usuário consegue deletar uma edicao")
    @Severity(SeverityLevel.CRITICAL)
    public void testAtualizarEdicaoValidaComSucesso(){
        edicaoPage.excluirEdicaoComSucesso(nomeEdicaoCadastrada);
    };
}
