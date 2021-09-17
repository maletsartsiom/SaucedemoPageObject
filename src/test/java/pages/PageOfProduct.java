package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageOfProduct extends BasePage {

    private static final By TITLE_OF_PRODUCT = By.xpath("//div[@class='inventory_details_name large_size']");

    public PageOfProduct(WebDriver driver) {
        super(driver);
    }

    public String getTitleOfProduct() {
        return driver.findElement(TITLE_OF_PRODUCT).getText();
    }
}
