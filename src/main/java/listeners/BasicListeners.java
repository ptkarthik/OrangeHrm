package listeners;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebElement;
import org.testng.*;
import utilitiespackage.BasicUtilities;

import java.io.IOException;

public class BasicListeners extends TestListenerAdapter implements ITestListener, IRetryAnalyzer  {

    public static ThreadLocal<WebElement> getElementToCapture() {
        return elementToCapture;
    }

    private static ThreadLocal<WebElement> elementToCapture = new ThreadLocal<>();

    // Set the element to be captured for the current thread
    public static void setElementToCapture(WebElement element) {
        elementToCapture.set(element);
    }
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
        Allure.addAttachment("The Test case is success",result.getTestName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        basicUtilities.takeScreenShot(result);
        Throwable exception = result.getThrowable();
        Allure.addAttachment("The Test result",exception.getMessage());
    }


//    public void onTestFailure(ITestResult result) {
//
//        try {
//            basicUtilities.takeScreenshotUsingAShot(result);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Override
    public boolean retry(ITestResult iTestResult) {

        if (!iTestResult.isSuccess() && retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }

}
