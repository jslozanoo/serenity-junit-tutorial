package serenityswag.inventory;

import net.thucydides.core.pages.PageObject;

public class ProductDetailsPageObject extends PageObject {

    public String productName() {
        return $(".inventory_details_name").getText();
    }
}
