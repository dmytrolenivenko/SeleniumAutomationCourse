package com.omni.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.omni.PageObjects.CatalogPage;
import com.omni.PageObjects.CheckOutPage;
import com.omni.PageObjects.ConfirmationPage;
import com.omni.PageObjects.ShoppingCart;

public class PurchaiseVariousProducts extends BaseTest {

    String email = "awdawdawdawddawd@gmail.com";
    String password = "QWERTY123#qwerty";
    String productName = "ZARA COAT 3";
    String country = "Por";
    String heroMessage = "Thankyou for the order.";

 @Test(dataProvider = "getDataString", groups = {"string data"})
    public void submitOrderWithStrings(String email, String password, String productName, String country, String heroMessage) {

        landingPage = launchApplication();
        CatalogPage catalogPage = landingPage.login(email, password);
        ShoppingCart shoppingCart = new ShoppingCart(driver);
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);

        catalogPage.getProductList();
        catalogPage.addToCart(productName);
        shoppingCart.goToCart();
        Assert.assertTrue(shoppingCart.cartVerifyProducts(productName));
        shoppingCart.checkOutButtonClick();
        checkOutPage.checkOut(country);
        checkOutPage.placeOrderClick();
        Assert.assertEquals(confirmationPage.getHeroMessage().toLowerCase(), heroMessage.toLowerCase());
    }

    @DataProvider(name = "getDataString")
    public Object[][] getDataString() {
        Object[][] data = {
            {"awdawdawdawddawd@gmail.com", "QWERTY123#qwerty", "ZARA COAT 3", "Por", "Thankyou for the order."},
            {"awdawdawdawddawd@gmail.com", "QWERTY123#qwerty", "ADIDAS ORIGINAL", "Uru", "Thankyou for the order."},
            {"awdawdawdawddawd@gmail.com", "QWERTY123#qwerty", "IPHONE 13 PRO", "Aus", "Thankyou for the order."}
        };
        return data;
    } 
}

   /*  @Test(dataProvider = "getDataMap", groups = {"hash data"})
    public void submitOrderWithHashMap(HashMap<String, String> input) {

        landingPage = launchApplication();
        CatalogPage catalogPage = landingPage.login(input.get("email"), input.get("password"));
        ShoppingCart shoppingCart = new ShoppingCart(driver);
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);

        catalogPage.getProductList();
        catalogPage.addToCart(input.get("productName"));
        shoppingCart.goToCart();
        Assert.assertTrue(shoppingCart.cartVerifyProducts(input.get("productName")));
        shoppingCart.checkOutButtonClick();
        checkOutPage.checkOut(input.get("country"));
        checkOutPage.placeOrderClick();
        Assert.assertEquals(confirmationPage.getHeroMessage().toLowerCase(), input.get("heroMessage").toLowerCase());

    } */

    /* @DataProvider(name = "getDataMap")
    public Object[][] getDataMap() {
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("email", "awdawdawdawddawd@gmail.com");
        map1.put("password", "QWERTY123#qwerty");
        map1.put("productName", "ZARA COAT 3");
        map1.put("country", "Por");
        map1.put("heroMessage", "Thankyou for the order.");

        HashMap<String, String> map2 = new HashMap<>();
        map2.put("email", "awdawdawdawddawd@gmail.com");
        map2.put("password", "QWERTY123#qwerty");
        map2.put("productName", "ADIDAS ORIGINAL");
        map2.put("country", "Uru");
        map2.put("heroMessage", "Thankyou for the order.");

        HashMap<String, String> map3 = new HashMap<>();
        map3.put("email", "awdawdawdawddawd@gmail.com");
        map3.put("password", "QWERTY123#qwerty");
        map3.put("productName", "IPHONE 13 PRO");
        map3.put("country", "Aus");
        map3.put("heroMessage", "Thankyou for the order.");

        return new Object[][]{{map1}, {map2}, {map3}};
    } */

     