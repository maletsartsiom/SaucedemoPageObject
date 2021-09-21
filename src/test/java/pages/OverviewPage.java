package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage extends BasePage {

    private static final By OVERVIEW_PAGE_TITLE = By.cssSelector("[class=title]");
    private static final By FINISH_BUTTON = By.id("finish");

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public String getHeader() {
        return driver.findElement(OVERVIEW_PAGE_TITLE).getText();
    }

    public void clickOnFinishBtn() {
        driver.findElement(FINISH_BUTTON).click();
    }

    public void verifyOverviewPageIsOpened() {
        super.isVisible(OVERVIEW_PAGE_TITLE);
    }
}
