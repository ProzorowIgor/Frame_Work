/*import applications.ApplicationManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;*/
import applications.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.io.IOException;
import java.lang.reflect.Method;


public class TestBase {

    protected static ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startLogger(Method m){
                logger.info("Start method  " + m.getName());
    }

    @AfterMethod
    public void endLogger(Method m){
        logger.info("End of test  " + m.getName());
    }


    @BeforeSuite(alwaysRun = true)
    public void setUp() throws IOException {
        app.init();

    }

 /*   @AfterSuite
    public void tearDown() {
        app.stop();

    }*/

}
