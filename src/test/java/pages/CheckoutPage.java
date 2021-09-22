package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private static final By CHECKOUT_PAGE_TITLE = By.cssSelector("[class=title]");
    private static final By FIRST_NAME = By.id("first-name");
    private static final By LAST_NAME = By.id("last-name");
    private static final By ZIP_CODE = By.id("postal-code");
    private static final By CONTINUE_BUTTON = By.id("continue");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public String getHeader() {
        return driver.findElement(CHECKOUT_PAGE_TITLE).getText();
    }

    public void checkoutWithData(String firstName, String lastName, String zipCode) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(ZIP_CODE).sendKeys(zipCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void verifyCheckoutPageIsOpened() {
        super.isVisible(CHECKOUT_PAGE_TITLE);
    }
}
