package DataProviders;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider
    public Object[][] sendingData() {

        String[][] stringArray = new String[2][2];
        stringArray[0][0] = "Admin";
        stringArray[0][1] = "admin123";
        stringArray[1][0] = "Admin";
        stringArray[1][1] = "admin123";
        return stringArray;
    }
}
