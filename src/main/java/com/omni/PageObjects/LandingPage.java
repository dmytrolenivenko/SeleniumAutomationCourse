package com.omni.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omni.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

    WebDriver driver;
    String url = "https://rahulshettyacademy.com/client";

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userPassword")
    WebElement userPassword;

    @FindBy(id = "login")
    WebElement loginBtn;

    @FindBy(id = "toast-container")
    WebElement errorToast;

    public CatalogPage login(String email, String password) {
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        loginBtn.click();
        CatalogPage catalogPage = new CatalogPage(driver);
        return catalogPage;
    }

    public String getErrorMessage() {
        waitForWebElementoToAppear(errorToast);
        return errorToast.getText();
    }

    public void goTo() {
        driver.get(url);
    }

}
