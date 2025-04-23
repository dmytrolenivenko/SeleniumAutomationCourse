package com.omni.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.omni.PageObjects.CatalogPage;
import com.omni.PageObjects.CheckOutPage;
import com.omni.PageObjects.ConfirmationPage;
import com.omni.PageObjects.OrderHistoryPage;
import com.omni.PageObjects.ShoppingCart;

import ExtentReports.Retry;

@Listeners(com.omni.tests.Listeners.class)
public class StandAloneTest extends BaseTest {

    String email = "awdawdawdawddawd@gmail.com";
    String password = "QWERTY123#qwerty";
    String productName = "ZARA COAT 3";
    String country = "Por";
    String heroMessage = "Thankyou for the order.";

    @Test(groups = {"dependencies"}, retryAnalyzer = Retry.class)
    public void submitOrder() {

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

    @Test(dependsOnMethods = {"submitOrder"}, retryAnalyzer = Retry.class)
    public void orderHistory() {
        landingPage = launchApplication();
        landingPage.goTo();
        landingPage.login(email, password);
        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);
        orderHistoryPage.clickOnOrderHistory();
        Assert.assertEquals(productName, orderHistoryPage.getLastPurchaisedProduct());
    }

}
