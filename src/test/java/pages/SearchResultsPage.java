package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SearchResultsPage {

    private final AndroidDriver driver;

    // Example locator (confirm with Appium Inspector for your version)
    private final By productTitle = By.id("com.flipkart.android:id/tv_product_title");

    public SearchResultsPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean hasResults() {
        try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
        List<WebElement> items = driver.findElements(productTitle);
        return items != null && !items.isEmpty();
    }
}