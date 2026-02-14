package pages;

    import io.appium.java_client.AppiumBy;
    import io.appium.java_client.android.AndroidDriver;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebElement;

    import utils.WaitUtils;

    public class HomePage {

        private final AndroidDriver driver;

        // === Potential selectors (update after inspecting on your device) ===
        private final By btnContinueLang = AppiumBy.androidUIAutomator("new UiSelector().textContains(Continue)");
        private final By btnSkipLogin   = AppiumBy.androidUIAutomator("new UiSelector().textContains(Skip)");
        private final By btnDenyLocation= AppiumBy.androidUIAutomator("new UiSelector().textContains(Don\'t Allow)");
        private final By btnDenyNotif   = AppiumBy.androidUIAutomator("new UiSelector().textContains(Not now)");

        // Search box / icon (verify ids via Inspector on your app version)
        private final By searchContainer = By.id("com.flipkart.android:id/search_widget_textbox");
        private final By searchEditBox   = By.id("com.flipkart.android:id/search_autoCompleteTextView");

        public HomePage(AndroidDriver driver) {
            this.driver = driver;
        }

        public void handleStartupPopupsIfAny() {
            tryClick(btnContinueLang, 3);
            tryClick(btnSkipLogin, 3);
            tryClick(btnDenyLocation, 2);
            tryClick(btnDenyNotif, 2);
        }

        public void searchFor(String query) {
            WaitUtils.waitForVisible(driver, searchContainer, 10).click();
            WebElement edit = WaitUtils.waitForVisible(driver, searchEditBox, 10);
            edit.sendKeys(query + ""); // press Enter
        }

        private void tryClick(By by, int timeoutSeconds) {
            try {
                WebElement e = WaitUtils.waitForVisible(driver, by, timeoutSeconds);
                e.click();
            } catch (Exception ignored) { }
        }
    }