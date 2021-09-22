package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AbilityToSortProductsByPriceLowToHighTest extends BaseTest {

    @Test
    public void AbilityToSortProductsByPriceLowToHigh() {
        //loginPage
        loginPage.open();
        loginPage.verifyLoginPageIsOpened();
        loginPage.login("standard_user", "secret_sauce");
        //productsPage
        productsPage.verifyProductsPageIsOpened();
        Assert.assertEquals(productsPage.getHeader(), "PRODUCTS");
        List<WebElement> productPricesBefore = productsPage.getAllProductPrices();
        productsPage.sortProductBy("Price (low to high)");
        List<WebElement> productPricesAfter = productsPage.getAllProductPrices();
        Assert.assertNotEquals(productPricesBefore, productPricesAfter);
    }
}
