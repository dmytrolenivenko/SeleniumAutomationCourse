package com.omni.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {

    WebDriver driver;
    WebDriverWait wait;
    
    @FindBy(css = "tbody > tr:nth-child(1) > td:nth-child(3)")
    WebElement orderHistoryButton;

    public void clickOnOrderHistory() {
        waitForWebElementoToAppear(orderHistoryButton);
        orderHistoryButton.click();
    }
    public AbstractComponents(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }
    public void waitForElementoToAppear(By findBy) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
    public void waitForWebElementoToAppear(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementoToBeClickable(By findBy) {
        wait.until(ExpectedConditions.elementToBeClickable(findBy));
    }
    public void waitForElementoToDissapear(By findBy) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }
    
}