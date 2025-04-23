package com.omni.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omni.AbstractComponents.AbstractComponents;

public class CatalogPage extends AbstractComponents {

    WebDriver driver;

    public CatalogPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By spinner = By.cssSelector("div[class='ngx-spinner-overlay ng-tns-c31-1 ng-trigger ng-trigger-fadeIn ng-star-inserted']");
    By toasMessage = By.cssSelector("toast-container");

    @FindBy(css = "div[class*='col-lg-4']")
    List<WebElement> productList;
    By productListBy = By.cssSelector("div[class*='col-lg-4']");

    @FindBy(css = "button[class='btn w-10 rounded']")
    WebElement buttonAdd;
    By buttonAddBy = By.cssSelector("button[class='btn w-10 rounded']");

    @FindBy(css = "[routerlink='/dashboard/cart']")
    WebElement cartButton;

    public List<WebElement> getProductList() {
        waitForElementoToAppear(productListBy);
        return productList;
    }

    public void addToCart(String productName) {
        WebElement product = productList.stream().filter(prod -> prod.findElement(By.cssSelector("b"))
                .getText().equals(productName)).findFirst().orElse(null);
        product.findElement(buttonAddBy).click();
        waitForElementoToDissapear(spinner);
        waitForElementoToDissapear(toasMessage);
        cartButton.click();
    }
}
