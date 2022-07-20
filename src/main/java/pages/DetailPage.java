package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DetailPage extends BasePage{

    By addCartButton = By.id("button-cart");

    public DetailPage(WebDriver webDriver) {
        super(webDriver);
    }

    public  void addCart() throws InterruptedException {
        click(addCartButton);
        Thread.sleep(1000);
    }

    public boolean isdetailPage() {
        return isDisplayed(addCartButton);
    }
}
