package chronos.data.factory.seleniumfactory;


import chronos.utils.ConfigProperties;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.interactions.Actions;

public class SeleniumService {


    public static WebDriver driver;
    public static WebDriverWait wait;

    public static Actions actions;


    // inicia o browser
    public void initBrowser(String url) {


        ConfigProperties.initializePropertyFile();


        switch (ConfigProperties.properties.getProperty("BrowserType")) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--allow-running-insecure-content");
                chromeOptions.addArguments("--ignore-certificate-errors");

                driver = new ChromeDriver(chromeOptions);
                wait = new WebDriverWait(driver, Duration.ofSeconds(40));

                driver.get(ConfigProperties.properties.getProperty("AppURL"));
                driver.manage().window().maximize();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                wait = new WebDriverWait(driver, Duration.ofSeconds(40));
                driver.get(ConfigProperties.properties.getProperty("AppURL"));
                driver.manage().window().maximize();
                break;
            case "edge":
                driver = new EdgeDriver();
                wait = new WebDriverWait(driver, Duration.ofSeconds(40));
                driver.get(ConfigProperties.properties.getProperty("AppURL"));
                driver.manage().window().maximize();
                break;
            default:
                driver = new ChromeDriver();
                wait = new WebDriverWait(driver, Duration.ofSeconds(40));
                driver.get(ConfigProperties.properties.getProperty("AppURL"));
                driver.manage().window().maximize();
                break;
        }
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}