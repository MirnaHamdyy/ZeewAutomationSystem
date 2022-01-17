package eu.zeewscript.SeleniumUtility;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

    public static final boolean isNewStore = false;

    static Properties prop = new Properties();

    private final static String PROP_DEVFILE_LOCACTION = "C:\\Users\\merna\\Projects\\zeew\\superadmin\\src\\test\\resources\\config properties\\";

    static {
        System.out.println(System.getProperties());
        System.out.println("static blcok");
        try (InputStream input = new FileInputStream(PROP_DEVFILE_LOCACTION + System.getenv("CONFIG_FILE_NAME"))) {
            prop.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (isNewStore) {
            //generate 5 characters then convert them to the lower case
            String randomPart = RandomStringUtils.randomAlphabetic(3).toLowerCase();
            String platformName = ("pharmacy-" + randomPart);
            prop.put("platformName", platformName);
            prop.put("storeUrl", "https://" + platformName + ".deliveryscripts.com/superadmin/users/onboarding?conversion=success");
            //prop.put("storeUrl", "https://" + platformName + ".zeew.eu/superadmin/users/onboarding?conversion=success");

            //prop.put("storeEmail", "mirna"+randomPart + "@zeew.eu");
            prop.put("email", "user" + randomPart + "@zeew.eu");

            //To run already existing subscriber on SAAS dev
        } else {
            // set real store (already subscribed meant for testing team) values
            //prop.put("storeName", "AutomatedStore");
            // prop.put("storeUrl", "https://automated-store.deliveryscripts.com/superadmin/dashboard");
            //prop.put("storeEmail", "...");
            //  prop.put("email", "...");

        }
/*
            //To run already existing subscriber on SAAS dev

 } else {
            // set real store (already subscribed meant for testing team) values
            prop.put("storeName", "AutomatedStore");
            prop.put("storeUrl", "https://automated-store.deliveryscripts.com/superadmin/dashboard");
            prop.put("storeEmail", "...");
            prop.put("email", "...");

        }
 */
    }

    public static String getPropertyValue(String key) {
        // System.out.println("get property value");
        return prop.getProperty(key);
    }
}