package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class BasePage {

    WebDriver driver ;

    public BasePage(WebDriver driver){
        this.driver = driver ;
    }

    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> finds(By locator){
        return driver.findElements(locator);
    }

    public void click(By locator){
        find(locator).click();
    }

    public void setText(By locator , String text){
        find(locator).sendKeys(text);
    }

    public Boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }
    public String CSVReader(String path){
        String output="";
        File file = new File(path);
        try{
            Scanner inpScanner = new Scanner(file);
            while (inpScanner.hasNext()){
                String data = inpScanner.next();
                output = data;
            }
            inpScanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return output;
    }
}
