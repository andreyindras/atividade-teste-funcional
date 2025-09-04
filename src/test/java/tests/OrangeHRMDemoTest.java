package tests;

import utils.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class OrangeHRMDemoTest extends BaseTest {

    @Test
    public void loginValido() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Assertions.assertTrue(driver.getCurrentUrl().contains("/dashboard"));
    }

    @Test
    public void loginInvalido() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.name("username")).sendKeys("userincorrect");
        driver.findElement(By.name("password")).sendKeys("passwordincorrect");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String errorMsg = driver.findElement(By.cssSelector(".oxd-alert-content-text")).getText();
        Assertions.assertTrue(errorMsg.contains("Invalid credentials"));
    }
}