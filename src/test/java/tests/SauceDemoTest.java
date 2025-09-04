package tests;

import utils.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class SauceDemoTest extends BaseTest {

    @Test
    public void loginValido() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Assertions.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }

    @Test
    public void loginInvalido() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("userincorrect");
        driver.findElement(By.id("password")).sendKeys("passwordincorrect");
        driver.findElement(By.id("login-button")).click();

        String errorMsg = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        Assertions.assertTrue(errorMsg.contains("Username and password do not match"));
    }
}
