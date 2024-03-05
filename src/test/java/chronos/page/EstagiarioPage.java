package chronos.page;

import chronos.data.dto.EstagiarioDTO;
import org.openqa.selenium.By;


public class EstagiarioPage extends BasePage {

    public static final By BTN_ESTAGIARIO_MENU_LATERAL = By.cssSelector("#root > section > div > div > div > nav > ul > div:nth-child(1) > a:nth-child(3) > li > div > p");
    public static final By BTN_CRIAR_ESTAGIARIO = By.cssSelector("#root > section > section > div > button");
    public static final By INPUT_NOME_ESTAGIARIO = By.cssSelector("input[name=\"nome\"]");
    public static final By INPUT_CURSO_ESTAGIARIO = By.cssSelector("input[name=\"curso\"]");
    public static final By INPUT_CPF = By.cssSelector("input[name=\"cpf\"]");
    public static final By INPUT_INSTITUICAO = By.cssSelector("input[name=\"instituicaoEnsino\"]");
    public static final By INPUT_GITHUB = By.cssSelector("input[name=\"github\"]");
    public static final By SELECT_DATA = By.cssSelector("input[name=\"dataNascimento\"]");
    public static final By INPUT_LINKEDIN = By.cssSelector("input[name=\"linkedin\"]");
    public static final By INPUT_TELEFONE = By.cssSelector("input[name=\"telefone\"]");
    public static final By SELECT_STATUS = By.cssSelector("#\\:r1s\\:");
    public static final By SELECT_STATUS_ATUALIZAR = By.cssSelector("#\\:r2h\\:");
    public static final By EMAIL_PESSOAL = By.cssSelector("input[name=\"emailPessoal\"]");
    public static final By OBSERVACAO = By.cssSelector("textarea[name=\"observacao\"]");
    public static final By INPUT_EMAIL_CORP = By.cssSelector("input[name=\"emailCorporativo\"]");
    public static final By SELECT_EDICAO = By.cssSelector("#\\:r1v\\:");
    public static final By SELECT_EDICAO_ATUALIZAR = By.cssSelector("#\\:r22\\:");
    public static final By btn1Edicao = By.xpath("//li[@data-value='1']");
    public static final By SELECT_TRILHA = By.cssSelector("#\\:r21\\:");
    public static final By SELECT_TRILHAR_ATUALIZAR = By.cssSelector("#\\:r24\\:");
    public static final By btn12Trilha = By.xpath("//li[@data-value='1']");
    private static final By btnDisponivel = By.xpath("//li[@data-value='DIS']");
    private static final By btnMG = By.xpath("//li[@data-value='MG']");
    public static final By INPUT_CIDADE = By.cssSelector("input[name=\"cidade\"]");
    public static final By SELECT_ESTADO = By.cssSelector("#\\:r1m\\:");
    public static final By SELECT_ESTADO_ATUALIZAR = By.cssSelector("#\\:r2b\\:");
    public static final By CADASTRAR_ESTAGIARIO = By.cssSelector("#root > section > section > div > div > form > div.MuiBox-root.css-kl1xo3 > button");

    public static final By BTN_DETALHES_ESTAGIARIO = By.cssSelector("#root > section > section > div > div > div.MuiDataGrid-main.css-opb0c2 > div:nth-child(2) > div > div > div > div:nth-child(1) > div:nth-child(6) > button > svg");
    public static final By BTN_EDITAR_ESTAGIARIO = By.cssSelector("#root > section > section > div > div > div.MuiBox-root.css-8yngjd > button");

    public void cadastrarEstagiario(EstagiarioDTO estagiarioACadastrar) {
        clicar(BTN_ESTAGIARIO_MENU_LATERAL);
        clicar(BTN_CRIAR_ESTAGIARIO);
        clicar(SELECT_STATUS);
        clicar(btnDisponivel);
        clicar(SELECT_ESTADO);
        clicar(btnMG);
        clicar(SELECT_EDICAO);
        clicar(btn1Edicao);
        clicar(SELECT_TRILHA);
        clicar(btn12Trilha);
        preencherInput(INPUT_NOME_ESTAGIARIO, estagiarioACadastrar.getNome());
        preencherInput(INPUT_CURSO_ESTAGIARIO, estagiarioACadastrar.getCurso());
        preencherInput(INPUT_CPF, estagiarioACadastrar.getCPF());
        preencherInput(INPUT_INSTITUICAO, estagiarioACadastrar.getInstituicao());
        preencherInput(INPUT_GITHUB, estagiarioACadastrar.getGithub());
        preencherInput(INPUT_LINKEDIN, estagiarioACadastrar.getLinkedin());
        preencherInput(INPUT_TELEFONE, estagiarioACadastrar.getTelefone());
        preencherInput(EMAIL_PESSOAL, estagiarioACadastrar.getEmailPessoal());
        preencherInput(INPUT_EMAIL_CORP, estagiarioACadastrar.getEmailCorporativo());
        preencherInput(OBSERVACAO, estagiarioACadastrar.getObservacao());
        preencherInput(INPUT_CIDADE, estagiarioACadastrar.getCidade());
        selecionarData(SELECT_DATA, estagiarioACadastrar.getDataNascimento());
        clicar(CADASTRAR_ESTAGIARIO);
    }

    public void atualizarEstagiario(EstagiarioDTO estagiarioAAtualizar) {
        clicar(BTN_ESTAGIARIO_MENU_LATERAL);
        clicar(BTN_DETALHES_ESTAGIARIO);
        clicar(BTN_EDITAR_ESTAGIARIO);
        clicar(SELECT_STATUS_ATUALIZAR);
        clicar(btnDisponivel);
        clicar(SELECT_ESTADO_ATUALIZAR);
        clicar(btnMG);
        preencherInput(INPUT_NOME_ESTAGIARIO, estagiarioAAtualizar.getNome());
        preencherInput(INPUT_CURSO_ESTAGIARIO, estagiarioAAtualizar.getCurso());
        preencherInput(INPUT_INSTITUICAO, estagiarioAAtualizar.getInstituicao());
        preencherInput(INPUT_GITHUB, estagiarioAAtualizar.getGithub());
        preencherInput(INPUT_LINKEDIN, estagiarioAAtualizar.getLinkedin());
        preencherInput(INPUT_TELEFONE, estagiarioAAtualizar.getTelefone());
        preencherInput(EMAIL_PESSOAL, estagiarioAAtualizar.getEmailPessoal());
        preencherInput(INPUT_EMAIL_CORP, estagiarioAAtualizar.getEmailCorporativo());
        preencherInput(OBSERVACAO, estagiarioAAtualizar.getObservacao());
        preencherInput(INPUT_CIDADE, estagiarioAAtualizar.getCidade());
        clicar(CADASTRAR_ESTAGIARIO);
    }

    public void cadastrarEstagiarioSemStatus(EstagiarioDTO estagiarioACadastrar) {
        clicar(BTN_ESTAGIARIO_MENU_LATERAL);
        clicar(BTN_CRIAR_ESTAGIARIO);
        clicar(SELECT_ESTADO);
        clicar(btnMG);
        clicar(SELECT_EDICAO);
        clicar(btn1Edicao);
        clicar(SELECT_TRILHA);
        clicar(btn12Trilha);
        preencherInput(INPUT_NOME_ESTAGIARIO, estagiarioACadastrar.getNome());
        preencherInput(INPUT_CURSO_ESTAGIARIO, estagiarioACadastrar.getCurso());
        preencherInput(INPUT_CPF, estagiarioACadastrar.getCPF());
        preencherInput(INPUT_INSTITUICAO, estagiarioACadastrar.getInstituicao());
        preencherInput(INPUT_GITHUB, estagiarioACadastrar.getGithub());
        preencherInput(INPUT_LINKEDIN, estagiarioACadastrar.getLinkedin());
        preencherInput(INPUT_TELEFONE, estagiarioACadastrar.getTelefone());
        preencherInput(EMAIL_PESSOAL, estagiarioACadastrar.getEmailPessoal());
        preencherInput(INPUT_EMAIL_CORP, estagiarioACadastrar.getEmailCorporativo());
        preencherInput(OBSERVACAO, estagiarioACadastrar.getObservacao());
        preencherInput(INPUT_CIDADE, estagiarioACadastrar.getCidade());
        selecionarData(SELECT_DATA, estagiarioACadastrar.getDataNascimento());
        clicar(CADASTRAR_ESTAGIARIO);
    }

    public void cadastrarEstagiarioSemEstado(EstagiarioDTO estagiarioACadastrar) {
        clicar(BTN_ESTAGIARIO_MENU_LATERAL);
        clicar(BTN_CRIAR_ESTAGIARIO);
        clicar(SELECT_STATUS);
        clicar(btnDisponivel);
        clicar(SELECT_EDICAO);
        clicar(btn1Edicao);
        clicar(SELECT_TRILHA);
        clicar(btn12Trilha);
        preencherInput(INPUT_NOME_ESTAGIARIO, estagiarioACadastrar.getNome());
        preencherInput(INPUT_CURSO_ESTAGIARIO, estagiarioACadastrar.getCurso());
        preencherInput(INPUT_CPF, estagiarioACadastrar.getCPF());
        preencherInput(INPUT_INSTITUICAO, estagiarioACadastrar.getInstituicao());
        preencherInput(INPUT_GITHUB, estagiarioACadastrar.getGithub());
        preencherInput(INPUT_LINKEDIN, estagiarioACadastrar.getLinkedin());
        preencherInput(INPUT_TELEFONE, estagiarioACadastrar.getTelefone());
        preencherInput(EMAIL_PESSOAL, estagiarioACadastrar.getEmailPessoal());
        preencherInput(INPUT_EMAIL_CORP, estagiarioACadastrar.getEmailCorporativo());
        preencherInput(OBSERVACAO, estagiarioACadastrar.getObservacao());
        preencherInput(INPUT_CIDADE, estagiarioACadastrar.getCidade());
        selecionarData(SELECT_DATA, estagiarioACadastrar.getDataNascimento());
        clicar(CADASTRAR_ESTAGIARIO);
    }

    public void cadastrarEstagiarioSemDataNasc(EstagiarioDTO estagiarioACadastrar) {
        clicar(BTN_ESTAGIARIO_MENU_LATERAL);
        clicar(BTN_CRIAR_ESTAGIARIO);
        clicar(SELECT_STATUS);
        clicar(btnDisponivel);
        clicar(SELECT_ESTADO);
        clicar(btnMG);
        clicar(SELECT_EDICAO);
        clicar(btn1Edicao);
        clicar(SELECT_TRILHA);
        clicar(btn12Trilha);
        preencherInput(INPUT_NOME_ESTAGIARIO, estagiarioACadastrar.getNome());
        preencherInput(INPUT_CURSO_ESTAGIARIO, estagiarioACadastrar.getCurso());
        preencherInput(INPUT_CPF, estagiarioACadastrar.getCPF());
        preencherInput(INPUT_INSTITUICAO, estagiarioACadastrar.getInstituicao());
        preencherInput(INPUT_GITHUB, estagiarioACadastrar.getGithub());
        preencherInput(INPUT_LINKEDIN, estagiarioACadastrar.getLinkedin());
        preencherInput(INPUT_TELEFONE, estagiarioACadastrar.getTelefone());
        preencherInput(EMAIL_PESSOAL, estagiarioACadastrar.getEmailPessoal());
        preencherInput(INPUT_EMAIL_CORP, estagiarioACadastrar.getEmailCorporativo());
        preencherInput(OBSERVACAO, estagiarioACadastrar.getObservacao());
        preencherInput(INPUT_CIDADE, estagiarioACadastrar.getCidade());
        clicar(CADASTRAR_ESTAGIARIO);
    }
}
