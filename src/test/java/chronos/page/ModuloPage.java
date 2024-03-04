package chronos.page;

import org.openqa.selenium.By;

public class ModuloPage extends BasePage {


    private static final By btnModulo = By.cssSelector("#root > section > div.MuiDrawer-root.MuiDrawer-docked.css-1tu59u4 > div > div > nav > ul > div:nth-child(1) > a:nth-child(7) > li > div");
    private static final By telaModulo = By.cssSelector("#root > section > section > h2");
    private static final By btnAdicionarModulo = By.cssSelector("#root > section > section > div.button > a > button");
    private static final By nomeModulo = By.cssSelector("#input-name");

    private static final By loginInstrutor = By.cssSelector("#input-instructor");

    private static final By conteudoProgramatico = By.cssSelector("#input-content");

    private static final By status = By.cssSelector("#select-helper");

    private static final By salvar = By.cssSelector("#root > section > section > div > form > button");

    private static final By moduloCadastrado = By.cssSelector("#\\31  > div.Toastify__toast-body > div:nth-child(2)");

    private static final By btnAtivo = By.xpath("//li[@data-value='ATIVO']");
    private static final By btnInativo = By.xpath("//li[@data-value='INATIVO']");

    // Campos mensagem de erro

    private static final By erroInputName = By.xpath("//p[@id='input-name-helper-text']");

    private static final By erroInputConteudoProgramatico = By.xpath("//p[@id='input-content-helper-text']");

    // Tela da tabela módulos

    private static final String botaoDetalhes = "//div[@data-field='nome']//div[text()='#']//..//..//button";

    private static final By msgToast = By.xpath("//div[@role='alert']//div[2]");

    private static final By odernarPorID = By.xpath("//div[text()='ID']");

    private static final By fecharPopup = By.xpath("//button[@aria-label='close']");

    // Tela de detalhes

    private static final By botaoEditarModulo = By.xpath("//td//*[@data-testid='EditIcon']//..");

    private static final By botaoExcluirModulo = By.xpath("//td//*[@data-testid='DeleteIcon']//..");


    public void clicarBtnModulo() {
        clicar(btnModulo);
    }

    public String validarTextoTela() {
        return lerTexto(telaModulo);
    }

    public void clicarBtnModuloAdicionar() {
        clicar(btnAdicionarModulo);
    }


    public void preencherLoginInstrutor(String login) {
        System.out.println(login);
        preencherInput(loginInstrutor, login);
    }

    public void preencherNome(String nome) {
        System.out.println(nome);
        preencherInput(nomeModulo, nome);
    }

    public void limparNome(){
        limparInput(nomeModulo);
    }
    public void preencherConteudoProgramatico(String conteudo) {
        System.out.println(conteudo);
        preencherInput(conteudoProgramatico, conteudo);
    }

    public void clicarStatus() {
        clicar(status);
    }

    public void clicarSalvar() {
        clicar(salvar);
    }

    public String validarTextoTelaCadastroValido() {
        return lerTexto(moduloCadastrado);

    }

    public void clicarAtivo() {
        clicar(btnAtivo);
    }

    public void clicarInativo() {
        clicar(btnInativo);
    }

    public String validarErroCampoNome() {
        return lerTexto(erroInputName);

    }

    public String validarErroCampoConteudoProgramatico() {
        return lerTexto(erroInputConteudoProgramatico);
    }

    // Tabela de módulos

    public void clicarDetalhes(String valor)
    {
        esperarElementoSerClicavel(By.xpath(botaoDetalhes.replace("#", valor)));
        clicar(By.xpath(botaoDetalhes.replace("#", valor)));
    }

    public void orderPorID(){
        clicar(odernarPorID);
    }

    public void clicarEditarModulo(){
        clicar(botaoEditarModulo);
    }

    public void clicarExcluirModulo(){
        clicar(botaoExcluirModulo);
    }

    public boolean validarExcluirModuloExiste(){
        return validarSeElementoExiste(botaoExcluirModulo);
    }

    public String obterValorDoPopup(){
        esperarElementoSerVisivel(msgToast);
        return lerTexto(msgToast);
    }

    public void fecharPopup(){
        clicar(fecharPopup);
    }

}
