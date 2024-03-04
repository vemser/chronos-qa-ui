package chronos.page;

import chronos.data.dto.TrilhaCadastroDTO;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class TrilhaPage extends BasePage {

    private static final By BTN_ABA_TRILHAS = By.cssSelector("div#root a:nth-child(6) > li > div > p");
    private static final By BTN_ADICIONAR_TRILHA = By.cssSelector("div#root section > div > button");
    private static final By TEXT_VALIDAR_ABA_TRILHA = By.cssSelector("div#root section > h2");
    private static final By INPUT_NOME_TRILHA = By.cssSelector("input[name=\"nome\"]");
    private static final By INPUT_DESCRICAO_TRILHA = By.cssSelector("input[name=\"descricao\"]");
    private static final By BTN_CADASTRAR_TRILHA = By.cssSelector("#root > section > section > div > form > div > button");
    private static final By TEXT_VALIDAR_CADASTRO = By.cssSelector("#root > section > section > h2");

    private static final By TEXT_MENSAGEM_NOME_INVALIDO = By.cssSelector("p[id=\":r1:-helper-text\"]");

    private static final By TEXT_MENSAGEM_NOME_EDICAO_INVALIDO = By.cssSelector("p[id=\":r8:-helper-text\"]");

    private static final By TEXT_MENSAGEM_DESCRICAO_256 = By.cssSelector("p[id=\":r2:-helper-text\"]");

    private static final By TEXT_MENSAGEM_DESCRICAO_EDICAO_256 = By.cssSelector("p[id=\":r9:-helper-text\"]");


    private static final By BTN_SALVAR_EDICAO = By.xpath("//button[contains(.,'Editar')]");
    private static final By BTN_EDITAR_TRILHA = By.xpath("//button[contains(.,'Editar Trilha')]");
    private static final By BTN_DATIVAR_TRILHA = By.xpath("//button[contains(.,'Desativar Trillha')]");

    private static final By MSG_DESATIVA = By.cssSelector("#\\35  > div.Toastify__toast-body > div:nth-child(2)");

    private static final By msgToast = By.xpath("//div[@role='alert']//div[2]");

    private static final By fecharPopup = By.xpath("//button[@aria-label='close']");
    public void irParaFormularioTrilhas() {
        clicar(BTN_ABA_TRILHAS);
        String validateAbaTrilhas = lerTextoVisivel(TEXT_VALIDAR_ABA_TRILHA);
        Assertions.assertEquals(validateAbaTrilhas, "Trilhas");
        clicar(BTN_ADICIONAR_TRILHA);
    }

    public void irParaEditarTrilha(){
        esperarElementoSerClicavel(BTN_EDITAR_TRILHA);
        clicar(BTN_EDITAR_TRILHA);

    }
    public void desativar(){
        esperarElementoSerClicavel(BTN_DATIVAR_TRILHA);
        clicar(BTN_DATIVAR_TRILHA);
    }
    public void enviarFormulario(String nome, String descricao) {
        preencherInput(INPUT_NOME_TRILHA, nome);
        preencherInput(INPUT_DESCRICAO_TRILHA, descricao);
        clicar(BTN_CADASTRAR_TRILHA);
    }

    public void cadastrarTrilhaComSucesso(TrilhaCadastroDTO formDTO) {
        irParaFormularioTrilhas();
        enviarFormulario(formDTO.getNomeTrilha(), formDTO.getDescricao());

        clicarElementoXPATH(formDTO.getNomeTrilha());
        String validarCadastroSucesso = lerTexto(TEXT_VALIDAR_CADASTRO);
        Assertions.assertTrue(validarCadastroSucesso.contains(formDTO.getNomeTrilha()));

    }

    public void cadastrarTrilhaSemNome(TrilhaCadastroDTO formDTO) {
        irParaFormularioTrilhas();
        enviarFormulario(formDTO.getNomeTrilha(), formDTO.getDescricao());

        String mensagemErroNome = lerTexto(TEXT_MENSAGEM_NOME_INVALIDO);
        Assertions.assertEquals(mensagemErroNome, "Campo Nome é obrigatório");
    }

    public void cadastrarTrilhaComDescricao256(TrilhaCadastroDTO formDTO) {
        irParaFormularioTrilhas();
        enviarFormulario(formDTO.getNomeTrilha(), formDTO.getDescricao());

        String mensagemErroDescricao = lerTexto(TEXT_MENSAGEM_DESCRICAO_256);
        Assertions.assertEquals(mensagemErroDescricao, "A descrição da trilha deve ter no máximo 255 caracteres");
    }
    public void cadastrarTrilhaComNome50(TrilhaCadastroDTO formDTO) {
        irParaFormularioTrilhas();
        enviarFormulario(formDTO.getNomeTrilha(), formDTO.getDescricao());

        String mensagemErroDescricao = lerTexto(TEXT_MENSAGEM_NOME_INVALIDO);
        Assertions.assertEquals(mensagemErroDescricao, "O nome da trilha deve ter no máximo 50 caracteres");
    }

    public void editarTrilhaComSucesso(TrilhaCadastroDTO formDTO){
        clicar(fecharPopup);
        irParaEditarTrilha();
        enviarFormularioEditado(formDTO.getNomeTrilha(), formDTO.getDescricao());
        clicar(BTN_SALVAR_EDICAO);
        esperarElementoSerVisivel(msgToast);
        String validarEdicaoSucesso = lerTexto(msgToast);
        Assertions.assertEquals( "Trilha atualizada com sucesso!", validarEdicaoSucesso);
    }
    public void enviarFormularioEditado(String nome, String descricao){
        preencherInput(INPUT_NOME_TRILHA, nome);
        preencherInput(INPUT_DESCRICAO_TRILHA, descricao);
    }

    public void editarTrilhaSemNome(TrilhaCadastroDTO formDTO) {
        clicar(fecharPopup);
        irParaEditarTrilha();
        enviarFormularioEditado(formDTO.getNomeTrilha(), formDTO.getDescricao());
        //clicar(BTN_SALVAR_EDICAO);
        String mensagemErroNome = lerTexto(TEXT_MENSAGEM_NOME_EDICAO_INVALIDO);
        Assertions.assertEquals( "Campo Nome é obrigatório", mensagemErroNome);
    }

    public void editarTrilhaComDescricao256(TrilhaCadastroDTO formDTO) {
        clicar(fecharPopup);
        irParaEditarTrilha();
        enviarFormularioEditado(formDTO.getNomeTrilha(), formDTO.getDescricao());
        clicar(BTN_SALVAR_EDICAO);
        String mensagemErroDescricao = lerTexto(TEXT_MENSAGEM_DESCRICAO_EDICAO_256);
        Assertions.assertEquals("A descrição da trilha deve ter no máximo 255 caracteres", mensagemErroDescricao);
    }
    public void editarTrilhaComNome50(TrilhaCadastroDTO formDTO) {
        clicar(fecharPopup);
        irParaEditarTrilha();
        enviarFormularioEditado(formDTO.getNomeTrilha(), formDTO.getDescricao());
        clicar(BTN_SALVAR_EDICAO);
        String mensagemErroDescricao = lerTexto(TEXT_MENSAGEM_NOME_EDICAO_INVALIDO);
        Assertions.assertEquals( "O nome da trilha deve ter no máximo 50 caracteres", mensagemErroDescricao);
    }

    public void desativarTrilhaComSucesso(TrilhaCadastroDTO formDTO){
        clicar(fecharPopup);
        desativar();
        esperarElementoSerVisivel(msgToast);
        String mensagemDesativada = lerTexto(msgToast);
        Assertions.assertEquals( "Trilha desativada com sucesso!", mensagemDesativada);


    }


}
