package serenityswag.authentication.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import serenityswag.authentication.User;

public class  LoginActions extends UIInteractionSteps {

    @Step("Log in as {0}")
    public void as(User user){
        openUrl("https://www.saucedemo.com/");

        // Login as a standard user

        $("[data-test='username']").sendKeys(user.getUsername());
        $("[data-test='password']").sendKeys(user.getPassword());
        $("[data-test='login-button']").click();
    }
    private void findById(User user){
        $("#user-name").sendKeys(user.getUsername());
        // find(By.id("user-name")).sendKeys(user.getUsername());
        $("#password").sendKeys(user.getPassword());
        // find(By.id("password")).sendKeys(user.getPassword());
        $("#login-button").click();
        // find(By.id("login-button")).click();
    }

    private void findByName(User user){
        find(By.name("user-name")).sendKeys(user.getUsername());
        find(By.name("password")).sendKeys(user.getPassword());
        find(By.name("login-button")).click();
    }
}
