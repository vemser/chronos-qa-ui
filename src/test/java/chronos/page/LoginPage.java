package chronos.page;

import chronos.data.dto.LoginDTO;
import chronos.data.factory.datafaker.LoginData;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private static final By CAMPO_LOGIN = By.cssSelector("input#input-login-email");

    private static final By CAMPO_SENHA = By.cssSelector("input#senha");

    private static final By BTN_ACESSAR = By.cssSelector("button#button-login");

    private static final By LOGIN_MENSAGEM = By.cssSelector("#root > div > div > div > div > div:nth-child(2)");


    public void fazerLogin(String username, String senha) {
        preencherInput(CAMPO_LOGIN, username);
        preencherInput(CAMPO_SENHA, senha);
        clicar(BTN_ACESSAR);
    }

    public void fazerLogin(LoginDTO loginDTO) {
        preencherInput(CAMPO_LOGIN, loginDTO.getUsername());
        preencherInput(CAMPO_SENHA, loginDTO.getSenha());
        clicar(BTN_ACESSAR);
    }

    public String loginIncorreto(String username, String senha) {
        preencherInput(CAMPO_LOGIN, username);
        preencherInput(CAMPO_SENHA, senha);
        clicar(BTN_ACESSAR);
        return lerTexto(LOGIN_MENSAGEM);
    }
}