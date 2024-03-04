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

public class AtualizarEstagiarioTest extends BaseTest {

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

    public static final By CAMPO_NOME_ERROR = By.xpath("//*[text()='" + "Campo Nome é obrigatório" + "']");

    public static final By CAMPO_CIDADE_ERROR =  By.xpath("//*[text()='" + "Campo Cidade é obrigatório" + "']");

    public static final By CAMPO_CPF_ERROR = By.xpath("//*[text()='" + "Campo CPF é obrigatório" + "']");

    public static final By CAMPO_CURSO_ERROR = By.xpath("//*[text()='" + "Campo Curso é obrigatório" + "']");
    public static final By CAMPO_DATA_ERROR = By.xpath("//*[text()='" + "Campo Data de Nascimento é obrigatório" + "']");
    public static final By CAMPO_ESTADO_ERROR = By.xpath("//*[text()='" + "Campo Estado é obrigatório" + "']");

    public static final By CAMPO_INSTITUICAO_ERROR = By.xpath("//*[text()='" + "Campo Instituição de Ensino é obrigatório" + "']");

    public static final By CAMPO_STATUS_ERROR = By.xpath("//*[text()='" + "Campo Status é obrigatório" + "']");

    public static final By CAMPO_TELEFONE_ERROR = By.xpath("//*[text()='" + "Campo Telefone é obrigatório" + "']");

    public static final By CAMPO_EMAIL_CORPORATIVO = By.xpath("//*[text()='" + "Campo Email Corporativo é obrigatório" + "']");
    public static final By CAMPO_EMAIL_PESSOAL = By.xpath("//*[text()='" + "Campo Email Pessoal é obrigatório" + "']");

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
    @Story("Atualizar estagiario valida com sucesso")
    @Description("Testa se o usuário consegue atualizar uma estagiario com dados validos")
    @Severity(SeverityLevel.CRITICAL)
    public void testAtualizarEstagiarioValidoComSucesso(){
        EstagiarioDTO estagiarioAAtualizar = estagiarioData.estagiarioDadosValidos();
        estagiarioPage.atualizarEstagiario(estagiarioAAtualizar);
        nomeEstagiarioCadastrado = estagiarioAAtualizar.getNome();
    };

    @Test
    @Feature("Estagiario - UI")
    @Story("Atualizar estagiario valida sem sucesso")
    @Description("Testa se o usuário não consegue atualizar uma estagiario com campo nome vazio")
    @Severity(SeverityLevel.CRITICAL)
    public void testAtualizarEstagiarioComCampoNomeVazioSemSucesso(){
        EstagiarioDTO estagiarioAAtualizar = estagiarioData.estagiarioSemCampoNome();
        estagiarioPage.atualizarEstagiario(estagiarioAAtualizar);
        String mensagemDeErroNomeVazio = BasePage.lerTexto(CAMPO_NOME_ERROR);
        Assertions.assertEquals("Campo Nome é obrigatório", mensagemDeErroNomeVazio);
    };

    @Test
    @Feature("Estagiario - UI")
    @Story("Atualizar estagiario valida sem sucesso")
    @Description("Testa se o usuário não consegue atualizar uma estagiario com campo cidade vazio")
    @Severity(SeverityLevel.CRITICAL)
    public void testAtualizarEstagiarioComCampoCidadeVazioSemSucesso(){
        EstagiarioDTO estagiarioAAtualizar = estagiarioData.estagiarioSemCampoCidade();
        estagiarioPage.atualizarEstagiario(estagiarioAAtualizar);
        String mensagemDeErroNomeVazio = BasePage.lerTexto(CAMPO_CIDADE_ERROR);
        Assertions.assertEquals("Campo Cidade é obrigatório", mensagemDeErroNomeVazio);
    };

    @Test
    @Feature("Estagiario - UI")
    @Story("Atualizar estagiario valida sem sucesso")
    @Description("Testa se o usuário não consegue atualizar uma estagiario com campo curso vazio")
    @Severity(SeverityLevel.CRITICAL)
    public void testAtualizarEstagiarioComCampoCursoVazioSemSucesso(){
        EstagiarioDTO estagiarioAAtualizar = estagiarioData.estagiarioSemCampoCurso();
        estagiarioPage.atualizarEstagiario(estagiarioAAtualizar);
        String mensagemDeErroNomeVazio = BasePage.lerTexto(CAMPO_CURSO_ERROR);
        Assertions.assertEquals("Campo Curso é obrigatório", mensagemDeErroNomeVazio);
    };

    @Test
    @Feature("Estagiario - UI")
    @Story("Atualizar estagiario valida sem sucesso")
    @Description("Testa se o usuário não consegue atualizar uma estagiario com campo instituicao vazio")
    @Severity(SeverityLevel.CRITICAL)
    public void testAtualizarEstagiarioSemCampoInstituicaoSemSucesso(){
        EstagiarioDTO estagiarioAAtualizar = estagiarioData.estagiarioSemCampoInstituicao();
        estagiarioPage.atualizarEstagiario(estagiarioAAtualizar);
        String mensagemDeErroNomeVazio = BasePage.lerTexto(CAMPO_INSTITUICAO_ERROR);
        Assertions.assertEquals("Campo Instituição de Ensino é obrigatório", mensagemDeErroNomeVazio);
    };

    @Test
    @Feature("Estagiario - UI")
    @Story("Atualizar estagiario valida sem sucesso")
    @Description("Testa se o usuário não consegue atualizar uma estagiario com campo telefone vazio")
    @Severity(SeverityLevel.CRITICAL)
    public void testAtualizarEstagiarioSemCampoTelefoneSemSucesso(){
        EstagiarioDTO estagiarioAAtualizar = estagiarioData.estagiarioSemCampoTelefone();
        estagiarioPage.atualizarEstagiario(estagiarioAAtualizar);
        String mensagemDeErroNomeVazio = BasePage.lerTexto(CAMPO_TELEFONE_ERROR);
        Assertions.assertEquals("Campo Telefone é obrigatório", mensagemDeErroNomeVazio);
    };

    @Test
    @Feature("Estagiario - UI")
    @Story("Atualizar estagiario valida sem sucesso")
    @Description("Testa se o usuário não consegue atualizar uma estagiario com campo email corporativo vazio")
    @Severity(SeverityLevel.CRITICAL)
    public void testAtualizarEstagiarioSemCampoEmailCorporativoSemSucesso(){
        EstagiarioDTO estagiarioAAtualizar = estagiarioData.estagiarioSemCampoEmailCorporativo();
        estagiarioPage.atualizarEstagiario(estagiarioAAtualizar);
        String mensagemDeErroNomeVazio = BasePage.lerTexto(CAMPO_EMAIL_CORPORATIVO);
        Assertions.assertEquals("Campo Email Corporativo é obrigatório", mensagemDeErroNomeVazio);
    };

    @Test
    @Feature("Estagiario - UI")
    @Story("Atualizar estagiario valida sem sucesso")
    @Description("Testa se o usuário não consegue atualizar uma estagiario com campo email pessoal vazio")
    @Severity(SeverityLevel.CRITICAL)
    public void testAtualizarEstagiarioSemCampoEmailPessoalSemSucesso(){
        EstagiarioDTO estagiarioAAtualizar = estagiarioData.estagiarioSemCampoEmailPessoal();
        estagiarioPage.atualizarEstagiario(estagiarioAAtualizar);
        String mensagemDeErroNomeVazio = BasePage.lerTexto(CAMPO_EMAIL_PESSOAL);
        Assertions.assertEquals("Campo Email Pessoal é obrigatório", mensagemDeErroNomeVazio);
    };
}
