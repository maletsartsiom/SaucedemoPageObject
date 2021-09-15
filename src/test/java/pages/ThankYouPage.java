package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThankYouPage extends BasePage {

    private static final By THANK_YOU_PAGE_TITLE = By.cssSelector(".title");
    private static final By BACK_HOME_BUTTON = By.id("back-to-products");

    public ThankYouPage(WebDriver driver) {
        super(driver);
    }

    public String getHeader() {
        return driver.findElement(THANK_YOU_PAGE_TITLE).getText();
    }

    public void clickOnBackHomeBtn() {
        driver.findElement(BACK_HOME_BUTTON).click();
    }
}
