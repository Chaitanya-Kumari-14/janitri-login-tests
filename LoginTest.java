package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.*;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginButtonDisabledWhenFieldsEmpty() {
        LoginPage login = new LoginPage(driver);
        assertFalse(login.isLoginButtonEnabled(), "Login button should be disabled");
    }

    @Test
    public void testPasswordMaskedByDefault() {
        LoginPage login = new LoginPage(driver);
        assertTrue(login.isPasswordMasked(), "Password should be masked");
    }

    @Test
    public void testInvalidLoginShowsError() {
        LoginPage login = new LoginPage(driver);
        login.enterUserId("test@invalid.com");
        login.enterPassword("wrongpass");
        login.clickLogin();
        assertTrue(login.getErrorMsg().toLowerCase().contains("invalid"), "Should show error");
    }

    @Test
    public void testPasswordToggleEyeIcon() {
        LoginPage login = new LoginPage(driver);
        login.enterPassword("test123");
        login.togglePasswordVisibility();
        assertFalse(login.isPasswordMasked(), "Password should be visible");
    }

    @Test
    public void testAllLoginPageElementsVisible() {
        LoginPage login = new LoginPage(driver);
        assertTrue(login.isElementVisible(By.id("user-id")));
        assertTrue(login.isElementVisible(By.id("password")));
        assertTrue(login.isElementVisible(By.xpath("//button[text()='Login']")));
        assertTrue(login.isElementVisible(By.cssSelector("svg[data-testid='VisibilityIcon']")));
    }
}
