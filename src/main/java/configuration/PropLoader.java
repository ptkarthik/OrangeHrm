package configuration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropLoader {


    public static Properties loadProperties() throws FileNotFoundException {
        Properties properties = new Properties();
        BufferedReader bufferedReader = null;
        String filePath = System.getProperty
                ("user.dir") + "/src/main/resources/configuration.properties";
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException f) {
            f.printStackTrace();
            throw new RuntimeException("The properties file not found" + filePath);
        }

        try {
            properties.load(bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load the Properties file: " + e);
        }

return properties;
    }

}
