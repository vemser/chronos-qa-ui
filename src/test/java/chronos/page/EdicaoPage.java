package chronos.page;


import chronos.data.dto.EdicaoDTO;
import chronos.utils.FormatarData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;



public class EdicaoPage extends BasePage {

    FormatarData formatarData = new FormatarData();

    private static final By BTN_CADASTRAR_EDICAO = By.cssSelector("div#root section > div > button");

    private static final By BTN_EDICAO_MENU_LATERAL = By.cssSelector("div#root a:nth-child(5) > li > div > p");
    private static final By CAMPO_NOME = By.cssSelector("input#edicao-nome");

    private static final By CAMPO_DESCRICAO = By.cssSelector("input#edicao-descricao");

    private static final By SELECT_DATA_INICIO = By.cssSelector("input#dataInicial");

    private static final By BTN_EXCLUIR_EDICAO = By.cssSelector("#root > section > section > div.containerCardDetails > div.containerInfosEdicao > div.containerButtons > button.custom-button.custom-button-color.custom-button-background-delete.custom-button-border-small.custom-button-width-medium.custom-button-hover-delete");

    private static final By BTN_EXCLUIR_EDICAO_CONFIRMAR = By.cssSelector("body > div.MuiModal-root.css-8ndowl > div.MuiBox-root.css-1hekq3v > div > button.custom-button.custom-button-color.custom-button-background-background.custom-button-border-small.custom-button-width-medium.custom-button-font-small");

    private static final By DESCRICAO_EDICAO = By.cssSelector("div#root p:nth-child(3) > span");
    private static final By NOME_EDICAO = By.cssSelector("#root > section > section > h2");

    private static final By DATA_INICIO_EDICAO = By.cssSelector("div#root p:nth-child(1) > span");
    private static final By DATA_FIM_EDICAO = By.cssSelector("div#root p:nth-child(2) > span");
    private static final By STATUS_EDICAO = By.cssSelector("div#root p:nth-child(4) > span");
    private static final By BTN_EDITAR_EDICAO = By.cssSelector("#root > section > section > div.containerCardDetails > div.containerInfosEdicao > div.containerButtons > button:nth-child(1)");

    private static final By BTN_CRIAR_EDICAO = By.cssSelector("#\\:r6\\:");
    private static final By BTN_EDITAR_EDICAO_CONFIRMAR = By.cssSelector("#\\:rc\\:");
    public void cadastrarEdicao(EdicaoDTO edicaoACadastrar) {
        clicar(BTN_EDICAO_MENU_LATERAL);
        clicar(BTN_CADASTRAR_EDICAO);
        preencherInput(CAMPO_NOME, edicaoACadastrar.getNome());
        preencherInput(CAMPO_DESCRICAO, edicaoACadastrar.getDescricao());
        selecionarData(SELECT_DATA_INICIO, edicaoACadastrar.getDataInicial());
        clicarEsperandoSerClicavel(BTN_CRIAR_EDICAO);
    }

    public void atualizarEdicao(EdicaoDTO edicaoAAtualizar, String nomeEdicaoCadastrada) {
        clicarElementoXPATH(nomeEdicaoCadastrada);
        clicar(BTN_EDITAR_EDICAO);
        preencherInput(CAMPO_NOME, edicaoAAtualizar.getNome());
        preencherInput(CAMPO_DESCRICAO, edicaoAAtualizar.getDescricao());
        selecionarData(SELECT_DATA_INICIO, edicaoAAtualizar.getDataInicial());
        clicarEsperandoSerClicavel(BTN_EDITAR_EDICAO_CONFIRMAR);
    }

    public void cadastrarEdicaoSemData(EdicaoDTO edicaoACadastrar) {
        clicar(BTN_EDICAO_MENU_LATERAL);
        clicar(BTN_CADASTRAR_EDICAO);
        preencherInput(CAMPO_NOME, edicaoACadastrar.getNome());
        preencherInput(CAMPO_DESCRICAO, edicaoACadastrar.getDescricao());
        clicarEsperandoSerClicavel(BTN_CRIAR_EDICAO);
    }

    public void atualizarEdicaoSemData(EdicaoDTO edicaoACadastrar, String nomeEdicaoCadastrada) {
        clicarElementoXPATH(nomeEdicaoCadastrada);
        clicar(BTN_EDITAR_EDICAO);
        preencherInput(CAMPO_NOME, edicaoACadastrar.getNome());
        preencherInput(CAMPO_DESCRICAO, edicaoACadastrar.getDescricao());
        clicarEsperandoSerClicavel(BTN_EDITAR_EDICAO_CONFIRMAR);
    }


    public void validarInformacoesCadastradasEdicao(EdicaoDTO edicaoCadastrada) {
        clicarElementoXPATH(edicaoCadastrada.getNome());
        String textoDoElementoNomeEdicaoCadastrada = lerTexto(NOME_EDICAO);
        String textoDoElementoDescricaoEdicaoCadastrada = lerTexto(DESCRICAO_EDICAO);
        String textoDoElementoDataInicioEdicaoCadastrada = lerTexto(DATA_INICIO_EDICAO);
        String textoDoElementoStatusEdicaoCadastrada = lerTexto(STATUS_EDICAO);
        Assertions.assertEquals("Detalhes " + edicaoCadastrada.getNome(), textoDoElementoNomeEdicaoCadastrada);
        Assertions.assertEquals(edicaoCadastrada.getDescricao(), textoDoElementoDescricaoEdicaoCadastrada);
        Assertions.assertEquals(formatarData.formatarData(edicaoCadastrada.getDataInicial()), textoDoElementoDataInicioEdicaoCadastrada);
        Assertions.assertEquals("Ativo", textoDoElementoStatusEdicaoCadastrada);
        clicarEsperandoSerClicavel(BTN_EDICAO_MENU_LATERAL);
    }

    public void excluirEdicaoComSucesso(String nomeEdicaoCadastrada) {
        clicarElementoXPATH(nomeEdicaoCadastrada);
        clicar(BTN_EXCLUIR_EDICAO);
        clicarEsperandoSerClicavel(BTN_EXCLUIR_EDICAO_CONFIRMAR);
    }

    public void excluirEdicaoComSucessoRetornandoEdicao(String nomeEdicaoCadastrada) {
        clicar(BTN_EDICAO_MENU_LATERAL);
        clicarElementoXPATH(nomeEdicaoCadastrada);
        clicar(BTN_EXCLUIR_EDICAO);
        clicarEsperandoSerClicavel(BTN_EXCLUIR_EDICAO_CONFIRMAR);
    }
}
