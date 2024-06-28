package configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropLoaderForRestAssured {

    public static Properties loadPropertyForApi() {
        Properties properties = new Properties();
        FileInputStream fis;
        String filePath = System.getProperty
                ("user.dir") + "/src/main/resources/detailsxml.properties";
        try {
            fis = new FileInputStream(filePath);
            properties.load(fis);
        } catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

}
