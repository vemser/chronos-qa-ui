package chronos.test.Modulo;

import chronos.data.dto.LoginDTO;
import chronos.data.dto.ModuloDTO;
import chronos.data.factory.datafaker.LoginData;
import chronos.data.factory.datafaker.ModuloData;
import chronos.page.LoginPage;
import chronos.page.ModuloPage;
import chronos.test.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CriarModuloTest extends BaseTest {

    ModuloPage moduloPage = new ModuloPage();
    LoginData loginData = new LoginData();
    ModuloData moduloData = new ModuloData();
    LoginPage loginPage = new LoginPage();



    @BeforeEach
    public void setup() {
        LoginDTO loginValido = loginData.loginDadosValidos();
        loginPage.fazerLogin(loginValido.getUsername(), loginValido.getSenha());
    }

    @Test
    @Feature("Modulo")
    @Story("Modulo cadastrado com sucesso")
    @Description("Testa se o cadastro de modulo está retorando mensagem de sucesso")
    @Severity(SeverityLevel.CRITICAL)
    public void testCadastrarModuloComSucesso() {
        ModuloDTO moduloDTO = moduloData.moduloValido();
        moduloPage.clicarBtnModulo();
        moduloPage.clicarBtnModuloAdicionar();
        String msg = moduloPage.validarTextoTela();
        Assertions.assertEquals(msg, "Cadastro de Módulos");
       moduloPage.preencherNome(moduloDTO.getNomeDoModulo());
       moduloPage.preencherLoginInstrutor(moduloDTO.getLoginDoInstrutorResponsavel());
       moduloPage.preencherConteudoProgramatico(moduloDTO.getConteudoProgramatico());
       moduloPage.clicarStatus();
       moduloPage.clicarAtivo();
       moduloPage.clicarSalvar();
       Assertions.assertEquals(moduloPage.obterValorDoPopup(), "Modulo cadastrado com sucesso!");


    }

    @Test
    @Feature("Modulo")
    @Story("Modulo cadastrado com sucesso")
    @Description("Testa se o cadastro de modulo está retorando mensagem de erro")
    @Severity(SeverityLevel.CRITICAL)
    public void testTentarCadastrarumaModuloComOsCamposVazios() {
        ModuloDTO moduloDTO = moduloData.moduloTodosOsCamposVazios();
        moduloPage.clicarBtnModulo();
        moduloPage.clicarBtnModuloAdicionar();
        String msg = moduloPage.validarTextoTela();
        Assertions.assertEquals(msg, "Cadastro de Módulos");
        moduloPage.preencherNome(moduloDTO.getNomeDoModulo());
        moduloPage.preencherLoginInstrutor(moduloDTO.getLoginDoInstrutorResponsavel());
        moduloPage.preencherConteudoProgramatico(moduloDTO.getConteudoProgramatico());
        moduloPage.clicarSalvar();
        String msg2 = moduloPage.validarErroCampoNome();
        Assertions.assertEquals(msg2, "O campo Nome é obrigatório");

    }

    @Test
    @Feature("Modulo")
    @Story("Modulo cadastrado com sucesso")
    @Description("Testa se o cadastro de modulo está retorando mensagem de erro")
    @Severity(SeverityLevel.CRITICAL)
    public void testTentarCadastrarUmaModuloApenasComNomeVazio() {
        ModuloDTO moduloDTO = moduloData.moduloNomeVazio();
        moduloPage.clicarBtnModulo();
        moduloPage.clicarBtnModuloAdicionar();
        String msg = moduloPage.validarTextoTela();
        Assertions.assertEquals(msg, "Cadastro de Módulos");
        moduloPage.preencherNome(moduloDTO.getNomeDoModulo());
        moduloPage.preencherLoginInstrutor(moduloDTO.getLoginDoInstrutorResponsavel());
        moduloPage.preencherConteudoProgramatico(moduloDTO.getConteudoProgramatico());
        moduloPage.clicarStatus();
        moduloPage.clicarInativo();
        moduloPage.clicarSalvar();
        String msg2 = moduloPage.validarErroCampoNome();
        Assertions.assertEquals("O campo Nome é obrigatório",msg2);

    }


    @Test
    @Feature("Modulo")
    @Story("Modulo cadastrado com sucesso")
    @Description("Testa se o cadastro de modulo está retorando mensagem de erro")
    @Severity(SeverityLevel.CRITICAL)
    public void testTentarCadastrarUmaModuloApenasComCamposObrigatorios() {
        ModuloDTO moduloDTO = moduloData.modulosCamposObrigatorios();
        moduloPage.clicarBtnModulo();
        moduloPage.clicarBtnModuloAdicionar();
        String msg = moduloPage.validarTextoTela();
        Assertions.assertEquals(msg, "Cadastro de Módulos");
        moduloPage.preencherNome(moduloDTO.getNomeDoModulo());
        moduloPage.clicarStatus();
        moduloPage.clicarAtivo();
        moduloPage.clicarSalvar();
        Assertions.assertEquals(moduloPage.obterValorDoPopup(), "Modulo cadastrado com sucesso!");
    }


    @Test
    @Feature("Modulo")
    @Story("Modulo cadastrado com sucesso")
    @Description("Testa se o cadastro de modulo está retorando mensagem de erro")
    @Severity(SeverityLevel.CRITICAL)
    public void testTentarCadastrarUmaModuloApenasComNomeCom51Caracteres() {
        ModuloDTO moduloDTO = moduloData.moduloComCampoNomeCom51Caractere();
        moduloPage.clicarBtnModulo();
        moduloPage.clicarBtnModuloAdicionar();
        String msg = moduloPage.validarTextoTela();
        Assertions.assertEquals(msg, "Cadastro de Módulos");
        moduloPage.preencherNome(moduloDTO.getNomeDoModulo());
        moduloPage.preencherLoginInstrutor(moduloDTO.getLoginDoInstrutorResponsavel());
        moduloPage.preencherConteudoProgramatico(moduloDTO.getConteudoProgramatico());
        moduloPage.clicarStatus();
        moduloPage.clicarAtivo();
        moduloPage.clicarSalvar();
        String msg2 = moduloPage.validarErroCampoNome();
        Assertions.assertEquals(msg2, "O campo Nome deve ter no máximo 50 caracteres");
    }


    @Test
    @Feature("Modulo")
    @Story("Modulo cadastrado com sucesso")
    @Description("Testa se o cadastro de modulo está retorando mensagem de erro")
    @Severity(SeverityLevel.CRITICAL)
    public void testTentarCadastrarUmaModuloApenasComNomeCom1Caracter() {
        ModuloDTO moduloDTO = moduloData.moduloComCampoNomeCom1Caractere();
        moduloPage.clicarBtnModulo();
        moduloPage.clicarBtnModuloAdicionar();
        String msg = moduloPage.validarTextoTela();
        Assertions.assertEquals(msg, "Cadastro de Módulos");
        moduloPage.preencherNome(moduloDTO.getNomeDoModulo());
        moduloPage.clicarStatus();
        moduloPage.clicarAtivo();
        moduloPage.clicarSalvar();
        String msg2 = moduloPage.validarErroCampoNome();
        Assertions.assertEquals(msg2, "O campo Nome deve ter pelo menos 2 caracteres");
    }

    @Test
    @Feature("Modulo")
    @Story("Modulo cadastrado com sucesso")
    @Description("Testa se o cadastro de modulo está retorando mensagem de erro")
    @Severity(SeverityLevel.CRITICAL)
    public void testTentarCadastrarUmaModuloApenasComDescricaoCom256Caracteres() {
        ModuloDTO moduloDTO = moduloData.moduloComCampoConteudoProgramatico256Caracteres();
        moduloPage.clicarBtnModulo();
        moduloPage.clicarBtnModuloAdicionar();
        String msg = moduloPage.validarTextoTela();
        Assertions.assertEquals(msg, "Cadastro de Módulos");
        moduloPage.preencherNome(moduloDTO.getNomeDoModulo());
        moduloPage.preencherLoginInstrutor(moduloDTO.getLoginDoInstrutorResponsavel());
        moduloPage.preencherConteudoProgramatico(moduloDTO.getConteudoProgramatico());
        moduloPage.clicarStatus();
        moduloPage.clicarAtivo();
        moduloPage.clicarSalvar();
        String msg2 = moduloPage.validarErroCampoConteudoProgramatico();
        Assertions.assertEquals(msg2, "O campo Conteúdo Programático deve ter no máximo 255 caracteres");

    }


}
