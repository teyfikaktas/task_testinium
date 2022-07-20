import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pages.BasketPage;
import pages.HomePage;
import pages.DetailPage;
import pages.ProductsPage;

import java.io.IOException;

public class test_scenerio extends BaseTest {

    HomePage homePage ;
    BasketPage basketPage;

    ProductsPage productsPage ;
    DetailPage detailPage;

    @Test
    @Order(1)
    public void search() throws IOException {
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);

        homePage.search();
        Assertions.assertTrue(productsPage.isProductPage(),
                "not");
    }

    @Test
    @Order(2)

    public void randomSelect() throws InterruptedException {
        detailPage = new DetailPage(driver);
        productsPage.select();
        Assertions.assertTrue(detailPage.isdetailPage(),
                "not");
    }

    @Test
    @Order(3)

    public void addProduct() throws InterruptedException {
        DetailPage detailPage  = new DetailPage(driver);
        detailPage.addCart();
        Assertions.assertTrue(homePage.checkProductAdded(),
                "not");
    }
    @Test
    @Order(4)

    public void clickBasket(){
        homePage.clickBasketOpen();
        Assertions.assertTrue(homePage.isOpen(),
                "not");
    }

    @Test
    @Order(5)

    public void clickGoBasket() throws InterruptedException {
        basketPage = new BasketPage(driver);
        homePage.ClicktoGoBasketPage();
        Assertions.assertTrue(basketPage.isBasketPage(),
                "not");
    }
    @Test
    @Order(6)
    public void addCount() throws InterruptedException {
        basketPage = new BasketPage(driver);
        basketPage.ChangeCount();
        Assertions.assertTrue(basketPage.isChangeCount(),
                "not");
    }
    @Test
    @Order(7)

    public void clickCross() throws InterruptedException {
        basketPage.ClickCross();

        Assertions.assertFalse(homePage.Basket(),
                "not");
    }

}
