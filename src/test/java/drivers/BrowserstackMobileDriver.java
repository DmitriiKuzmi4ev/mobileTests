package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import config.DeviceConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    public static URL getAppiumServerUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static final DeviceConfig deviceConfig = ConfigFactory.create(DeviceConfig.class, System.getProperties());
    private static final BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class);

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        mutableCapabilities.setCapability("browserstack.user", config.username());
        mutableCapabilities.setCapability("browserstack.key", config.accessKey());
        mutableCapabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
        mutableCapabilities.setCapability("device", deviceConfig.device());
        mutableCapabilities.setCapability("os_version", deviceConfig.osVersion());
        mutableCapabilities.setCapability("automationName", deviceConfig.automationName());
        mutableCapabilities.setCapability("project", deviceConfig.project());
        mutableCapabilities.setCapability("build", deviceConfig.build());
        mutableCapabilities.setCapability("name", deviceConfig.name());

        return new RemoteWebDriver(getAppiumServerUrl(), mutableCapabilities);
    }
}
