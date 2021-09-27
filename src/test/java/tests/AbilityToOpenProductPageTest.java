package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AbilityToOpenProductPageTest extends BaseTest {

    @Test (description = "Ability to open product page test", retryAnalyzer = RetryAnalyzer.class)
    public void abilityToOpenProductPageTest() {
        //loginPage
        loginPage.open();
        loginPage.verifyLoginPageIsOpened();
        loginPage.login("standard_user", "secret_sauce");
        //productsPage
        productsPage.verifyProductsPageIsOpened();
        Assert.assertEquals(productsPage.getHeader(), "PRODUCTS");
        String firstProductNameOnMainPage = productsPage.getTitleOfFirstProduct();
        productsPage.openPageOfFirstProduct();
        //pageOfProduct
        pageOfProduct.verifyPageOfProductIsOpened();
        String productNameOnProductPage = pageOfProduct.getTitleOfProduct();
        Assert.assertEquals(firstProductNameOnMainPage, productNameOnProductPage);
    }

}
