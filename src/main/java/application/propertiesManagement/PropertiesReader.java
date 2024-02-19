package application.propertiesManagement;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private static final String PROPERTIES_FOLDER = "src/main/resources/project.properties";

    public static String getFromProjectProperties(String key) {

        String value = null;
        try(InputStream inputStream = new FileInputStream(String.format(PROPERTIES_FOLDER))){
            Properties prop = new Properties();
            prop.load(inputStream);
            value = prop.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

}
