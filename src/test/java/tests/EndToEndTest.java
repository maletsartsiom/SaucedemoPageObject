package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndTest extends BaseTest {

    @Test
    public void endToEnd() {
        //loginPage
        driver.get("https://www.saucedemo.com/");
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        //productsPage
        Assert.assertEquals(productsPage.getHeader(), "PRODUCTS");
        productsPage.addToCartProduct("Sauce Labs Fleece Jacket");
        productsPage.clickOnCartBtn();
        //cartPage
        Assert.assertEquals(cartPage.getHeader(), "YOUR CART");
        cartPage.clickOnCheckoutBtn();
        //checkoutPage
        Assert.assertEquals(checkoutPage.getHeader(), "CHECKOUT: YOUR INFORMATION");
        checkoutPage.checkoutWithData("First", "Last", "123456");
        //overviewPage
        Assert.assertEquals(overviewPage.getHeader(), "CHECKOUT: OVERVIEW");
        overviewPage.clickOnFinishBtn();
        //thankYouPage
        Assert.assertEquals(thankYouPage.getHeader(), "CHECKOUT: COMPLETE!");
        thankYouPage.clickOnBackHomeBtn();
        //productsPage
        Assert.assertEquals(productsPage.getHeader(), "PRODUCTS");
    }
}
