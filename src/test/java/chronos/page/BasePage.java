package chronos.page;

import chronos.data.factory.seleniumfactory.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;

public class BasePage extends Elements {

    public static void preencherInput(By by, String text) {
        esperarElemento(by);
        WebElement elemento = element(by);
        elemento.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        elemento.sendKeys(Keys.DELETE);
        limparInput(by);
        elemento.sendKeys(text);
    }

    public static void clicar(By by) {
        esperarElemento(by);
        element(by).click();
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
