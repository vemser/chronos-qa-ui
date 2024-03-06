package chronos.test.e2e;


import chronos.data.dto.*;
import chronos.data.factory.datafaker.*;
import chronos.page.*;
import chronos.test.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static chronos.page.BasePage.clicar;
import static chronos.page.BasePage.clicarElementoXPATH;

public class EndToEndTest extends BaseTest {
    EdicaoPage edicaoPage = new EdicaoPage();
    EdicaoData edicaoData = new EdicaoData();
    LoginPage loginPage = new LoginPage();
    EtapaPage etapaPage = new EtapaPage();
    EtapaData etapaData = new EtapaData();
    LoginData loginData = new LoginData();
    TrilhaPage trilhaPage = new TrilhaPage();
    EstagiarioPage estagiarioPage = new EstagiarioPage();
    EstagiarioData estagiarioData = new EstagiarioData();
    String nomeEdicaoCadastrada = "";

    private static final By EDICAO_ABA = By.cssSelector("a#link-edicoes");
    public static final By VINCULAR_TRILHA = By.cssSelector("div#root div:nth-child(6) > button");
    public static final By VINCULAR_TRILHA_SELECT = By.cssSelector("div#idTrilha");
    public static final By CONFIMAR_VINCULO = By.cssSelector("div#root form > div > button");
    private static final By BTN_ABA_TRILHAS = By.cssSelector("a#link-trilhas");
    private static final By BTN_ADICIONAR_TRILHA = By.cssSelector("#root > section > section > div.MuiBox-root.css-o2ea32 > button");


    @Test
    @Feature("EndToEnd - UI")
    @Story("Valida todo o fluxo da aplicação de ponta a ponta")
    @Description("Testa se o usuário consegue utilizar a aplicação como um todo.")
    @Severity(SeverityLevel.CRITICAL)
    public void testEndToEnd(){
        LoginDTO loginValido = loginData.loginDadosValidos();
        loginPage.fazerLogin(loginValido.getUsername(), loginValido.getSenha());
        EdicaoDTO edicaoACadastrar = edicaoData.edicaoDadosValidosEndToEnd();
        edicaoPage.cadastrarEdicao(edicaoACadastrar);
        nomeEdicaoCadastrada = edicaoACadastrar.getNome();
        clicarElementoXPATH(nomeEdicaoCadastrada);
        EtapaDTO etapaAAtualizar1 = etapaData.etapaDadosValidosEndToEnd1();
        etapaPage.atualizarEtapa1EndToEnd(etapaAAtualizar1);
        EtapaDTO etapaAAtualizar2 = etapaData.etapaDadosValidosEndToEnd2();
        etapaPage.atualizarEtapa2EndToEnd(etapaAAtualizar2);
        EtapaDTO etapaAAtualizar3 = etapaData.etapaDadosValidosEndToEnd3();
        etapaPage.atualizarEtapa3EndToEnd(etapaAAtualizar3);
        EtapaDTO etapaAAtualizar4 = etapaData.etapaDadosValidosEndToEnd4();
        etapaPage.atualizarEtapa4EndToEnd(etapaAAtualizar4);
        TrilhaCadastroDTO trilhaBack = TrilhaData.trilhaValidaBackEnd();
        TrilhaCadastroDTO trilhaFront = TrilhaData.trilhaValidaFrontEnd();
        TrilhaCadastroDTO trilhaQA = TrilhaData.trilhaValidaQA();
        clicar(BTN_ABA_TRILHAS);
        clicar(BTN_ADICIONAR_TRILHA);
        trilhaPage.cadastrarTrilhaComSucessoE2E(trilhaBack);
        clicar(BTN_ABA_TRILHAS);
        clicar(BTN_ADICIONAR_TRILHA);
        trilhaPage.cadastrarTrilhaComSucessoE2E(trilhaFront);
        clicar(BTN_ABA_TRILHAS);
        clicar(BTN_ADICIONAR_TRILHA);
        trilhaPage.cadastrarTrilhaComSucessoE2E(trilhaQA);
    };
}
