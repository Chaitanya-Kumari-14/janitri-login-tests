package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By userId = By.id("user-id");
    By password = By.id("password");
    By loginBtn = By.xpath("//button[text()='Login']");
    By eyeIcon = By.cssSelector("svg[data-testid='VisibilityIcon']");
    By errorMsg = By.cssSelector("p.Mui-error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserId(String uid) {
        driver.findElement(userId).sendKeys(uid);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public boolean isLoginButtonEnabled() {
        return driver.findElement(loginBtn).isEnabled();
    }

    public boolean isPasswordMasked() {
        return driver.findElement(password).getAttribute("type").equals("password");
    }

    public void togglePasswordVisibility() {
        driver.findElement(eyeIcon).click();
    }

    public String getErrorMsg() {
        return driver.findElement(errorMsg).getText();
    }

    public boolean isElementVisible(By locator) {
        return driver.findElement(locator).isDisplayed();
    }
}
