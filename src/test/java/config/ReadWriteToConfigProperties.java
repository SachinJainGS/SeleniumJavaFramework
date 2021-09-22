package config;

import Tests.Browsersetinpropfile_Googlesearch;

import java.io.*;
import java.util.Properties;

public class ReadWriteToConfigProperties {

    static  Properties properties = new Properties();
    private  static String filelocation = System.getProperty("user.dir");
    static String Browser;

    public static void main(String[] args) {
        readfrompropertiesfile();
        writetopropertiesfile();

    }

    public static void readfrompropertiesfile() {

        InputStream input = null;
        try {
            input = new FileInputStream(filelocation+"/src/test/java/config/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Reading from file - Browser name is : "+properties.getProperty("browser"));
        Browser = properties.getProperty("browser");
        Browsersetinpropfile_Googlesearch.browsername = Browser;
    }

    public static void writetopropertiesfile() {
        OutputStream output = null;
        try {
            output = new FileOutputStream(filelocation+"/src/test/java/config/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        properties.setProperty("Result","PASS");
        try {
            properties.store(output,"Properties file updated");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println("Writing to file - Browser name updated is : "+properties.getProperty("browser"));
    }
}
