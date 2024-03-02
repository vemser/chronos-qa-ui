package chronos.test;


import chronos.data.factory.seleniumfactory.SeleniumService;
import org.junit.After;
import org.junit.Before;

public class BaseTest {
    SeleniumService seleniumFactory = new SeleniumService();

    @Before
    public void abrirNavegador() {
        seleniumFactory.initBrowser("https://chronos-front-one.vercel.app");
    }

    @After
    public void fecharNavegador() {
        seleniumFactory.tearDown();
    }
}
