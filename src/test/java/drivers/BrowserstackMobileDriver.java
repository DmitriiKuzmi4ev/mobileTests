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

import static enums.CapabilityName.*;
import static enums.PropertyUrls.BS_HUB;

public class BrowserstackMobileDriver implements WebDriverProvider {

    public static URL getAppiumServerUrl() {
        try {
            return new URL(BS_HUB.getPropertyLink());
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
        mutableCapabilities.setCapability(USER_LOGIN.getCaps(), config.username());
        mutableCapabilities.setCapability(USER_PASSWORD.getCaps(), config.accessKey());
        mutableCapabilities.setCapability(APP_URL.getCaps(), deviceConfig.app());
        mutableCapabilities.setCapability(DEVICE_MODEL.getCaps(), deviceConfig.device());
        mutableCapabilities.setCapability(OS_VERSION.getCaps(), deviceConfig.osVersion());
        mutableCapabilities.setCapability(AUTO_NAME.getCaps(), deviceConfig.automationName());
        mutableCapabilities.setCapability(PR_NAME.getCaps(), deviceConfig.project());
        mutableCapabilities.setCapability(BUILD_NAME.getCaps(), deviceConfig.build());
        mutableCapabilities.setCapability(TEST_NAME.getCaps(), deviceConfig.name());

        return new RemoteWebDriver(getAppiumServerUrl(), mutableCapabilities);
    }
}
