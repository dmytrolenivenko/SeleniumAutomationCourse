package com.omni.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omni.AbstractComponents.AbstractComponents;

public class ShoppingCart extends AbstractComponents {

    WebDriver driver;

    public ShoppingCart(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button[routerlink*='/dashboard/cart']")
    WebElement cartButton;

    @FindBy(css = "div[class='subtotal cf ng-star-inserted'] button")
    WebElement checkOutButton;

    public void goToCart() {
        cartButton.click();
    }

    public void checkOutButtonClick() {
        checkOutButton.click();
    }

    public boolean cartVerifyProducts(String productName) {
        boolean match = this.driver.findElement(By.cssSelector("div[class='infoWrap'] h3")).getText().matches(productName);
        return match;
    }

}
