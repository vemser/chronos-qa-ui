package chronos.page;

import chronos.data.dto.EtapaDTO;
import chronos.test.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class EtapaPage extends BasePage {

    public static final By BTN_CADASTRAR_ETAPA = By.cssSelector("div#root div:nth-child(3) > button");

    public static final By INPUT_NOME_ETAPA = By.cssSelector("input#etapa-nome");

    public static final By INPUT_ORDEM_EXECUCAO = By.cssSelector("input#etapa-ordemExecucao");

    public static final By INPUT_DIAS_UTEIS = By.cssSelector("input#dataInicial");
    public static final By BTN_CONFIRMAR_ATUALIZAR = By.cssSelector("#\\:ru\\:");

    public static final By INPUT_DIAS_UTEIS_EDITAR = By.cssSelector("#etapa-duracaoDiaUtil");
    public static final By BTN_CADASTRAR_ETAPA_CONFIRMAR = By.cssSelector("#\\:rq\\:");

    public static final By BTN_EXIBIR_ETAPAS = By.cssSelector("#root > section > section > div.containerCardDetails > div.MuiTableContainer-root.css-13g00hf > table > thead > tr > th:nth-child(1) > button > svg");
    public static final By NOME_ETAPA_CADASTRADA = By.cssSelector("#root > section > section > div.containerCardDetails > div.MuiTableContainer-root.css-13g00hf > table > tbody > tr:nth-child(5) > td:nth-child(2)");
    public static final By ORDEM_ETAPA_CADASTRADA = By.cssSelector("#root > section > section > div.containerCardDetails > div.MuiTableContainer-root.css-13g00hf > table > tbody > tr:nth-child(5) > td:nth-child(3)");
    public static final By DURACAO_ETAPA_CADASTRADA = By.cssSelector("#root > section > section > div.containerCardDetails > div.MuiTableContainer-root.css-13g00hf > table > tbody > tr:nth-child(5) > td:nth-child(4)");

    public static final By BTN_CONFIRMAR_EXCLUIR_ETAPA = By.cssSelector("body > div.MuiModal-root.css-8ndowl > div.MuiBox-root.css-1hekq3v > div > button.custom-button.custom-button-color.custom-button-background-primary.custom-button-border-small.custom-button-width-medium");
    public static final By BTN_EXCLUIR_ETAPA = By.cssSelector("#root > section > section > div.containerCardDetails > div.MuiTableContainer-root.css-13g00hf > table > tbody > tr:nth-child(4) > td:nth-child(7) > button > svg");
    public static final By BTN_EDITAR_ETAPA = By.cssSelector("#root > section > section > div.containerCardDetails > div.MuiTableContainer-root.css-13g00hf > table > tbody > tr:nth-child(5) > td:nth-child(6) > button > svg");
    public void cadastrarEtapa(EtapaDTO etapaACadastrar) {
        clicar(BTN_CADASTRAR_ETAPA);
        preencherInput(INPUT_NOME_ETAPA, etapaACadastrar.getNome());
        preencherInput(INPUT_ORDEM_EXECUCAO, String.valueOf(etapaACadastrar.getOrdemExecucao()));
        preencherInput(INPUT_DIAS_UTEIS, String.valueOf(etapaACadastrar.getDuracaoDiaUtil()));
        clicarEsperandoSerClicavel(BTN_CADASTRAR_ETAPA_CONFIRMAR);
    }

    public void atualizarEtapa(EtapaDTO etapaAAtualizar) {
        clicar(BTN_EXIBIR_ETAPAS);
        clicar(BTN_EDITAR_ETAPA);
        preencherInput(INPUT_NOME_ETAPA, etapaAAtualizar.getNome());
        preencherInput(INPUT_ORDEM_EXECUCAO, String.valueOf(etapaAAtualizar.getOrdemExecucao()));
        preencherInput(INPUT_DIAS_UTEIS_EDITAR, String.valueOf(etapaAAtualizar.getDuracaoDiaUtil()));
        clicarEsperandoSerClicavel(BTN_CONFIRMAR_ATUALIZAR);
    }

    public void deletarEtapa() {
        clicar(BTN_EXIBIR_ETAPAS);
        clicar(BTN_EXCLUIR_ETAPA);
        clicar(BTN_CONFIRMAR_EXCLUIR_ETAPA);
    }

    public void cadastrarEtapaSemOrdemExecucao(EtapaDTO etapaACadastrar) {
        clicar(BTN_CADASTRAR_ETAPA);
        preencherInput(INPUT_NOME_ETAPA, etapaACadastrar.getNome());
        preencherInput(INPUT_DIAS_UTEIS, String.valueOf(etapaACadastrar.getDuracaoDiaUtil()));
        clicarEsperandoSerClicavel(BTN_CADASTRAR_ETAPA_CONFIRMAR);
    }
    public void cadastrarEtapaSemDuracaoDiasUteis(EtapaDTO etapaACadastrar) {
        clicar(BTN_CADASTRAR_ETAPA);
        preencherInput(INPUT_NOME_ETAPA, etapaACadastrar.getNome());
        preencherInput(INPUT_ORDEM_EXECUCAO, String.valueOf(etapaACadastrar.getOrdemExecucao()));
        clicarEsperandoSerClicavel(BTN_CADASTRAR_ETAPA_CONFIRMAR);
    }
    public void validarInformacoesCadastradasEtapa(EtapaDTO etapaCadastrada) {
        clicar(BTN_EXIBIR_ETAPAS);
        String textoDoElementoNomeEtapaCadastrada = lerTexto(NOME_ETAPA_CADASTRADA);
        String textoDoElementoOrdemExecucaoEtapaCadastrada = lerTexto(ORDEM_ETAPA_CADASTRADA);
        String textoDoElementoDuracaoEtapaCadastrada = lerTexto(DURACAO_ETAPA_CADASTRADA);
        Assertions.assertEquals(etapaCadastrada.getNome(), textoDoElementoNomeEtapaCadastrada);
        Assertions.assertEquals(String.valueOf(etapaCadastrada.getOrdemExecucao()), textoDoElementoOrdemExecucaoEtapaCadastrada);
        Assertions.assertEquals(String.valueOf(etapaCadastrada.getDuracaoDiaUtil()), textoDoElementoDuracaoEtapaCadastrada);
    }
}