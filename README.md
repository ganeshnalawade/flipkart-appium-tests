# Flipkart Appium Tests (Eclipse + Maven + TestNG)

This project launches the Flipkart Android app and runs a sample search test using Appium + TestNG with a simple Page Object Model.

## Prerequisites

- Java 11+ (JDK)
- Android SDK / Platform Tools on PATH (`adb`)
- Node.js and Appium Server **3.2.0** (your version)
- Appium UiAutomator2 driver: `appium driver install uiautomator2`
- Device/emulator running

## Project structure

```
src/test/java
  ├─ base/BaseTest.java
  ├─ pages/HomePage.java
  ├─ pages/SearchResultsPage.java
  ├─ tests/SearchTest.java
  └─ utils/...
src/test/resources
  └─ testng.xml
pom.xml
```

## Configure

- `testng.xml` is pre-set to use an APK install with your Windows path:
  `C:\Users\gajinath\OneDrive - Capgemini\Desktop\Automation\APK's\Flipkart.apk`
- If you run an emulator, set `udid` to e.g. `emulator-5554` (run `adb devices` to confirm).

## Run

Start Appium and the emulator, then:

```bash
mvn clean test -Dudid=emulator-5554 -DdeviceName="Android Emulator" -DappiumServerUrl=http://127.0.0.1:4723
```

You can also edit parameters directly in `src/test/resources/testng.xml`.

## Notes

- Flipkart changes resource-ids over time; if a locator fails, open Appium Inspector and update the locator in the page classes.
- For fresh installs every run, keep `useApk=true`. To attach to an already-installed app, set `useApk=false` and provide `appPackage`/`appActivity`.
- Add reporting (Allure/Extent) and parallel runs later if needed.