package tests;

import utils.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class PracticeTestAutomationTest extends BaseTest {

    @Test
    public void loginValido() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();

        String successMsg = driver.findElement(By.className("post-title")).getText();
        Assertions.assertTrue(successMsg.contains("Logged In Successfully"));
    }

    @Test
    public void loginInvalido() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(By.id("username")).sendKeys("userincorrect");
        driver.findElement(By.id("password")).sendKeys("passwordincorrect");
        driver.findElement(By.id("submit")).click();

        String errorMsg = driver.findElement(By.id("error")).getText();
        Assertions.assertTrue(errorMsg.contains("Your username is invalid!"));
    }
}
