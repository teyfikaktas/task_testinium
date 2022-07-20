package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.*;
import java.util.Scanner;


public class HomePage extends BasePage {

    String path ="src\\sample.csv";

    By cartItem = By.id("cart-items");
    By cart = By.id("cart");
    By toCart = By.id("js-cart");

    By sbLocate= By.id("search-input");
    By button = By.xpath("//*[@id='search']/span");
    By empty = By.xpath("//*[@id=\"cart_module\"]/div[4]/div[1]/a");



    public HomePage(WebDriver webDriver) {
        super(webDriver);

    }

    public boolean checkProductAdded() throws InterruptedException {
        String count = find(cartItem).getText();
        Thread.sleep(1000);
        return !count.equals("0");
    }
    public boolean Basket() throws InterruptedException {
        String count = find(cartItem).getText();
        Thread.sleep(1000);
        return count.equals("Sepetiniz Boş");
    }
    public void clickBasketOpen() {
        click(cart);
    }

    public boolean isOpen() {
        String value = find(cart).getAttribute("class");
        return value.equals("active");
    }

    public void ClicktoGoBasketPage() throws InterruptedException {
       Thread.sleep(1000);
        click(toCart);
    }

    public void search() throws IOException {

        setText(sbLocate,CSVReader(path));
        find(sbLocate).sendKeys(Keys.ENTER);

    }
}
