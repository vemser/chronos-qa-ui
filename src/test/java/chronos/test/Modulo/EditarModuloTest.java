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

public class EditarModuloTest extends BaseTest {

    ModuloPage moduloPage = new ModuloPage();
    LoginData loginData = new LoginData();
    ModuloData moduloData = new ModuloData();
    LoginPage loginPage = new LoginPage();
    ModuloDTO moduloDTO;

    @BeforeEach
    public void setup() {
        moduloDTO = moduloData.moduloValido();;
        LoginDTO loginValido = loginData.loginDadosValidos();
        loginPage.fazerLogin(loginValido.getUsername(), loginValido.getSenha());
        moduloPage.clicarBtnModulo();
        moduloPage.clicarBtnModuloAdicionar();
        moduloPage.preencherNome(moduloDTO.getNomeDoModulo());
        moduloPage.preencherLoginInstrutor(moduloDTO.getLoginDoInstrutorResponsavel());
        moduloPage.preencherConteudoProgramatico(moduloDTO.getConteudoProgramatico());
        moduloPage.clicarStatus();
        moduloPage.clicarAtivo();
        moduloPage.clicarSalvar();
        Assertions.assertEquals(moduloPage.obterValorDoPopup(), "Modulo cadastrado com sucesso!");
        moduloPage.fecharPopup();
    }

    @Test
    @Feature("Modulo")
    @Story("Modulo atualizado com sucesso")
    @Description("Testa se o é possível editar o modulo está retorando mensagem de sucesso")
    @Severity(SeverityLevel.CRITICAL)
    public void testEditarModuloComSucesso() {
        moduloPage.orderPorID();
        moduloPage.orderPorID();
        moduloPage.clicarDetalhes(moduloDTO.getNomeDoModulo());
        moduloPage.clicarEditarModulo();
        ModuloDTO moduloDTO1 = moduloData.moduloValido();
        moduloPage.preencherNome(moduloDTO1.getNomeDoModulo());
        moduloPage.preencherLoginInstrutor(moduloDTO1.getLoginDoInstrutorResponsavel());
        moduloPage.preencherConteudoProgramatico(moduloDTO1.getConteudoProgramatico());
        moduloPage.clicarStatus();
        moduloPage.clicarAtivo();
        moduloPage.clicarSalvar();
        Assertions.assertEquals("Módulo atualizado com sucesso!", moduloPage.obterValorDoPopup());
    }

    @Test
    @Feature("Modulo")
    @Story("Modulo cadastrado com sucesso")
    @Description("Testa se a edição de modulo está retorando mensagem de erro")
    @Severity(SeverityLevel.CRITICAL)
    public void testTentarEditarUmaModuloApenasComNomeVazio() {
        moduloPage.orderPorID();
        moduloPage.orderPorID();
        moduloPage.clicarDetalhes(moduloDTO.getNomeDoModulo());
        moduloPage.clicarEditarModulo();
        moduloPage.limparNome();
        moduloPage.clicarSalvar();
        String msg2 = moduloPage.validarErroCampoNome();
        Assertions.assertEquals("O campo Nome é obrigatório", msg2);

    }

    @Test
    @Feature("Modulo")
    @Story("Modulo cadastrado com sucesso")
    @Description("Testa se a edição de modulo está retorando mensagem de erro")
    @Severity(SeverityLevel.CRITICAL)
    public void testTentarEditarUmaModuloApenasCom51Caracteres() {
        moduloPage.orderPorID();
        moduloPage.orderPorID();
        moduloPage.clicarDetalhes(moduloDTO.getNomeDoModulo());
        moduloPage.clicarEditarModulo();
        ModuloDTO moduloDTO1 = moduloData.moduloComCampoNomeCom51Caractere();
        moduloPage.preencherNome(moduloDTO1.getNomeDoModulo());
        moduloPage.clicarSalvar();
        String msg2 = moduloPage.validarErroCampoNome();
        Assertions.assertEquals( "O campo Nome deve ter no máximo 50 caracteres", msg2);

    }

    @Test
    @Feature("Modulo")
    @Story("Modulo cadastrado com sucesso")
    @Description("Testa se a edição de modulo está retorando mensagem de erro")
    @Severity(SeverityLevel.CRITICAL)
    public void testTentarEditarUmaModuloApenasCom1Caractere() {
        moduloPage.orderPorID();
        moduloPage.orderPorID();
        moduloPage.clicarDetalhes(moduloDTO.getNomeDoModulo());
        moduloPage.clicarEditarModulo();
        ModuloDTO moduloDTO1 = moduloData.moduloComCampoNomeCom1Caractere();
        moduloPage.preencherNome(moduloDTO1.getNomeDoModulo());
        moduloPage.clicarSalvar();
        String msg2 = moduloPage.validarErroCampoNome();
        Assertions.assertEquals("O campo Nome deve ter pelo menos 2 caracteres", msg2);
    }
}
