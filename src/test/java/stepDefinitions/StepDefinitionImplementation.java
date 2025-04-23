package stepDefinitions;

import org.testng.Assert;

import com.omni.PageObjects.CatalogPage;
import com.omni.PageObjects.CheckOutPage;
import com.omni.PageObjects.ConfirmationPage;
import com.omni.PageObjects.LandingPage;
import com.omni.PageObjects.ShoppingCart;
import com.omni.tests.BaseTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImplementation extends BaseTest {

    LandingPage landingPage;
    CatalogPage catalogPage;
    ShoppingCart shoppingCart = new ShoppingCart(driver);
    CheckOutPage checkOutPage = new CheckOutPage(driver);
    ConfirmationPage confirmationPage = new ConfirmationPage(driver);

    @Given("I landed on the Main Page")
    public void i_landed_on_the_Main_Page() {
        landingPage = launchApplication();
    }

    @Given("^I logged with email (.+) and password (.+)$")
    public void i_logged_with_email_and_password(String email, String password) {
        catalogPage = landingPage.login(email, password);
    }

    @When("^I added product (.+) to Cart$")
    public void i_added_product_to_Cart(String productName) {
        catalogPage.addToCart(productName);
    }

    @And("^I Checkout (.+) and submit the order$")
    public void i_Checkout_and_submit_the_orders(String productName) {
        catalogPage.getProductList();
        catalogPage.addToCart(productName);
        shoppingCart.goToCart();
        shoppingCart.checkOutButtonClick();
        //checkOutPage.checkOut(country);
        checkOutPage.placeOrderClick();
    }

    @Then("The message {heroMessage} is displayed")
    public void the_message_is_displayed(String heroMessage) {
        Assert.assertEquals(confirmationPage.getHeroMessage().toLowerCase(), heroMessage.toLowerCase());
    }

    @Then("Error message 'Incorrect email or password.' displayed")
    public void error_message_displayed() {
        Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email or password.");
    }

}
