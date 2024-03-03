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

public class CriarEdicaoTest extends BaseTest {

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
    }

    @AfterEach
    public void cleanUp() {
        if (nomeEdicaoCadastrada != "") {
            edicaoPage.excluirEdicaoComSucesso(nomeEdicaoCadastrada);
        }
    }

    @Test
    @Feature("Edicao")
    @Story("Criar edicao valida com sucesso")
    @Description("Testa se o usuário consegue criar uma edicao com dados validos")
    @Severity(SeverityLevel.CRITICAL)
    public void testCriarEdicaoValidaComSucesso(){
        EdicaoDTO edicaoACadastrar = edicaoData.edicaoDadosValidos();
        edicaoPage.cadastrarEdicao(edicaoACadastrar);
        edicaoPage.validarInformacoesCadastradasEdicao(edicaoACadastrar);
        nomeEdicaoCadastrada = edicaoACadastrar.getNome();
    };


    @Test
    @Feature("Edicao")
    @Story("Não consegue criar edição com nome vazio")
    @Description("Testa se o usuário não consegue criar uma edicao com nome vazio")
    @Severity(SeverityLevel.CRITICAL)
    public void testCriarEdicaoSemNomeSemSucesso(){
        EdicaoDTO edicaoACadastrar = edicaoData.edicaoSemNome();
        edicaoPage.cadastrarEdicao(edicaoACadastrar);
        String mensagemDeErroNomeVazio = BasePage.lerTexto(MSG_ERROR_NOME);
        Assertions.assertEquals("Campo Nome é obrigatório", mensagemDeErroNomeVazio);
    };

    @Test
    @Feature("Edicao")
    @Story("Não consegue criar edição com nome com mais de 20 caracteres")
    @Description("Testa se o usuário não consegue criar uma edicao com nome com mais de 20 caracteres")
    @Severity(SeverityLevel.CRITICAL)
    public void testCriarEdicaoComNomeComMaisDe20CaracteresSemSucesso(){
        EdicaoDTO edicaoACadastrar = edicaoData.edicaoComNomeComMaisDe20Caracteres();
        edicaoPage.cadastrarEdicao(edicaoACadastrar);
        String mensagemDeErroNomeGrande = BasePage.lerTexto(MSG_ERROR_NOME_BIGGER_CHAR);
        Assertions.assertEquals("O nome da Edição deve ter menos de 20 letras", mensagemDeErroNomeGrande);
    };

    @Test
    @Feature("Edicao")
    @Story("Não consegue criar edição com nome com menos de 4 caracteres")
    @Description("Testa se o usuário não consegue criar uma edicao com nome com menos de 4 caracteres")
    @Severity(SeverityLevel.CRITICAL)
    public void testCriarEdicaoComNomeComMenosDe4CaracteresSemSucesso(){
        EdicaoDTO edicaoACadastrar = edicaoData.edicaoComNomeComMenosDe4Caracteres();
        edicaoPage.cadastrarEdicao(edicaoACadastrar);
        String mensagemDeErroNomeGrande = BasePage.lerTexto(MSG_ERROR_NOME_BIGGER_CHAR);
        Assertions.assertEquals("O nome da Edição deve ter mais de 4 letras", mensagemDeErroNomeGrande);
    };

    @Test
    @Feature("Edicao")
    @Story("Não consegue criar edição com descricao com mais de 255 caracteres")
    @Description("Testa se o usuário não consegue criar uma edicao com nome com descricao com mais de 255 caracteres")
    @Severity(SeverityLevel.CRITICAL)
    public void testCriarEdicaoComDescricaoComMaisDe255CaracteresSemSucesso(){
        EdicaoDTO edicaoACadastrar = edicaoData.edicaoComDescricaoComMaisDe255Caracteres();
        edicaoPage.cadastrarEdicao(edicaoACadastrar);
        String mensagemErroDesc = BasePage.lerTexto(MSG_ERROR_DESCRICAO);
        Assertions.assertEquals("A descrição da Edição deve ter menos de 255 letras", mensagemErroDesc);
    };

    @Test
    @Feature("Edicao")
    @Story("Não consegue criar edição com data de início vazia")
    @Description("Testa se o usuário não consegue criar uma edicao com data de início vazio")
    @Severity(SeverityLevel.CRITICAL)
    public void testCriarEdicaoSemDataDeInicioSemSucesso(){
        EdicaoDTO edicaoACadastrar = edicaoData.edicaoSemDataDeInicio();
        edicaoPage.cadastrarEdicaoSemData(edicaoACadastrar);
        String mensagemDeErroData = BasePage.lerTexto(MSG_ERROR_DATA);
        Assertions.assertEquals("Data de início inválida", mensagemDeErroData);
    };
}
