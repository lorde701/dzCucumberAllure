package ru.company.tests.util;

import java.io.*;
import java.util.Properties;

/**
 * Created by Иванка on 27.10.2017.
 */
public class TestProperties {
    private final Properties properties = new Properties();
    private static TestProperties INSTANCE = null;

    private TestProperties() {
        try {
            InputStream in = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("appProp.properties");
            InputStreamReader inR = new InputStreamReader(in, "windows-1251");
            //properties.load(in);
            properties.load(inR);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TestProperties getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TestProperties();
        }
        return INSTANCE;
    }

    public Properties getProperties() {
        return properties;
    }
}
