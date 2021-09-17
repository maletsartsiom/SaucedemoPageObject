package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AbilityToOpenProductPageTest extends BaseTest {

    @Test
    public void abilityToOpenProductPageTest() {
        //loginPage
        driver.get("https://www.saucedemo.com/");
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        //productsPage
        Assert.assertEquals(productsPage.getHeader(), "PRODUCTS");
        String firstProductNameOnMainPage = productsPage.getTitleOfFirstProduct();
        productsPage.openPageOfFirstProduct();
        //pageOfProduct
        String productNameOnProductPage = pageOfProduct.getTitleOfProduct();
        Assert.assertEquals(firstProductNameOnMainPage, productNameOnProductPage);
    }

}
