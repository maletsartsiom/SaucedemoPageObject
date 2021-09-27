package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AbilityToAddRemoveProductFromProductPage extends BaseTest {

    @Test (description = "Ability to add and remove product from product page", retryAnalyzer = RetryAnalyzer.class)
    public void abilityToAddRemoveProductFromProductPage() {
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
        pageOfProduct.addProductToCart();
        pageOfProduct.clickOnCartBtnIcon();
        //cartPage
        cartPage.verifyCartPageIsOpened();
        Assert.assertEquals(productNameOnProductPage, cartPage.getProductTitle());
        driver.navigate().back();
        //productPage
        productsPage.verifyProductsPageIsOpened();
        pageOfProduct.removeButton();
        pageOfProduct.clickOnCartBtnIcon();
        //cartPage
        cartPage.verifyCartPageIsOpened();
        Assert.assertEquals(0, cartPage.getNumberOfProductsInCart());
    }
}
