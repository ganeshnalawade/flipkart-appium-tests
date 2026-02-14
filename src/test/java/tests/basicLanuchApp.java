package tests;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class basicLanuchApp {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        // Options for Appium
        UiAutomator2Options options = new UiAutomator2Options();

        // DEVICE DETAILS
        options.setDeviceName("OnePlus AC2001 API 31");   // or your device name
        options.setUdid("adb-df6e2fe6-ufXVqf._adb-tls-connect._tcp");            // use adb devices to confirm UDID
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        // APP DETAILS
       // options.setApp("C:\\Users\\gajinath\\OneDrive - Capgemini\\Desktop\\Automation\\APK's\\Flipkart.apk");
       options.setAppPackage("com.flipkart.android");
       options.setAppActivity("activity.HomeFragmentHolderActivity");

    // Pass-through for capabilities not exposed as typed setters
    options.amend("ignoreHiddenApiPolicyError", true);
    // (Optional) keep app/data as-is between runs
    options.amend("noReset", true);


        // Appium Server URL
        URL appiumServer = new URL("http://127.0.0.1:4723");

        // Start session
        AndroidDriver driver = new AndroidDriver(appiumServer, options);

        System.out.println("App launched successfully!");

        Thread.sleep(5000);

        driver.quit();
    }
}
