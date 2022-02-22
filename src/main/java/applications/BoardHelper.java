package applications;

import models.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends HelperBase{
    public BoardHelper(WebDriver wd) {
        super(wd);
    }
    public void closeBoard() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(By.cssSelector(".js-close-board"));
        click(By.cssSelector(".js-confirm"));
        click(By.cssSelector(".js-delete"));
        click(By.cssSelector(".js-confirm"));
    }

    public void openMore() {
        click(By.cssSelector(".js-open-more"));
    }

    public void openSideBoardMenu() {
        click(By.cssSelector(".js-show-sidebar"));
    }

    public void clickOnTheFirstBoard() {
        click(By.cssSelector(".boards-page-board-section-list-item"));
    }

    public int getBoardsCount() {
        return wd.findElements(By.cssSelector(".boards-page-board-section-list-item")).size() - 1 - recentlyViewedBoardsCount();
    }

    public void fillBoardCreationForm(Board board) {
        //fillBoardCreationForm
        type(By.cssSelector("[data-test-id='create-board-title-input']"), board.getBoardName());
        //confirmBoardCreation
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        waitForElementAndClick(4, By.cssSelector("[data-test-id='create-board-submit-button']"));
    }



    public void initBoardCreationFromHeader() {
        //clickCreateButtonOnHeader
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
        //selectCreateBoard
        click(By.cssSelector("[data-test-id='header-create-board-button']"));//
    }

    public int recentlyViewedBoardsCount(){

        return wd.findElements(By.xpath("//*[contains(@class, 'icon-clock')]/../../..//li")).size();
    }


}
