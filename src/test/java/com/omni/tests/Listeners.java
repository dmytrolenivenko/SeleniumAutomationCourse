package com.omni.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ExtentReports.ExtentReportTestDemo;

public class Listeners extends BaseTest implements ITestListener {

    ExtentTest test;
    ExtentReports extent = ExtentReportTestDemo.getExtentReports();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

     @Override
    public WebDriver initializeDriver() {
        return super.initializeDriver();
    }

    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
        extent.flush();
    }
    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
        //ITestListener.super.onStart(context);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String path = null;
        WebDriver driver = null;    
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        extentTest.get().fail(result.getThrowable());
        try {
            path = getScreenshot(result.getMethod().getMethodName(), driver);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        test.addScreenCaptureFromPath(path);
    }

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        //ITestListener.super.onTestStart(result);
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        //ITestListener.super.onTestSuccess(result);
        extentTest.get().log(Status.PASS, "Well done");
    }

}
