package utilitiespackage;

import driver.DriverCreator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BasicUtilities {

    public void clickWithJs(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverCreator.getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public void takeScreenShot(ITestResult result) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) DriverCreator.getDriver();
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("mm-dd-yyyy");
        String dateTimeNow = localDateTime.format(dateTimeFormatter);
        Path path = new File(System.getProperty("user.dir") + "/screenshots/" +
                result.getName() + "__" + dateTimeNow + "__" + createRandomLong() + ".png").toPath();
        try {
            Files.copy(screenShotFile.toPath(), path);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public long createRandomLong() {
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextLong(1, 10000);
    }
}
