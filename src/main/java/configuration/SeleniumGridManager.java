package configuration;

import java.io.IOException;

public class SeleniumGridManager {

    // Paths to the Selenium server JAR file
    private static final String SELENIUM_SERVER_PATH = "C:/Users/karthikeyan_thangave/Downloads/" +
            "selenium-server-4.26.0.jar";

    // Start the Selenium Hub
    static {
        ProcessBuilder hubBuilder = new ProcessBuilder(
                "java", "-jar", SELENIUM_SERVER_PATH, "standalone"
        );
        hubBuilder.inheritIO(); // Inherit IO to see output in the console
        try {
            hubBuilder.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Selenium Hub started on http://localhost:4444");
    }
}