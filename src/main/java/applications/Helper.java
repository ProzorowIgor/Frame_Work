package applications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Helper extends HelperBase{

    public Helper(WebDriver wd) {
        super(wd);
    }


    public boolean isLogoutPresent() {
        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

}
