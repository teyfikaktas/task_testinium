package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductsPage extends BasePage {

    By xbtn = By.xpath("//*[@id='content']/div[3]/div[3]/div/a[1]");
    By groupElements = By.className("pr-img-link");
    //*[@id="product-600965"]
    public ProductsPage(WebDriver webDriver) {
        super(webDriver);
    }



    public boolean isProductPage() {
        return isDisplayed(xbtn);
    }
    private List<WebElement> getAllbooks(){
        return finds(groupElements);
    }
    public void select () throws InterruptedException {
        Random r=new Random();
        int count=r.nextInt(19);
        Thread.sleep(1000);
        getAllbooks().get(count).click();
        Thread.sleep(1000);

    }
}
