package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageOfProduct extends BasePage {

    private static final By TITLE_OF_PRODUCT = By.xpath("//div[@class='inventory_details_name large_size']");
    private static final By ADD_TO_CART = By.id("add-to-cart-sauce-labs-backpack");
    private static final By REMOVE_BUTTON = By.id("remove-sauce-labs-backpack");
    private static final By CART_BUTTON_ICON = By.id("shopping_cart_container");

    public PageOfProduct(WebDriver driver) {
        super(driver);
    }

    public String getTitleOfProduct() {
        return driver.findElement(TITLE_OF_PRODUCT).getText();
    }

    public void addProductToCart() {
        driver.findElement(ADD_TO_CART).click();
    }

    public void removeButton() {
        driver.findElement(REMOVE_BUTTON).click();
    }

    public void clickOnCartBtnIcon() {
        driver.findElement(CART_BUTTON_ICON).click();
    }
}
