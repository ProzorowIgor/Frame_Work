import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ParallelClass {
    WebDriver wd;

    @Test
    public void test1(){
        wd = new ChromeDriver();
        wd.navigate().to("https://www.google.com/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("1===========" +Thread.currentThread().getId());


    }

    @Test//(threadPoolSize = 3, invocationCount = 10,  invocationTimeOut = 10000)
    public void test2(){
       /* System.setProperty("webdriver.gecko.driver", "C:\\Java-Training\\Selenium\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        File pathToFirefoxBinary = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        FirefoxBinary ffBinary = new FirefoxBinary(pathToFirefoxBinary);
        options.setBinary(ffBinary);
        browser = new FirefoxDriver(options);*/

        System.setProperty("webdriver.edge.driver","C:\\TOOLS\\msedgedriver.exe");
       // wd = new FirefoxDriver();
        //wd = new EdgeDriver();
       wd = new EventFiringWebDriver(new FirefoxDriver());
        wd.navigate().to("https://www.google.com/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("2===========" +Thread.currentThread().getId());
    }

   /* @AfterMethod
    public void postCondition(){
        wd.quit();
    }*/
}
