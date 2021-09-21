package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private static final By CART_PAGE_TITLE = By.cssSelector("[class=title]");
    private static final By CHECKOUT_BUTTON = By.id("checkout");
    private static final By PRODUCT_TITLE = By.xpath("//div[@class='inventory_item_name']");
    private static final By ALL_PRODUCTS_IN_CART = By.xpath("//div[contains(text(), 'Sauce Labs Backpack')]");

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

    public String  getProductTitle() {
        return driver.findElement(PRODUCT_TITLE).getText();
    }

    public int getNumberOfProductsInCart() {
        return driver.findElements(ALL_PRODUCTS_IN_CART).size();
    }

    public void verifyCartPageIsOpened() {
        super.isVisible(CART_PAGE_TITLE);
    }
}