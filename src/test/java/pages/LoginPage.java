package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {

    private static final By USERNAME = By.id("user-name");
    private static final By PASSWORD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    @Step("Login using credentials: '{userName}' and '{password}'")
    public void login(String user, String password) {
        driver.findElement(USERNAME).sendKeys(user);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getLoginBtnName() {
        return driver.findElement(LOGIN_BUTTON).getAttribute("value");
    }

    public void verifyLoginPageIsOpened() {
        Assert.assertTrue(super.isVisible(LOGIN_BUTTON));
    }
}
