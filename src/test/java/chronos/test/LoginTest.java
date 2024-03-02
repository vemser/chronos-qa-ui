package chronos.test;
import chronos.page.BasePage;
import io.qameta.allure.*;
import org.junit.Assert;
import org.junit.Test;
import chronos.data.dto.LoginDTO;
import chronos.data.factory.datafaker.LoginData;
import chronos.page.LoginPage;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    LoginData loginData = new LoginData();

    private static final By LOGIN_MENSAGEM = By.cssSelector("span#login-error-email");

    private static final By PASSWORD_MENSAGEM = By.cssSelector("span#login-error-senha");

    private static final By GREETINGS_MENSAGEM = By.cssSelector("#root > section > div.MuiDrawer-root.MuiDrawer-docked.css-1tu59u4 > div > div > div > p");

    @Test
    @Feature("Login")
    @Story("Login valido com sucesso")
    @Description("Testa se o usuário consegue efetuar o login com dados validos e se de fato esta logado na pagina")
    @Severity(SeverityLevel.CRITICAL)
    public void validarLoginComDadosValidos(){
        LoginDTO loginValido = loginData.loginDadosValidos();
        loginPage.fazerLogin(loginValido.getUsername(), loginValido.getSenha());
        String mensagem = BasePage.lerTexto(GREETINGS_MENSAGEM);
        Assert.assertEquals("Olá,", mensagem);
    };

    @Test
    @Feature("Login")
    @Story("Login invalido com mensagem de erro")
    @Description("Testa se o usuário ao efetuar login com dados invalidos recebe a mensagem apropriada")
    @Severity(SeverityLevel.CRITICAL)
    public void validarLoginComDadosInvalidos() {
        LoginDTO loginInvalido = loginData.loginDadosDinamicos();
        String mensagem = loginPage.loginIncorreto(loginInvalido.getUsername(), loginInvalido.getSenha());
        Assert.assertEquals("Login informado não segue o padrão @dbccompany.com.br", mensagem);
    }

    @Test
    @Feature("Login")
    @Story("Login com campos vazios")
    @Description("Testa se o usuário ao efetuar login sem preencher nenhum campo recebe a mensagem apropriada")
    @Severity(SeverityLevel.CRITICAL)
    public void validarLoginTodosDadosVazios(){
        LoginDTO usuario = loginData.loginCamposVazios();
        loginPage.fazerLogin(usuario.getUsername(), usuario.getSenha());
        String mensagemErroLogin = BasePage.lerTexto(LOGIN_MENSAGEM);
        String mensagemErroPassword = BasePage.lerTexto(PASSWORD_MENSAGEM);
        Assert.assertEquals("Por favor, digite seu Login!", mensagemErroLogin);
        Assert.assertEquals("Por favor, digite sua senha!", mensagemErroPassword);
    }

    @Test
    @Feature("Login")
    @Story("Login com campos senha vazio")
    @Description("Testa se o usuário ao efetuar login sem preencher campo da senha recebe mensagem apropriada")
    @Severity(SeverityLevel.CRITICAL)
    public void validarLoginCampoSenhaVazio(){
        LoginDTO usuario = loginData.loginSenhaInvalida();
        loginPage.fazerLogin(usuario.getUsername(), usuario.getSenha());
        String mensagemErroPassword = BasePage.lerTexto(PASSWORD_MENSAGEM);
        Assert.assertEquals("Por favor, digite sua senha!", mensagemErroPassword);
    }

    @Test
    @Feature("Login")
    @Story("Login com email valido e senha vazia")
    @Description("Testa se o usuário ao efetuar login preenchendo um email valido e nao inserindo uma senha recebe a mensagem apropriada")
    @Severity(SeverityLevel.CRITICAL)
    public void validarLoginComUsernameVazioESenhaValida(){
        LoginDTO usuario = loginData.loginUsernameValido();
        loginPage.fazerLogin(usuario.getUsername(), usuario.getSenha());
        String mensagemErroLogin = BasePage.lerTexto(LOGIN_MENSAGEM);
        Assert.assertEquals("Por favor, digite seu Login!", mensagemErroLogin);
    }
}
