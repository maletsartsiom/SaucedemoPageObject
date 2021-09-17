package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AbilityToAddRemoveProductFromProductPage extends BaseTest {

    @Test
    public void abilityToAddRemoveProductFromProductPage() {
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
        pageOfProduct.addProductToCart();
        pageOfProduct.clickOnCartBtnIcon();
        //cartPage
        Assert.assertEquals(productNameOnProductPage, cartPage.getProductTitle());
        driver.navigate().back();
        //productPage
        pageOfProduct.removeButton();
        pageOfProduct.clickOnCartBtnIcon();
        //cartPage
        Assert.assertEquals(0, cartPage.getNumberOfProductsInCart());
    }
}
