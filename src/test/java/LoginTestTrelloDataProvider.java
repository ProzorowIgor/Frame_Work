import applications.MyDataProvider;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestTrelloDataProvider extends TestBase {

  /*  ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");*/

    @BeforeMethod @Description("Configure something")
    public void preconditions() {
        if (app.getUser().isTrelloButtonOnHeader()) {
            app.getUser().logout();
          /*  extent.attachReporter(spark);
            extent.createTest("Before method")
                    .log(Status.PASS, "Logout had done");
            extent.flush();*/
        }
    }


    @Test(dataProvider = "dataLoginCVS", dataProviderClass = MyDataProvider.class)
    @Description("for allure")
    public void testLogin(String email, String password) throws InterruptedException {
        app.getUser().initLogin();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitLogin();
     /*   extent.attachReporter(spark);
        extent.createTest("Login test")
                .log(Status.PASS, "Possitive");
        extent.flush();*/
    /*   Thread.sleep(15000);
        Assert.assertTrue(app.getUser().isTrelloButtonOnHeader(), "Element 'Logo' not found");*/

    }
    @AfterMethod
    public void postConditions() throws InterruptedException {
        Thread.sleep(15000);
        try {
           Assert.assertTrue(app.getUser().isTrelloButtonOnHeader());
        } catch (AssertionError assertionError) {
            System.out.println("Element 'Logo' not found");
            System.out.println(assertionError.getMessage());
        }
       /* extent.attachReporter(spark);
        extent.createTest("After method")
                .log(Status.PASS, "Assertion is pass");
        extent.flush();*/
    }
}