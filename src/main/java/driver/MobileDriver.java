package driver;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MobileDriver {


    public static final String USERNAME = "cristianmira1";
    public static final String AUTOMATE_KEY = "yjfSF9yFgrjxe7is5z2f";

    public static void main(String[] args) throws Exception {


    }

    public void enterToGoogleInDevice() throws InterruptedException {
        AndroidDriver driver = setUpMobileDriver();
        AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search Wikipedia")));
        searchElement.click();
        AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
        insertTextElement.sendKeys("BrowserStack");
        Thread.sleep(5000);
        List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
        assert (allProductsName.size() > 0);
        driver.quit();
    }


    public AndroidDriver<AndroidElement> setUpMobileDriver() {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("device", "Samsung Galaxy S8");
            caps.setCapability("os_version", "7.0");
            caps.setCapability("project", "My First Project");
            caps.setCapability("build", "My First Build");
            caps.setCapability("name", "Bstack-[Java] Sample Test");
            caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
            return new AndroidDriver<AndroidElement>(new URL("https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub"), caps);


        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }

    }


}

