package Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;


public class TestLog4j {

   static Logger logger = LogManager.getLogger(TestLog4j.class);

    public static void main(String[] args) {
        System.out.println("Started Testing Log4J");
        try {
            logger.info("This is information message");
            logger.error("This is Error message");
            logger.warn("This is Warning message");
            logger.fatal("This is Fatal message");
            int i = 1/0;
            logger.error("this is an error");
        }
        catch (Exception e) {
            System.out.println("Exception Catched");
            System.out.println("Cause of exception : " + e.getCause());
            System.out.println("Message of exception : " + e.getMessage());
            System.out.println("Full details of exception : " + e.getStackTrace());
        }
        finally {
            System.out.println("Try and catch test completed");
        }
    }
}
