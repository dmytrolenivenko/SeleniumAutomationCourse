package com.omni.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omni.AbstractComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents {

    WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[placeholder='Select Country']")
    WebElement slectCountryInput;

    @FindBy(css = "a[class='btnn action__submit ng-star-inserted']")
    WebElement placeOrderButton;
    
    public void checkOut(String country) {
        slectCountryInput.sendKeys(country);
        waitForElementoToBeClickable(By.cssSelector("section[class='ta-results list-group ng-star-inserted'] button"));
        List <WebElement> countryList = this.driver.findElements(By.cssSelector("section[class='ta-results list-group ng-star-inserted'] button"));
        for (WebElement c : countryList) {
            if (c.getText().contains(country)){
                c.click();
                break;
            }
        }

    }
    public void placeOrderClick() {
        placeOrderButton.click();
    }

    
}