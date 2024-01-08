package utilitiespackage;

import driver.DriverCreator;
import listeners.BasicListeners;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.SecureRandom;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

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
        try {
            Files.copy(screenShotFile.toPath(), new File(System.getProperty("user.dir") + "/screenshots/" +
                    result.getName() +"_"  + createRandomLong()+"_"+dateTimeNow  + ".png").toPath());
        } catch ( Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void takeScreenshotUsingAShot(ITestResult result) throws IOException {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("mm-dd-yyyy");
        String dateTimeNow = localDateTime.format(dateTimeFormatter);
        AShot ashot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000));
        Screenshot screenshot = ashot.takeScreenshot(DriverCreator.getDriver(),
                BasicListeners.getElementToCapture().get());
        ImageIO.write(screenshot.getImage(),"PNG", new File((System.getProperty("user.dir") +
                "/screenshots/" +
                result.getName() + "__" + dateTimeNow + "__" + createRandomLong())));
    }

    public long createRandomLong() {
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextLong(1, 10000);
    }

    public void mouseHover(WebElement element) {
        Actions actions= new Actions(DriverCreator.getDriver());
        actions.moveToElement(element).build().perform();
    }

    public void genericWebDriverWait(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(DriverCreator.getDriver(), Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void visibilityWebDriverWait(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(DriverCreator.getDriver(), Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
}
