package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public interface BrowserstackConfig extends Config {
    @Key("browserstack.username")
    String username();

    @Key("browserstack.access_key")
    String accessKey();
}
