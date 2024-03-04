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

public class CriarEtapaTest extends BaseTest {
    EdicaoPage edicaoPage = new EdicaoPage();
    EdicaoData edicaoData = new EdicaoData();

    LoginPage loginPage = new LoginPage();
    LoginData loginData = new LoginData();

    EtapaPage etapaPage = new EtapaPage();
    EtapaData etapaData = new EtapaData();

    String nomeEdicaoCadastrada = "";
    String nomeEtapaCadastrada = "";
    private static final By MSG_ERROR_NOME = By.cssSelector("#root > section > section > div > form > div > span");

    @BeforeEach
    public void setUp() {
        LoginDTO loginValido = loginData.loginDadosValidos();
        loginPage.fazerLogin(loginValido.getUsername(), loginValido.getSenha());
        EdicaoDTO edicaoACadastrar = edicaoData.edicaoDadosValidos();
        edicaoPage.cadastrarEdicao(edicaoACadastrar);
        nomeEdicaoCadastrada = edicaoACadastrar.getNome();
    }

    @AfterEach
    public void cleanUp() {
        if (nomeEdicaoCadastrada != "") {
            edicaoPage.excluirEdicaoComSucesso(nomeEdicaoCadastrada);
        }
    }
    @Test
    @Feature("Etapa - UI")
    @Story("Criar etapa valida com sucesso")
    @Description("Testa se o usuário consegue criar uma etapa com dados validos")
    @Severity(SeverityLevel.CRITICAL)
    public void testCriarEtapaValidaComSucesso(){
        clicarElementoXPATH(nomeEdicaoCadastrada);
        EtapaDTO etapaACadastrar = etapaData.etapaDadosValidos();
        etapaPage.cadastrarEtapa(etapaACadastrar);
        etapaPage.validarInformacoesCadastradasEtapa(etapaACadastrar);
        nomeEtapaCadastrada = etapaACadastrar.getNome();
    };

    @Test
    @Feature("Etapa - UI")
    @Story("Criar etapa valida sem sucesso")
    @Description("Testa se o usuário não consegue criar uma etapa sem campo nome")
    @Severity(SeverityLevel.CRITICAL)
    public void testCriarEtapaSemCampoNomeSemSucesso(){
        clicarElementoXPATH(nomeEdicaoCadastrada);
        EtapaDTO etapaACadastrar = etapaData.etapaComCampoNomeVazio();
        etapaPage.cadastrarEtapa(etapaACadastrar);
        String mensagemDeErroNomeVazio = BasePage.lerTexto(MSG_ERROR_NOME);
        Assertions.assertEquals("Campo Nome é obrigatório", mensagemDeErroNomeVazio);
        nomeEtapaCadastrada = etapaACadastrar.getNome();
    };

    @Test
    @Feature("Etapa - UI")
    @Story("Criar etapa valida sem sucesso")
    @Description("Testa se o usuário não consegue criar uma etapa sem campo ordem execucao")
    @Severity(SeverityLevel.CRITICAL)
    public void testCriarEtapaSemCampoOrdemExecucaoSemSucesso(){
        clicarElementoXPATH(nomeEdicaoCadastrada);
        EtapaDTO etapaACadastrar = etapaData.etapaComCampoOrdemExecucaoVazio();
        etapaPage.cadastrarEtapaSemOrdemExecucao(etapaACadastrar);
        String mensagemDeErroNomeVazio = BasePage.lerTexto(MSG_ERROR_NOME);
        Assertions.assertEquals("Campo de dias úteis é obrigatório", mensagemDeErroNomeVazio);
        nomeEtapaCadastrada = etapaACadastrar.getNome();
    };

    @Test
    @Feature("Etapa - UI")
    @Story("Criar etapa valida sem sucesso")
    @Description("Testa se o usuário não consegue criar uma etapa sem campo dias uteis")
    @Severity(SeverityLevel.CRITICAL)
    public void testCriarEtapaSemCampoDiasUteisSemSucesso(){
        clicarElementoXPATH(nomeEdicaoCadastrada);
        EtapaDTO etapaACadastrar = etapaData.etapaComCampoDuracaoVazio();
        etapaPage.cadastrarEtapaSemDuracaoDiasUteis(etapaACadastrar);
        String mensagemDeErroNomeVazio = BasePage.lerTexto(MSG_ERROR_NOME);
        Assertions.assertEquals("Campo de dias úteis é obrigatório", mensagemDeErroNomeVazio);
        nomeEtapaCadastrada = etapaACadastrar.getNome();
    };

    @Test
    @Feature("Etapa - UI")
    @Story("Criar etapa valida sem sucesso")
    @Description("Testa se o usuário não consegue criar uma etapa sem campo nome maior que 50 caracteres")
    @Severity(SeverityLevel.CRITICAL)
    public void testCriarEtapaComCampoNomeComMaisDe50CaracteresSemSucesso(){
        clicarElementoXPATH(nomeEdicaoCadastrada);
        EtapaDTO etapaACadastrar = etapaData.etapaComCampoNomeMaiorQue50Caracteres();
        etapaPage.cadastrarEtapa(etapaACadastrar);
        String mensagemDeErroNomeVazio = BasePage.lerTexto(MSG_ERROR_NOME);
        Assertions.assertEquals("O nome da Etapa deve ter menos de 50 letras", mensagemDeErroNomeVazio);
        nomeEtapaCadastrada = etapaACadastrar.getNome();
    };
}
