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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.io.IOException;


public class TestBase {

    protected static ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    Logger logger = LoggerFactory.getLogger(TestBase.class);
    @BeforeSuite(alwaysRun = true)
    public void setUp() throws IOException {
        app.init();

    }

    @AfterSuite
    public void tearDown() {
        app.stop();

    }

}
