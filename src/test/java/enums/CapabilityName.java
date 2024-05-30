package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CapabilityName {

    USER_LOGIN("browserstack.user"),
    USER_PASSWORD("browserstack.key"),
    APP_URL("app"),
    DEVICE_MODEL("device"),
    OS_VERSION("os_version"),
    AUTO_NAME("automationName"),
    PR_NAME("project"),
    BUILD_NAME("build"),
    TEST_NAME("name");

    private String caps;
}
