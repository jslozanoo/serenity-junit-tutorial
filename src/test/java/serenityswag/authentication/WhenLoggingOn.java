package serenityswag.authentication;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenLoggingOn {

    @Managed
    WebDriver driver;

    @Test
    public void usersCanLogOnViaTheHomePage() {
        driver.get("https://www.saucedemo.com/");

        // Login as a standard user
        driver.findElement(By.cssSelector("[data-test='username']")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("[data-test='password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();

        // Should see product catalog
        Assertions.assertThat(driver.findElement(By.cssSelector(".title")).getText())
                .isEqualToIgnoringCase("Products");
    }
}
