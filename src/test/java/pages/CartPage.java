package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private static final By CART_PAGE_TITLE = By.cssSelector("[class=title]");
    private static final By CHECKOUT_BUTTON = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/cart.html");
    }

    public String getHeader() {
        return driver.findElement(CART_PAGE_TITLE).getText();
    }

    public void clickOnCheckoutBtn() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}