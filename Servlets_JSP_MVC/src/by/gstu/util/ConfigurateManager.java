package by.gstu.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigurateManager {
    private static ConfigurateManager instance;
    private ConfigurateManager() {
    }

    public synchronized static ConfigurateManager getInstance() {
        if (instance == null) {
            instance = new ConfigurateManager();
        }
        return instance;
    }

    public String getProperty(String key) {
        switch (key){
            case "readAll":
                return "select * from readers";
            default:
                return null;
        }
    }
}
