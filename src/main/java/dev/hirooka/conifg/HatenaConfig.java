package dev.hirooka.conifg;

import io.quarkus.arc.config.ConfigProperties;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ConfigProperties(prefix = "hatena")
public interface HatenaConfig {

    @ConfigProperty(name = "api.key")
    String apiKey();

    @ConfigProperty(name = "username")
    String username();

    @ConfigProperty(name = "api.endpoint")
    String apiEndpoint();
}
