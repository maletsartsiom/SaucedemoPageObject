package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndTest extends BaseTest {

    @Test (description = "End to end test", retryAnalyzer = RetryAnalyzer.class)
    public void endToEnd() {
        //loginPage
        loginPage.open();
        loginPage.verifyLoginPageIsOpened();
        loginPage.login("standard_user", "secret_sauce");
        //productsPage
        productsPage.verifyProductsPageIsOpened();
        Assert.assertEquals(productsPage.getHeader(), "PRODUCTS");
        productsPage.addToCartProduct("Sauce Labs Fleece Jacket");
        productsPage.clickOnCartBtn();
        //cartPage
        cartPage.verifyCartPageIsOpened();
        Assert.assertEquals(cartPage.getHeader(), "YOUR CART");
        cartPage.clickOnCheckoutBtn();
        //checkoutPage
        checkoutPage.verifyCheckoutPageIsOpened();
        Assert.assertEquals(checkoutPage.getHeader(), "CHECKOUT: YOUR INFORMATION");
        checkoutPage.checkoutWithData("First", "Last", "123456");
        //overviewPage
        overviewPage.verifyOverviewPageIsOpened();
        Assert.assertEquals(overviewPage.getHeader(), "CHECKOUT: OVERVIEW");
        overviewPage.clickOnFinishBtn();
        //thankYouPage
        thankYouPage.verifyOverviewPageIsOpened();
        Assert.assertEquals(thankYouPage.getHeader(), "CHECKOUT: COMPLETE!");
        thankYouPage.clickOnBackHomeBtn();
        //productsPage
        productsPage.verifyProductsPageIsOpened();
        Assert.assertEquals(productsPage.getHeader(), "PRODUCTS");
    }
}
