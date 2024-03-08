package chronos.page;

import chronos.data.factory.seleniumfactory.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.LocalDate;

public class BasePage extends Elements {

    public static final By ADICIONAR_CONFIRMAR_MOLDE = By.cssSelector("#DownloadButtonModelo");

    public static void preencherInput(By by, String text) {
        esperarElemento(by);
        WebElement elemento = element(by);
        elemento.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        elemento.sendKeys(Keys.DELETE);
        limparInput(by);
        elemento.sendKeys(text);
    }

    public static void limparInput(By by){
        esperarElemento(by);
        element(by).sendKeys(Keys.chord(Keys.CONTROL,"a"));
        element(by).sendKeys(Keys.DELETE);
    }

    public static void clicar(By by) {
        esperarElemento(by);
        element(by).click();
    }

    public static void selecionarCurriculo() {
        int xCoord = 819;
        int yCoord = 401;

// Crie uma instância de Actions e mova o cursor do mouse para as coordenadas do elemento
        clicar(By.cssSelector("#root > section > section > div > div:nth-child(2) > form > section > div > p"));

// Use a classe Robot para automatizar a seleção e o envio do arquivo
        try {
            Robot robot = new Robot();
            // Aguarde um curto período de tempo para a janela do arquivo abrir
            Thread.sleep(1000);

            // Selecione o arquivo que você deseja enviar
            StringSelection fileSelection = new StringSelection("C:\\Users\\rapha\\projeto-final-api\\chronos-qa-ui\\src\\main\\resources\\curriculo\\CV_padrao_DBC_-_Vem_Ser_QA.docx");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileSelection, null);

            // Pressione Ctrl + V para colar o caminho do arquivo
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // Pressione Enter para confirmar a seleção do arquivo
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(1000);
            clicar(ADICIONAR_CONFIRMAR_MOLDE);
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selecionarImagemEdicao(String path) {
        int xCoord = 670;
        int yCoord = 534;

// Crie uma instância de Actions e mova o cursor do mouse para as coordenadas do elemento
        Actions actions2 = new Actions(driver);
        actions2.moveByOffset(xCoord, yCoord).click().perform();

// Use a classe Robot para automatizar a seleção e o envio do arquivo
        try {
            Robot robot = new Robot();
            // Aguarde um curto período de tempo para a janela do arquivo abrir
            Thread.sleep(500);

            // Selecione o arquivo que você deseja enviar
            StringSelection fileSelection = new StringSelection(path);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileSelection, null);

            // Pressione Ctrl + V para colar o caminho do arquivo
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // Pressione Enter para confirmar a seleção do arquivo
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selecionarImagemTrilha(String path) {
        WebElement element = driver.findElement(By.cssSelector("#root > section > section > div > form > div > div.MuiFormControl-root.MuiTextField-root.css-1rc0004 > div"));
        int xCoord = element.getLocation().getX();
        int yCoord = element.getLocation().getY();
        try {
// Crie uma instância de Actions e mova o cursor do mouse para as coordenadas do elemento
        clicar(By.cssSelector("#root > section > section > div > form > div > div.MuiFormControl-root.MuiTextField-root.css-1rc0004 > div"));

// Use a classe Robot para automatizar a seleção e o envio do arquivo
            Robot robot = new Robot();
            // Aguarde um curto período de tempo para a janela do arquivo abrir
            Thread.sleep(500);

            // Selecione o arquivo que você deseja enviar
            StringSelection fileSelection = new StringSelection(path);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileSelection, null);

            // Pressione Ctrl + V para colar o caminho do arquivo
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // Pressione Enter para confirmar a seleção do arquivo
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clicarEsperandoSerClicavel(By by) {
        esperarElemento(by);
        esperarElementoSerClicavel(by);
        element(by).click();
    }
    public static void clicarCheckbox(By by) {
        esperarElemento(by);
        element(by).click();
    }
    static void scrollarAoElemento(By by) {
        scrollarAteOElemento(by);
    }
    protected static void clearTexto(By by) {
        esperarElemento(by);
        element(by).clear();
    }

    public static String lerTexto(By by) {
        esperarElemento(by);
        return element(by).getText();
    }
    public static String lerTextoVisivel(By by) {
        esperarElementoSerVisivel(by);
        return element(by).getText();
    }

    public static void tab(By by) {
        esperarElemento(by);
        element(by).sendKeys("\t");
    }

    protected static void delayCaptcha(int milisegundos){
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void selecionarData(By by, LocalDate dataASelecionar) {
        String formattedDate = String.format("%02d/%02d/%d", dataASelecionar.getDayOfMonth(), dataASelecionar.getMonthValue(), dataASelecionar.getYear());
        WebElement elemento = element(by);
        elemento.sendKeys(formattedDate);
    }

    public static void irParaUrl(String url) {
        driver.get(url);
    }

    public static void clicarElementoXPATH(String textoDoElemento) {
        By selector = By.xpath("//*[text()='" + textoDoElemento + "']");
        wait.until(ExpectedConditions.presenceOfElementLocated(selector));
        WebElement elemento = driver.findElement(By.xpath("//*[text()='" + textoDoElemento + "']"));
        elemento.click();
    }

    public static void selecionarString(By by, String stringASelecionar) {
        WebElement elemento = element(by);
        elemento.sendKeys(stringASelecionar);
    }


    protected static boolean validator(By by){
        return validarElementoNaTela(by);
    }

    public static void hoverOnElement(By by) {
        hoverNoElemento(by);
    }
}
