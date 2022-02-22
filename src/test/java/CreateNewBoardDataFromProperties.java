import models.Board;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewBoardDataFromProperties extends TestBase{


    @BeforeMethod

    public void preconditions() throws InterruptedException {
        if (!app.getUser().isTrelloButtonOnHeader()) {
            app.getUser().initLogin();
            //Credentials from file data.properties by getting them from applicatoin manager
            //If i want to run them from another file, in cmd i invoke comand -Ptarget=name of file
            app.getUser().fillLoginForm(app.getEmail(), app.getPassword());
            app.getUser().submitLogin();
            Thread.sleep(15000);
            Assert.assertTrue(app.getUser().isTrelloButtonOnHeader());

               }
    }


    @Test//(dependsOnMethods = "testLogin")
    public void testBoardCtreation() throws InterruptedException {
        int numberForNewBoard = (int) ((System.currentTimeMillis()/1000)&3600);
        int boardsCountBeforeCreation = app.board().getBoardsCount();
        System.out.println(boardsCountBeforeCreation);

        app.board().initBoardCreationFromHeader();

        app.board().fillBoardCreationForm(new Board().withName("test-board"+numberForNewBoard));

        Thread.sleep(15000);
        app.board().retunToHomePage();
        int boardsCountAfterCreation = app.board().getBoardsCount();
        System.out.println(boardsCountAfterCreation);

        Assert.assertEquals(boardsCountAfterCreation, boardsCountBeforeCreation + 1);
    }

}
