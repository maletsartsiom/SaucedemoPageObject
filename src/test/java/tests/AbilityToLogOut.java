package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AbilityToLogOut extends BaseTest {

    @Test
    public void abilityToLogOut() {
        //loginPage
        loginPage.open();
        loginPage.verifyLoginPageIsOpened();
        loginPage.login("standard_user", "secret_sauce");
        //productsPage
        productsPage.verifyProductsPageIsOpened();
        Assert.assertEquals(productsPage.getHeader(), "PRODUCTS");
        productsPage.logOut();
        //logInPage
        loginPage.verifyLoginPageIsOpened();
        Assert.assertEquals("Login", loginPage.getLoginBtnName());
    }
}
