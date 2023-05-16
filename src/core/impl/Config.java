package core.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static Config _instance;

    private Properties properties;

    public static final String CONFIG_FILE_PATH = "config.properties";

    public static void main(String ...args) {
        Config config = getInstance();

        String value = Config.get("key");
        Config.get("key");
    }

    private Config() {
        properties = new Properties();

        try {
            InputStream fileInputStream = getClass()
                    .getClassLoader()
                    .getResourceAsStream(CONFIG_FILE_PATH);

            properties.load(fileInputStream);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static Config getInstance() {
        if (_instance == null) {
            _instance = new Config();
        }

        return _instance;
    }

    public static String get(String key) {
        return getInstance()
                .getProperties()
                .getProperty(key);
    }

    /*
        Getters & Setters
     */

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
