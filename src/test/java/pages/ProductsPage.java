package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage extends BasePage {

    private static final By PRODUCTS_PAGE_TITLE = By.cssSelector(".title");
    String productLocator = "//*[contains(text(), '%s')]/ancestor::*[contains(@class, 'inventory_item')]//button";
    private static final By CART_BUTTON = By.cssSelector(".shopping_cart_link");
    private static final By PRODUCT_PRICES_BEFORE = By.cssSelector(".inventory_item_price");
    private static final By DROPDOWN_MENU = By.cssSelector(".product_sort_container");

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

    public List<WebElement> getAllProductPrices() {
        return driver.findElements(PRODUCT_PRICES_BEFORE);
    }

    public void sortProductBy(String value) {
        Select dropdown = new Select(driver.findElement(DROPDOWN_MENU));
        dropdown.selectByVisibleText(value);
    }
}