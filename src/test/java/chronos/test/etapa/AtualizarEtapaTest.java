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

public class AtualizarEtapaTest extends BaseTest {
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

        clicarElementoXPATH(nomeEdicaoCadastrada);
        EtapaDTO etapaACadastrar = etapaData.etapaDadosValidos();
        etapaPage.cadastrarEtapa(etapaACadastrar);
        nomeEtapaCadastrada = etapaACadastrar.getNome();
    }

    @AfterEach
    public void cleanUp() {
        if (nomeEdicaoCadastrada != "") {
            edicaoPage.excluirEdicaoComSucesso(nomeEdicaoCadastrada);
        }
    }
    @Test
    @Feature("Etapa - UI")
    @Story("Atualizar etapa valida com sucesso")
    @Description("Testa se o usuário consegue atualizar uma etapa com dados validos")
    @Severity(SeverityLevel.CRITICAL)
    public void testAtualizarEtapaValidaComSucesso(){
        clicarElementoXPATH(nomeEdicaoCadastrada);
        EtapaDTO etapaAAtualizar = etapaData.etapaDadosValidos();
        etapaPage.atualizarEtapa(etapaAAtualizar);
        etapaPage.validarInformacoesCadastradasEtapa(etapaAAtualizar);
        nomeEtapaCadastrada = etapaAAtualizar.getNome();
    };

    @Test
    @Feature("Etapa - UI")
    @Story("Atualizar etapa valida sem sucesso")
    @Description("Testa se o usuário não consegue atualizar uma etapa sem campo nome")
    @Severity(SeverityLevel.CRITICAL)
    public void testAtualizarEtapaSemCampoNomeSemSucesso(){
        clicarElementoXPATH(nomeEdicaoCadastrada);
        EtapaDTO etapaAAtualizar = etapaData.etapaComCampoNomeVazio();
        etapaPage.atualizarEtapa(etapaAAtualizar);
        String mensagemDeErroNomeVazio = BasePage.lerTexto(MSG_ERROR_NOME);
        Assertions.assertEquals("Campo Nome é obrigatório", mensagemDeErroNomeVazio);
        nomeEtapaCadastrada = etapaAAtualizar.getNome();
    };

    @Test
    @Feature("Etapa - UI")
    @Story("Atualizar etapa valida sem sucesso")
    @Description("Testa se o usuário não consegue atualizar uma etapa sem campo ordem execucao")
    @Severity(SeverityLevel.CRITICAL)
    public void testAtualizarEtapaSemCampoOrdemExecucaoSemSucesso(){
        clicarElementoXPATH(nomeEdicaoCadastrada);
        EtapaDTO etapaAAtualizar = etapaData.etapaComCampoOrdemExecucaoVazio();
        etapaPage.atualizarEtapa(etapaAAtualizar);
        String mensagemDeErroNomeVazio = BasePage.lerTexto(MSG_ERROR_NOME);
        Assertions.assertEquals("Campo de dias úteis é obrigatório", mensagemDeErroNomeVazio);
        nomeEtapaCadastrada = etapaAAtualizar.getNome();
    };

    @Test
    @Feature("Etapa - UI")
    @Story("Atualizar etapa valida sem sucesso")
    @Description("Testa se o usuário não consegue atualizar uma etapa sem campo dias uteis")
    @Severity(SeverityLevel.CRITICAL)
    public void testAtualizarEtapaSemCampoDiasUteisSemSucesso(){
        clicarElementoXPATH(nomeEdicaoCadastrada);
        EtapaDTO etapaAAtualizar = etapaData.etapaComCampoDuracaoVazio();
        etapaPage.cadastrarEtapaSemDuracaoDiasUteis(etapaAAtualizar);
        String mensagemDeErroNomeVazio = BasePage.lerTexto(MSG_ERROR_NOME);
        Assertions.assertEquals("Campo de dias úteis é obrigatório", mensagemDeErroNomeVazio);
        nomeEtapaCadastrada = etapaAAtualizar.getNome();
    };

    @Test
    @Feature("Etapa - UI")
    @Story("Atualizar etapa valida sem sucesso")
    @Description("Testa se o usuário não consegue atualizar uma etapa sem campo nome maior que 50 caracteres")
    @Severity(SeverityLevel.CRITICAL)
    public void testAtualizarEtapaComCampoNomeComMaisDe50CaracteresSemSucesso(){
        clicarElementoXPATH(nomeEdicaoCadastrada);
        EtapaDTO etapaAAtualizar = etapaData.etapaComCampoNomeMaiorQue50Caracteres();
        etapaPage.cadastrarEtapa(etapaAAtualizar);
        nomeEtapaCadastrada = etapaAAtualizar.getNome();
    };
}
