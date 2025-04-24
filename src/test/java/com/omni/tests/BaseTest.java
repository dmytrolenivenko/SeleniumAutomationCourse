package com.omni.tests;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.omni.PageObjects.LandingPage;

public class BaseTest {

    LandingPage landingPage;
    public WebDriver driver;

    public WebDriver initializeDriver() {
        EdgeOptions options = new EdgeOptions();
        //options.addArguments("headless");
        driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();
        return driver;
    }

    public LandingPage launchApplication() {
        driver = initializeDriver();
        landingPage = new LandingPage(driver);
        landingPage.goTo();
        return landingPage;
    }

    @AfterMethod
    public void closeDriver() {
        driver.close();
    }

    public List<HashMap<String, String>> jsonToHashMap(String path) throws IOException {
        String jsonContent = FileUtils.readFileToString(new File(path), Charset.defaultCharset());
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }

    public String getScreenshot(String testCaseName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String folderPath = "C:/Users/dmytro.lenivenko/OneDrive - Hive Group/Desktop/Nova pasta code/SeleniumCourse/SeleniumProject1/seleniume2e/src/test/java/testData/";
        File destination = new File(folderPath  + "/screenshots/" + testCaseName + ".png");
        FileUtils.copyFile(source, destination);
        return destination.getAbsolutePath();
    }
}
