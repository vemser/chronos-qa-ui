package chronos.data.factory.datafaker;

import chronos.utils.ConfigProperties;
import org.apache.commons.lang3.StringUtils;
import chronos.data.dto.LoginDTO;
import chronos.utils.DataFakerGenerator;

public class LoginData {

    DataFakerGenerator dataFakerGenerator = new DataFakerGenerator();

    public LoginDTO loginDadosValidos() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUsername(ConfigProperties.properties.getProperty("UserAdmin"));
        loginDTO.setSenha(ConfigProperties.properties.getProperty("PasswordAdmin"));
        return loginDTO;
    }

    public LoginDTO loginDadosDinamicos() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUsername(dataFakerGenerator.emailFaker());
        loginDTO.setSenha(dataFakerGenerator.senhaFaker());
        return loginDTO;
    }

    public LoginDTO loginCamposVazios() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUsername(StringUtils.EMPTY);
        loginDTO.setSenha(StringUtils.EMPTY);
        return loginDTO;
    }

    public LoginDTO loginSenhaInvalida() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUsername(ConfigProperties.properties.getProperty("UserAdmin"));
        loginDTO.setSenha(StringUtils.EMPTY);
        return loginDTO;
    }

    public LoginDTO loginUsernameValido() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUsername(StringUtils.EMPTY);
        loginDTO.setSenha(ConfigProperties.properties.getProperty("PasswordAdmin"));
        return loginDTO;
    }
}