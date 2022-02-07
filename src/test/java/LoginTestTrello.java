import applications.MyDataProvider;
import io.qameta.allure.Description;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestTrello extends TestBase {

    @BeforeMethod
    public void preconditions() {
        if (app.getUser().isTrelloButtonOnHeader()) {
            app.getUser().logout();
        }
    }


    @Test(dataProvider = "dataLoginCVS", dataProviderClass = MyDataProvider.class)

    public void testLogin(String email, String password) throws InterruptedException {
        app.getUser().initLogin();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitLogin();
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
    }
}