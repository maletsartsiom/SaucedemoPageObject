package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AbilityToLogOut extends BaseTest {

    @Test
    public void abilityToLogOut() {
        //loginPage
        driver.get("https://www.saucedemo.com/");
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        //productsPage
        Assert.assertEquals(productsPage.getHeader(), "PRODUCTS");
        productsPage.logOut();
        //logInPage
        Assert.assertEquals("Login", loginPage.getLoginBtnName());
    }
}
