package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PropertyUrls {

    BS_HUB("http://hub.browserstack.com/wd/hub"),
    LOCAL_HUB("http://localhost:4723/wd/hub"),
    APK_DOWNLOAD_URL("https://github.com/wikimedia/apps-android-wikipedia/releases/download/latest/app-alpha-universal-release.apk");

    private String propertyLink;
}
