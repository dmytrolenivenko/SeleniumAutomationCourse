package com.omni.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.omni.tests.Listeners.class)
public class ErrorVlaidation extends BaseTest{

    @Test
    public void wrongLogin() {
        launchApplication();
        landingPage.goTo();
        landingPage.login("wrong@email.com", "wrongpassword");
        Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email or password.");
    }   
    

}
