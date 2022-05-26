package serenityswag.inventory;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.User;
import serenityswag.authentication.actions.LoginActions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenViewingProducts extends UIInteractionSteps {

    @Managed
    WebDriver driver;

    @Steps
    LoginActions login;

    ProductListPageObject productList;

    ProductDetailsPageObject productDetails;

    @Test
    public void shouldDisplayProductsOnTheWelcomePage(){
        login.as(User.STANDARD_USER);

        List<String> productsOnDisplay = productList.titles();

        assertThat(productsOnDisplay).hasSize(6).contains("Sauce Labs Backpack");
    }

    @Test
    public void shouldDisplayCorrectProductDetailsPage(){
        login.as(User.STANDARD_USER);

        String firstItemName = productList.titles().get(0);
        productList.openProductDetailsFor(firstItemName);

        assertThat(productDetails.productName()).isEqualTo(firstItemName);
    }
}
