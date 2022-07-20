package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage {
    By cartModule = By.xpath( "//*[@id=\"content\"]/div[1]/a[2]");
    By min = By.xpath(     "//*[@id='cart_module']/div[1]");

    By cartCount = By.xpath("//*[@id='cart_module']/div[1]/table/tbody/tr/td[4]/form/input[1]");

    By refreshButton = By.xpath("//*[@id='cart_module']/div[1]/table/tbody/tr/td[4]/form/i");

    By crossButton = By.xpath("//*[@id=\"cart_module\"]/div[1]/table/tbody/tr/td[8]/a/i");




    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public boolean isBasketPage() {
        return isDisplayed(cartModule);
    }

    public void ChangeCount() throws InterruptedException {
if(!isDisplayed(min)){
    Thread.sleep(1000);
    find(cartCount).clear();
    Thread.sleep(1000);

    setText(cartCount,"2");
}


    }

    public boolean isChangeCount() throws InterruptedException {

        if(!isDisplayed(min)){
            click(refreshButton);
            Thread.sleep(1000);

            String module = find(cartCount).getText();
            Thread.sleep(1000);

            return !module.equals("1");
        }
      else
          return false;
    }

    public void ClickCross() throws InterruptedException {
       if(!isDisplayed(min)){
           Thread.sleep(1000);
           click(crossButton);
       }

    }

}
