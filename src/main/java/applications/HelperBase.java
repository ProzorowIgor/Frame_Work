package applications;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {

        this.wd = wd;
    }

    public void click(By locator) {
        wd.findElement(locator).click();

    }

    public void type(By locator, String text) {
        if (text != null) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public boolean isElementPresent(By locator) {
//new WebDriverWait(wd,10).until(ExpectedConditions.elementToBeClickable(locator));
        return wd.findElements(locator).size() > 0;
    }

    public void pause(int millise) {
        try {
            Thread.sleep(millise);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void takeScreenShot(String pathToFile) {
        File temp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);

        File screenshot = new File(pathToFile);
        try {
            Files.copy(temp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isHomeButtonOnHeader() {
        return isElementPresent(By.cssSelector("[data-test-id='header-home-button']"));
    }

    public boolean isTrelloButtonOnHeader() {
      /*  try{
            return isElementPresent(By.cssSelector("[aria-label='Back to home']"));
        } catch (Exception ex){
            return false;
        }*/
       return isElementPresent(By.cssSelector("a[aria-label='Back to home']"));
    }

    public void retunToHomePage() {
        if (isTrelloButtonOnHeader()) {
            click(By.cssSelector("[aria-label='Back to home']"));
        } else
            click(By.cssSelector("[data-test-id='header-home-button']"));
    }

    public void waitForElementAndClick(int timeOut, By locator) {
        new WebDriverWait(wd, timeOut/*Duration.ofSeconds(timeOut)*/)
                .until(ExpectedConditions.elementToBeClickable(locator))
                .click();
    }
}