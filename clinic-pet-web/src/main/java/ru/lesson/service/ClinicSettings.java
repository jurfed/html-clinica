package ru.lesson.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ClinicSettings {
    private static final ClinicSettings SETTINGS = new ClinicSettings();
    private final Properties properties = new Properties();

    private ClinicSettings(){
        try{
            properties.load(new FileInputStream(this.getClass().getClassLoader().getResource("clinicBd.properties").getFile()));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static ClinicSettings getSETTINGS() {
        return SETTINGS;
    }

    public String values(String key){
        return this.properties.getProperty(key);
    }
}
