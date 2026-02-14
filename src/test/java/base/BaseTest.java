package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.appium.java_client.android.AndroidDriver;
import utils.DriverFactory;

public class BaseTest {

    @Parameters({ "udid", "deviceName", "appiumServerUrl",
                  "useApk","apkPath", "appPackage", "appActivity" })
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("adb-df6e2fe6-ufXVqf._adb-tls-connect._tcp") String udid,
                      @Optional("OnePlus AC2001 API 31") String deviceName,
                      @Optional("http://127.0.0.1:4723") String appiumServerUrl,
                      @Optional("true") String useApk,
                    //  @Optional("ignoreHiddenApiPolicyError")String amend,
                      @Optional("C:\\\\Users\\\\gajinath\\\\OneDrive - Capgemini\\\\Desktop\\\\Automation\\\\APK's\\\\Flipkart.apk") String apkPath,
                      @Optional("com.flipkart.android") String appPackage,
                      @Optional("activity.HomeFragmentHolderActivity") String appActivity) throws Exception {

        boolean useApkBool = Boolean.parseBoolean(useApk);
        DriverFactory.initDriver(udid, deviceName, appiumServerUrl, useApkBool,apkPath, appPackage, appActivity);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    public AndroidDriver driver() {
        return DriverFactory.getDriver();
    }
}