package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:allurelogin.properties")
public interface TestOpsConfig extends Config {
    String username();

    String password();

    String token();
}