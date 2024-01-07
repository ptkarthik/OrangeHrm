package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class HomePage extends BasePage{
    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    private WebElement rightMenu;

    @FindBy(xpath = "(//a[@class='oxd-userdropdown-link'])[2]")
    private WebElement supportLink;

}
