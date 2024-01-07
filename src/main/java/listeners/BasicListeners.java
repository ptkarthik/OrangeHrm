package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilitiespackage.BasicUtilities;

public class BasicListeners implements ITestListener {
    BasicUtilities basicUtilities = new BasicUtilities();
    @Override
    public void onStart(ITestContext context) {
        System.out.println("Starting the " + context.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getTestName() + " is Success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        basicUtilities.takeScreenShot(result);
    }
}
