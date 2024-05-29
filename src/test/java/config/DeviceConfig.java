package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${platform}.properties")
public interface DeviceConfig extends Config {

    @Key("device")
    String device();

    @Key("os_version")
    String osVersion();

    @Key("project")
    String project();

    @Key("build")
    String build();

    @Key("name")
    String name();
    @Key("automationName")
    String automationName();
}