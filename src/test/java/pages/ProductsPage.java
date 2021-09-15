package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private static final By PRODUCTS_PAGE_TITLE = By.cssSelector(".title");
    String productLocator = "//*[contains(text(), '%s')]/ancestor::*[contains(@class, 'inventory_item')]//button";
    private static final By CART_BUTTON = By.cssSelector(".shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/inventory.html");
    }

    public String getHeader() {
        return driver.findElement(PRODUCTS_PAGE_TITLE).getText();
    }

    public void addToCartProduct(String product) {
        driver.findElement(By.xpath(String.format(productLocator, product))).click();
    }

    public void clickOnCartBtn() {
        driver.findElement(CART_BUTTON).click();
    }
}