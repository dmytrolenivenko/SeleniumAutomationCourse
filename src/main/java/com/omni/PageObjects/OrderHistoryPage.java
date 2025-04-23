package com.omni.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omni.AbstractComponents.AbstractComponents;

public class OrderHistoryPage extends AbstractComponents {

    WebDriver driver;

    public OrderHistoryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "tbody > tr:nth-child(1) > td:nth-child(3)")
    WebElement lastPurchaisedProduct;

    @FindBy(css = "[routerlink='/dashboard/myorders']")
    WebElement orderHistoryButton;

    public void clickOnOrderHistory() {
        waitForWebElementoToAppear(orderHistoryButton);
        orderHistoryButton.click();
    }

    public String getLastPurchaisedProduct() {
        return lastPurchaisedProduct.getText();
    }
}
