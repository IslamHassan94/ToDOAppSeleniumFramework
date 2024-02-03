package com.qacart.todo.utils;

import java.io.*;
import java.util.Properties;

public class PropertiesUtil {
    public static Properties loadProperties(String filePath) {
        File file = new File(filePath);
        try {
            InputStream inputStream = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
            return properties;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        } catch (IOException e) {
            throw new RuntimeException("Error while loading the properties");
        }
    }
}
