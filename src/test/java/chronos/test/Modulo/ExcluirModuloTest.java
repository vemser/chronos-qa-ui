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

public class ExcluirModuloTest extends BaseTest {
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
    }

    @Test
    @Feature("Modulo")
    @Story("Modulo excluido com sucesso")
    @Description("Testa se o é possível excluir o modulo ativo está retornando mensagem de sucesso")
    @Severity(SeverityLevel.CRITICAL)
    public void testExcluirModuloComSucesso() {

        moduloPage.clicarAtivo();
        moduloPage.clicarSalvar();
        Assertions.assertEquals(moduloPage.obterValorDoPopup(), "Modulo cadastrado com sucesso!");
        moduloPage.fecharPopup();
        moduloPage.orderPorID();
        moduloPage.orderPorID();
        moduloPage.clicarDetalhes(moduloDTO.getNomeDoModulo());
        moduloPage.clicarExcluirModulo();
        Assertions.assertEquals("Módulo desvinculado com sucesso!", moduloPage.obterValorDoPopup());
    }

    @Test
    @Feature("Modulo")
    @Story("Modulo excluido com sucesso")
    @Description("Testa se o é possível excluir o modulo inativo está retornando mensagem de erro")
    @Severity(SeverityLevel.CRITICAL)
    public void testExcluirModuloInativo() {

        moduloPage.clicarInativo();
        moduloPage.clicarSalvar();
        Assertions.assertEquals(moduloPage.obterValorDoPopup(), "Modulo cadastrado com sucesso!");
        moduloPage.fecharPopup();
        moduloPage.orderPorID();
        moduloPage.orderPorID();
        moduloPage.clicarDetalhes(moduloDTO.getNomeDoModulo());
        Assertions.assertFalse(moduloPage.validarExcluirModuloExiste());
    }
}
