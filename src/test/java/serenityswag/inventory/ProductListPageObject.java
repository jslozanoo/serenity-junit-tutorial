package serenityswag.inventory;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import java.util.List;

public class ProductListPageObject extends PageObject {

    public List<String> titles(){
        return findAll(By.className("inventory_item_name")).textContents();
    }

    public void openProductDetailsFor(String firstItemName) {
        find(By.partialLinkText(firstItemName)).click();
    }
}
