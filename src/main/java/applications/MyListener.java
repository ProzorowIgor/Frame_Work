package applications;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyListener extends AbstractWebDriverEventListener {

    Logger loger = LoggerFactory.getLogger(MyListener.class);

    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");

    public MyListener() {
        super();
    }

    @Override
    public void beforeAlertAccept(WebDriver driver) {
        super.beforeAlertAccept(driver);
        extent.attachReporter(spark);
        extent.createTest("Before method")
                .log(Status.PASS, "Logout had done");
        extent.flush();
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
        loger.info("Start finding element by ------>" +by);
        extent.attachReporter(spark);
        extent.createTest("Before find by")
                .log(Status.PASS, "Starting to find");
        extent.flush();
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
        if(element!=null && element.isDisplayed()) {
            loger.info("The element -->" + by + "was found");
            extent.attachReporter(spark);
            extent.createTest("After find by")
                    .log(Status.PASS, "Element was found");
            extent.flush();
        }
        else {
            loger.info("The element -->" + by + "wasn't found");
            extent.attachReporter(spark);
            extent.createTest("After find by")
                    .log(Status.FAIL, "Element was't found");
            extent.flush();
        }

    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        super.beforeClickOn(element, driver);
        if(!element.isEnabled()){
            //extent.attachReporter(spark);
            extent.createTest("Before click on")
                    .log(Status.FAIL, "Element is enabled");
           // extent.flush();
        }else {
            extent.createTest("before click on")
                    .log(Status.PASS,"click is allow");

        }
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        super.afterClickOn(element, driver);

       // extent.attachReporter(spark);
        extent.createTest("After click on")
                .log(Status.PASS, "Clicked OK!");
       // extent.flush();
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);
        loger.info("We heave throwable -->" +throwable.getMessage());

        int i = (int) (System.currentTimeMillis()/1000%3600);
        String screenshot = "src/test/screenshots/screen-"+i+".png";
        HelperBase hb = new HelperBase(driver);
        hb.takeScreenShot(screenshot);

    }
}
