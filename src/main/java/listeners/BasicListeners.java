package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilitiespackage.BasicUtilities;

public class BasicListeners implements ITestListener, IRetryAnalyzer {
    int retryCount=0;
    int maxRetryCount=2;
    BasicUtilities basicUtilities = new BasicUtilities();
    @Override
    public void onStart(ITestContext context) {
        System.out.println("Starting the " + context.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName() + " is Success");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        basicUtilities.takeScreenShot(result);
    }

    @Override
    public boolean retry(ITestResult iTestResult) {

        if (!iTestResult.isSuccess() && retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }

}
