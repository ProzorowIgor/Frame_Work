package applications;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    EventFiringWebDriver wd;
    String browser;
    Properties properties;
    Helper helper;
    UserHelper user;
    BoardHelper board;


    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {

        String target = System.getProperty("target", "data");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        if (browser.equals(BrowserType.CHROME)) {
            wd = new EventFiringWebDriver(new ChromeDriver());
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new EventFiringWebDriver(new FirefoxDriver());
        }
        wd.register(new MyListener());

        wd.navigate().to("https://trello.com/");
        // wd.navigate().to(properties.getProperty("web.Base"));
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        helper = new Helper(wd);
        user = new UserHelper(wd);
        board = new BoardHelper(wd);
    }

    public void stop() {

        wd.quit();
    }

    public String getEmail() {
        return properties.getProperty("web.email");
    }

    public String getPassword() {
        return properties.getProperty("web.password");
    }

    public Helper getHelper() {
        return helper;
    }

    public UserHelper getUser() {
        return user;
    }

    public BoardHelper board() {
        return board;
    }
}