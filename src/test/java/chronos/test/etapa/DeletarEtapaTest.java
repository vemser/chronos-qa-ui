package chronos.test.etapa;

import chronos.data.dto.EdicaoDTO;
import chronos.data.dto.EtapaDTO;
import chronos.data.dto.LoginDTO;
import chronos.data.factory.datafaker.EdicaoData;
import chronos.data.factory.datafaker.EtapaData;
import chronos.data.factory.datafaker.LoginData;
import chronos.page.BasePage;
import chronos.page.EdicaoPage;
import chronos.page.EtapaPage;
import chronos.page.LoginPage;
import chronos.test.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static chronos.page.BasePage.clicarElementoXPATH;

public class DeletarEtapaTest extends BaseTest {
    EdicaoPage edicaoPage = new EdicaoPage();
    EdicaoData edicaoData = new EdicaoData();

    LoginPage loginPage = new LoginPage();
    LoginData loginData = new LoginData();

    EtapaPage etapaPage = new EtapaPage();
    EtapaData etapaData = new EtapaData();

    String nomeEdicaoCadastrada = "";
    String nomeEtapaCadastrada = "";

    EtapaDTO etapaCadastrada;
    private static final By MSG_ERROR_NOME = By.cssSelector("#root > section > section > div > form > div > span");

    @BeforeEach
    public void setUp() {
        LoginDTO loginValido = loginData.loginDadosValidos();
        loginPage.fazerLogin(loginValido.getUsername(), loginValido.getSenha());
        EdicaoDTO edicaoACadastrar = edicaoData.edicaoDadosValidos();
        edicaoPage.cadastrarEdicao(edicaoACadastrar);
        nomeEdicaoCadastrada = edicaoACadastrar.getNome();

        clicarElementoXPATH(nomeEdicaoCadastrada);
        EtapaDTO etapaACadastrar = etapaData.etapaDadosValidos();
        etapaPage.cadastrarEtapa(etapaACadastrar);
        nomeEtapaCadastrada = etapaACadastrar.getNome();
        etapaCadastrada = etapaACadastrar;
    }

    @AfterEach
    public void cleanUp() {
        if (nomeEdicaoCadastrada != "") {
            edicaoPage.excluirEdicaoComSucesso(nomeEdicaoCadastrada);
        }
    }
    @Test
    @Feature("Etapa - UI")
    @Story("Deletar etapa valida com sucesso")
    @Description("Testa se o usuário consegue deletar uma etapa com dados validos")
    @Severity(SeverityLevel.CRITICAL)
    public void testDeletarEtapaValidaComSucesso(){
        clicarElementoXPATH(nomeEdicaoCadastrada);
        etapaPage.deletarEtapa();
    };
}
