package chronos.test.estagiario;


import chronos.data.dto.EdicaoDTO;
import chronos.data.dto.EstagiarioDTO;
import chronos.data.dto.LoginDTO;
import chronos.data.dto.TrilhaCadastroDTO;
import chronos.data.factory.datafaker.*;
import chronos.page.*;
import chronos.test.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class CriarEstagiarioTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    LoginData loginData = new LoginData();
    EdicaoPage edicaoPage = new EdicaoPage();
    EdicaoData edicaoData = new EdicaoData();
    TrilhaPage trilhaPage = new TrilhaPage();

    String nomeEdicaoCadastrada = "";
    String nomeTrilhaCadastrada = "";

    String nomeEstagiarioCadastrado = "";

    EstagiarioPage estagiarioPage = new EstagiarioPage();
    EstagiarioData estagiarioData = new EstagiarioData();

    public static final By CAMPO_ERROR = By.xpath("//p[contains(@class, 'Mui-error')]");

    public static final By CAMPO_CIDADE_ERROR = By.cssSelector("#\\:r13\\:-helper-text");

    public static final By CAMPO_CPF_ERROR = By.cssSelector("#\\:ru\\:-helper-text");

    public static final By CAMPO_CURSO_ERROR = By.cssSelector("#\\:r16\\:-helper-text");
    public static final By CAMPO_DATA_ERROR = By.cssSelector("#dataNascimento-helper-text");
    public static final By CAMPO_ESTADO_ERROR = By.cssSelector("#\\:r14\\:-helper-text");

    public static final By CAMPO_INSTITUICAO_ERROR = By.cssSelector("#\\:r17\\:-helper-text");

    public static final By CAMPO_STATUS_ERROR = By.cssSelector("#\\:r1a\\:-helper-text");

    public static final By CAMPO_TELEFONE_ERROR = By.cssSelector("#\\:r10\\:-helper-text");

    public static final By CAMPO_EMAIL_CORPORATIVO = By.cssSelector("#\\:r12\\:-helper-text");
    public static final By CAMPO_EMAIL_PESSOAL = By.cssSelector("#\\:r11\\:-helper-text");

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
    @Feature("Estagiario - UI")
    @Story("Criar estagiario valida com sucesso")
    @Description("Testa se o usuário consegue criar uma estagiario com dados validos")
    @Severity(SeverityLevel.CRITICAL)
    public void testCriarEstagiarioValidoComSucesso(){
        EstagiarioDTO estagiarioACriar = estagiarioData.estagiarioDadosValidos();
        estagiarioPage.cadastrarEstagiario(estagiarioACriar);
        nomeEstagiarioCadastrado = estagiarioACriar.getNome();
    };

    @Test
    @Feature("Estagiario - UI")
    @Story("Criar estagiario valida sem sucesso")
    @Description("Testa se o usuário não consegue criar uma estagiario com campo nome vazio")
    @Severity(SeverityLevel.CRITICAL)
    public void testCriarEstagiarioComCampoNomeVazioSemSucesso(){
        EstagiarioDTO estagiarioACriar = estagiarioData.estagiarioSemCampoNome();
        estagiarioPage.cadastrarEstagiario(estagiarioACriar);
        String mensagemDeErroNomeVazio = BasePage.lerTexto(CAMPO_ERROR);
        Assertions.assertEquals("Campo Nome é obrigatório", mensagemDeErroNomeVazio);
    };

    @Test
    @Feature("Estagiario - UI")
    @Story("Criar estagiario valida sem sucesso")
    @Description("Testa se o usuário não consegue criar uma estagiario com campo cidade vazio")
    @Severity(SeverityLevel.CRITICAL)
    public void testCriarEstagiarioComCampoCidadeVazioSemSucesso(){
        EstagiarioDTO estagiarioACriar = estagiarioData.estagiarioSemCampoCidade();
        estagiarioPage.cadastrarEstagiario(estagiarioACriar);
        String mensagemDeErroNomeVazio = BasePage.lerTexto(CAMPO_ERROR);
        Assertions.assertEquals("Campo Cidade é obrigatório", mensagemDeErroNomeVazio);
    };

    @Test
    @Feature("Estagiario - UI")
    @Story("Criar estagiario valida sem sucesso")
    @Description("Testa se o usuário não consegue criar uma estagiario com campo CPF vazio")
    @Severity(SeverityLevel.CRITICAL)
    public void testCriarEstagiarioComCampoCPFVazioSemSucesso(){
        EstagiarioDTO estagiarioACriar = estagiarioData.estagiarioSemCampoCPF();
        estagiarioPage.cadastrarEstagiario(estagiarioACriar);
        String mensagemDeErroNomeVazio = BasePage.lerTexto(CAMPO_ERROR);
        Assertions.assertEquals("Campo CPF é obrigatório", mensagemDeErroNomeVazio);
    };

    @Test
    @Feature("Estagiario - UI")
    @Story("Criar estagiario valida sem sucesso")
    @Description("Testa se o usuário não consegue criar uma estagiario com campo curso vazio")
    @Severity(SeverityLevel.CRITICAL)
    public void testCriarEstagiarioComCampoCursoVazioSemSucesso(){
        EstagiarioDTO estagiarioACriar = estagiarioData.estagiarioSemCampoCurso();
        estagiarioPage.cadastrarEstagiario(estagiarioACriar);
        String mensagemDeErroNomeVazio = BasePage.lerTexto(CAMPO_ERROR);
        Assertions.assertEquals("Campo Curso é obrigatório", mensagemDeErroNomeVazio);
    };

    @Test
    @Feature("Estagiario - UI")
    @Story("Criar estagiario valida sem sucesso")
    @Description("Testa se o usuário não consegue criar uma estagiario com campo data de nascimento vazio")
    @Severity(SeverityLevel.CRITICAL)
    public void testCriarEstagiarioComCampoDataNascimentoSemSucesso(){
        EstagiarioDTO estagiarioACriar = estagiarioData.estagiarioSemCampoDataDeNascimento();
        estagiarioPage.cadastrarEstagiarioSemDataNasc(estagiarioACriar);
        String mensagemDeErroNomeVazio = BasePage.lerTexto(CAMPO_ERROR);
        Assertions.assertEquals("Campo Data de Nascimento é obrigatório", mensagemDeErroNomeVazio);
    };


    @Test
    @Feature("Estagiario - UI")
    @Story("Criar estagiario valida sem sucesso")
    @Description("Testa se o usuário não consegue criar uma estagiario com campo estado vazio")
    @Severity(SeverityLevel.CRITICAL)
    public void testCriarEstagiarioSemCampoEstadoSemSucesso(){
        EstagiarioDTO estagiarioACriar = estagiarioData.estagiarioSemCampoEstado();
        estagiarioPage.cadastrarEstagiarioSemEstado(estagiarioACriar);
        String mensagemDeErroNomeVazio = BasePage.lerTexto(CAMPO_ERROR);
        Assertions.assertEquals("Campo Estado é obrigatório", mensagemDeErroNomeVazio);
    };

    @Test
    @Feature("Estagiario - UI")
    @Story("Criar estagiario valida sem sucesso")
    @Description("Testa se o usuário não consegue criar uma estagiario com campo instituicao vazio")
    @Severity(SeverityLevel.CRITICAL)
    public void testCriarEstagiarioSemCampoInstituicaoSemSucesso(){
        EstagiarioDTO estagiarioACriar = estagiarioData.estagiarioSemCampoInstituicao();
        estagiarioPage.cadastrarEstagiario(estagiarioACriar);
        String mensagemDeErroNomeVazio = BasePage.lerTexto(CAMPO_ERROR);
        Assertions.assertEquals("Campo Instituição de Ensino é obrigatório", mensagemDeErroNomeVazio);
    };

    @Test
    @Feature("Estagiario - UI")
    @Story("Criar estagiario valida sem sucesso")
    @Description("Testa se o usuário não consegue criar uma estagiario com campo status vazio")
    @Severity(SeverityLevel.CRITICAL)
    public void testCriarEstagiarioSemCampoStatusoSemSucesso(){
        EstagiarioDTO estagiarioACriar = estagiarioData.estagiarioSemCampoStatus();
        estagiarioPage.cadastrarEstagiarioSemStatus(estagiarioACriar);
        String mensagemDeErroNomeVazio = BasePage.lerTexto(CAMPO_ERROR);
        Assertions.assertEquals("Campo Status é obrigatório", mensagemDeErroNomeVazio);
    };

    @Test
    @Feature("Estagiario - UI")
    @Story("Criar estagiario valida sem sucesso")
    @Description("Testa se o usuário não consegue criar uma estagiario com campo telefone vazio")
    @Severity(SeverityLevel.CRITICAL)
    public void testCriarEstagiarioSemCampoTelefoneSemSucesso(){
        EstagiarioDTO estagiarioACriar = estagiarioData.estagiarioSemCampoTelefone();
        estagiarioPage.cadastrarEstagiario(estagiarioACriar);
        String mensagemDeErroNomeVazio = BasePage.lerTexto(CAMPO_ERROR);
        Assertions.assertEquals("Campo Telefone é obrigatório", mensagemDeErroNomeVazio);
    };

    @Test
    @Feature("Estagiario - UI")
    @Story("Criar estagiario valida sem sucesso")
    @Description("Testa se o usuário não consegue criar uma estagiario com campo email corporativo vazio")
    @Severity(SeverityLevel.CRITICAL)
    public void testCriarEstagiarioSemCampoEmailCorporativoSemSucesso(){
        EstagiarioDTO estagiarioACriar = estagiarioData.estagiarioSemCampoEmailCorporativo();
        estagiarioPage.cadastrarEstagiario(estagiarioACriar);
        String mensagemDeErroNomeVazio = BasePage.lerTexto(CAMPO_ERROR);
        Assertions.assertEquals("Campo Email Corporativo é obrigatório", mensagemDeErroNomeVazio);
    };

    @Test
    @Feature("Estagiario - UI")
    @Story("Criar estagiario valida sem sucesso")
    @Description("Testa se o usuário não consegue criar uma estagiario com campo email pessoal vazio")
    @Severity(SeverityLevel.CRITICAL)
    public void testCriarEstagiarioSemCampoEmailPessoalSemSucesso(){
        EstagiarioDTO estagiarioACriar = estagiarioData.estagiarioSemCampoEmailPessoal();
        estagiarioPage.cadastrarEstagiario(estagiarioACriar);
        String mensagemDeErroNomeVazio = BasePage.lerTexto(CAMPO_ERROR);
        Assertions.assertEquals("Campo Email Pessoal é obrigatório", mensagemDeErroNomeVazio);
    };
}
