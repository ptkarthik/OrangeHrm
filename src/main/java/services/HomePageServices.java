package services;

import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import utilitiespackage.BasicUtilities;

public class HomePageServices {
HomePage homePage = new HomePage();
BasicUtilities basicUtilities = new BasicUtilities();
    public void navigateToRightTopMenu() {
        basicUtilities.genericWebDriverWait(homePage.getRightMenu());
        basicUtilities.clickWithJs(homePage.getRightMenu());
        basicUtilities.genericWebDriverWait(homePage.getSupportLink());
        basicUtilities.clickWithJs(homePage.getSupportLink());
    }
}
