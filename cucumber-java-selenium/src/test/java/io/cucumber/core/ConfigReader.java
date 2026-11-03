package io.cucumber.core;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static String getProperty(String key) {

        Properties prop = new Properties();

        try {
            FileInputStream file = new FileInputStream(
                "src/test/resources/config/config.properties"
            );

            prop.load(file);
            file.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return prop.getProperty(key);
    }
}