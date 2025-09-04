package tests;

import utils.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class TheInternetTest extends BaseTest {

    @Test
    public void loginValido() {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String secureAreaTitle = driver.findElement(By.tagName("h2")).getText();
        Assertions.assertTrue(secureAreaTitle.contains("Secure Area"));
    }

    @Test
    public void loginInvalido() {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("userincorrect");
        driver.findElement(By.id("password")).sendKeys("passwordincorrect");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String errorMsg = driver.findElement(By.id("flash")).getText();
        Assertions.assertTrue(errorMsg.contains("Your username is invalid!"));
    }
}
