package chronos.test;


import chronos.data.factory.seleniumfactory.SeleniumService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    SeleniumService seleniumFactory = new SeleniumService();

    @BeforeEach
    public void abrirNavegador() {
        seleniumFactory.initBrowser("https://chronos-front-one.vercel.app");
    }

    @AfterEach
    public void fecharNavegador() {
        seleniumFactory.tearDown();
    }
}
