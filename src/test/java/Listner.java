import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listner implements ITestListener {
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test Started : "+iTestResult.getName());

    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test Passed : "+iTestResult.getName());

    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test Failed : "+iTestResult.getName());

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
