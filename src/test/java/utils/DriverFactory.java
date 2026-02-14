package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.URL;
import java.time.Duration;

public class DriverFactory {

    private static ThreadLocal<AndroidDriver> tlDriver = new ThreadLocal<>();

    public static void initDriver(String udid,
                                  String deviceName,
                                  String appiumServerUrl,
                                  boolean useApk,
                                  String apkPath,
                                  String appPackage,
                                  String appActivity) throws Exception {

        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid(udid == null ? "" : udid)
                .setDeviceName(deviceName == null || deviceName.isEmpty() ? "Android Emulator" : deviceName)
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setNewCommandTimeout(Duration.ofSeconds(180));

        // Pass-through capabilities not covered by convenience setters
        options.amend("autoGrantPermissions", true);
        options.amend("ignoreHiddenApiPolicyError",true);

        if (useApk && apkPath != null && !apkPath.isEmpty()) {
            options.setApp(apkPath);
        } else {
            if (appPackage != null && !appPackage.isEmpty()) {
                options.setAppPackage(appPackage);
            }
            if (appActivity != null && !appActivity.isEmpty()) {
                options.setAppActivity(appActivity);
            }
        }

        AndroidDriver driver = new AndroidDriver(new URL(appiumServerUrl), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        tlDriver.set(driver);
    }

    public static AndroidDriver getDriver() {
        return tlDriver.get();
    }

    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}