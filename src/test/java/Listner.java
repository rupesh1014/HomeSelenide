import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Listner implements ITestListener {
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test Started : "+iTestResult.getName());

    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test Passed : "+iTestResult.getName());

    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test Failed : "+iTestResult.getName());
        File src= ((TakesScreenshot)getWebDriver()).getScreenshotAs(OutputType.FILE);
        try {
            // now copy the  screenshot to desired location using copyFile //method
            FileUtils.copyFile(src, new File("C:\\Users\\Rupesh\\IdeaProjects\\WebUI\\build\\reports\\tests"+iTestResult.getName()+"error.png"));
        }
        catch (Exception e){

        }

    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
